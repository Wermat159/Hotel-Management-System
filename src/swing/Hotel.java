package swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hotel.Doubleroom;
//import hotel.Food;
import hotel.Guest;
import hotel.Room;
import hotel.Singleroom;
import hotel.Suite;

@SuppressWarnings("serial")
public class Hotel extends MainWindow implements ActionListener {

	private JButton btnCheckIn = new JButton("CHECK-IN");
	private JButton btnCheckOut = new JButton("CHECKOUT");
	private JButton btnFood = new JButton("FOOD");
	private JButton btnRooms = new JButton("ROOMS");
	private JButton btnStaff = new JButton("STAFF");
	private JButton btnGuestList = new JButton("GUEST LIST");
//	private HashMap<Integer, Guest> guestList = new HashMap<Integer, Guest>();
	private LinkedList<Guest> guestList = new LinkedList<Guest>(); 
	private HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
	private int count = 0;
	private CheckIn ci = new CheckIn(); // CHECK-IN WINDOW
	private int place; // ROOM NUMBER
	private HashMap<Integer, Integer> r2 = new HashMap<Integer, Integer>();
	private Room r = null;
	private RoomWindow rw = new RoomWindow(rooms, place); // ROOMS LIST WINDOW
	private FoodWindow fw = new FoodWindow(); // FOOD WINDOW
	private StaffWindow sw = new StaffWindow(); // STAFF WINDOW
	private CheckOut co = new CheckOut(guestList); // CHECK OUT WINDOW
	private GuestWindow gw = new GuestWindow(guestList); // GUEST LIST WINDOW
	private int id = 0;
	private JLabel areaName = new JLabel("\t\tSARRANID HOTEL");

	public Hotel() {
		/*
		 * ALL SIZES AND COMPONENTS ARE DECLARED HERE ALL LISTENERS ARE ADDED HERE
		 * 
		 */
		add(btnCheckIn).setPreferredSize(new Dimension(300, 200));
		add(btnCheckOut).setPreferredSize(new Dimension(300, 200));
		add(btnFood).setPreferredSize(new Dimension(300, 200));
		add(btnGuestList).setPreferredSize(new Dimension(300, 200));
		add(btnRooms).setPreferredSize(new Dimension(300, 200));
		add(btnStaff).setPreferredSize(new Dimension(300, 200));
		add(areaName).setPreferredSize(new Dimension(600,200));
		areaName.setFont(new Font("Arial", Font.BOLD, 65));
		btnCheckIn.addActionListener(this);
		btnFood.addActionListener(this);
		btnGuestList.addActionListener(this);
		ci.btnSubmit.addActionListener(this);
		btnRooms.addActionListener(this);
		btnStaff.addActionListener(this);
		btnCheckOut.addActionListener(this);
		co.btnCheckOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheckIn) {
			ci.setVisible(true);
		} else if (e.getSource() == ci.btnSubmit) {
			/*
			 * CHECK IF ALL FIELDS ARE COMPLETE IF FIELDS ARE NOT COMPLETE THEN SHOW ERROR
			 * POPUP
			 * 
			 * 
			 * ELSE TAKE ALL VALUES IN FIELDS AND COMPLETE CHECK-IN
			 * 
			 */
			if (checkForEmpty() == false) {
				JOptionPane.showMessageDialog(null, "All fields must be entered!");
			} else if (checkRegex() == false) {
				JOptionPane.showMessageDialog(null, "All fields must be entered with the correct values.");
			} else if (checkRooms() == false) {
				JOptionPane.showMessageDialog(null, "SINGLEROOMS: 100-299\nDOUBLEROOMS: 300-399\nSUITE: 400-410");
			} else if (checkIfAvailable() == false) {
				JOptionPane.showMessageDialog(null, "Room is not available.");
			} else if (calculateInvoice() == 0) {
				JOptionPane.showMessageDialog(null, "Please enter the dates correctly.");
			} else {
				addGuest();
				JOptionPane.showMessageDialog(null, "Check-in Successful!");
				ci.dispose();
				ci.txtName.setText("");
				ci.txtAddress.setText("");
				ci.txtContactNo.setText("");
				ci.txtRoomNumber.setText("");
				ci.datePickerCheckIn.clear();
				ci.datePickerCheckOut.clear();
			}
		} else if (e.getSource() == btnGuestList) {
			gw = new GuestWindow(guestList); // GUEST LIST WINDOW
			gw.setVisible(true);
		} else if (e.getSource() == btnRooms) { // OPEN ROOM LIST
			rw.roomWindowRefresh(rooms, place);
			rw.setVisible(true);
		} else if (e.getSource() == btnFood) { // OPEN FOOD LIST
			fw.setVisible(true);
		} else if (e.getSource() == btnStaff) { // OPEN STAFF LIST
			sw.setVisible(true);
		} else if (e.getSource() == btnCheckOut) { // OPEN CHECK OUT WINDOW
			co.setVisible(true);
		} else if (e.getSource() == co.btnCheckOut) { // INTERACT WITH CHECKOUT BUTTON INSIDE CHECK OUT WINDOW

			/*
			 * REMOVE GUEST FROM HASHMAPS AND MAKE ROOM AVAILABLE
			 * 
			 */
			int index = co.list.getSelectedIndex();
			Room room = co.list.getSelectedValue().getRoom();
			int roomNumber = room.getNumber();
			room.setEmpty(true);
			rooms.put(roomNumber, room);
			rw.roomWindowRefresh(rooms, index);
			r2.remove(roomNumber);
			co.dlm.remove(index);
			guestList.remove(index);
			count--;
		}
	}

	private void addGuest() {  // ADDING GUEST

		// TAKE ALL SPECIFIC FIELDS TO THE CORRESPONDING VALUES
		Guest g = new Guest();
		int temp = ci.cmbBox.getSelectedIndex() + 100;
		if (temp >= 100 && temp < 300) {
			r = new Singleroom(temp);
		} else if (temp >= 299 && temp < 400) {
			r = new Doubleroom(temp);
		} else {
			r = new Suite(temp);
		}
		g.setName(ci.txtName.getText());
		g.setAddress(ci.txtAddress.getText());
		g.setContactNo(ci.txtContactNo.getText());
		g.setArrivalDate(ci.datePickerCheckIn.getDateStringOrEmptyString()); // YYYY-MM-DD
		g.setLeaveDate(ci.datePickerCheckOut.getDateStringOrEmptyString()); // YYYY-MM-DD
		g.setRoomNumber(temp);
		g.setId(id + 1005);
		g.setRoom(r);
		g.setInvoice(roomPrice() * calculateInvoice());
		r.setEmpty(false);
		place = temp - 100;
		rooms.put(place, r);
		guestList.add(g);
		co.dlm.add(count, g);
		r2.put(temp, temp);
		ci.cmbBox.setSelectedIndex(0);
		rw.roomWindowRefresh(rooms, place);
		count++;
		id++;
	}

	private boolean checkForEmpty() { // CHECKS IF ALL FIELDS ARE COMPLETE
		if (ci.txtName.getText().isBlank() || ci.txtContactNo.getText().isBlank()
				|| ci.datePickerCheckIn.getDateStringOrEmptyString().isBlank()
				|| ci.datePickerCheckOut.getDateStringOrEmptyString().isBlank()) {
			return false;
		}
		return true;
	}

	private boolean checkRegex() { // CHECKS IF ALL FIELDS ARE FILLED APPROPRIATELY
		if (!ci.txtName.getText().matches("[A-Za-z\\s]+")) {
			return false;
		} else if (!ci.txtContactNo.getText().matches("\\d{6,}")) {
			return false;
		}
		return true;
	}

	private double roomPrice() { // SETS ROOM PRICE ACCORDINGLY
		if (ci.rdBtnSR.isSelected()) {
			return 150;
		} else if (ci.rdBtnDR.isSelected()) {
			return 300;
		} else if (ci.rdBtnSUITE.isSelected()) {
			return 500;
		}
		return 0;
	}

	private boolean checkRooms() { // COMMENTS INSIDE METHOD
		/*
		 * CHECKS IF CORRESPONDING ROOM NUMBER IS THE CORRECT TYPE OF ROOM EG.
		 * SINGLEROOMS = 100-299 DOUBLEROOMS = 300-399 SUITES = 400-410 IF FOR SAY
		 * SINGLEROOM IS SELECTED AND ROOM NUMBER 400 IS SELECTED METHOD WILL RETURN
		 * FALSE ERROR MESSAGE WILL POP-UP
		 */
		int temp = ci.cmbBox.getSelectedIndex() + 100;
		if (ci.rdBtnSR.isSelected() && temp >= 100 && temp < 299) {
			return true;
		} else if (ci.rdBtnDR.isSelected() && temp >= 299 && temp < 400) {
			return true;
		} else if (ci.rdBtnSUITE.isSelected() && temp >= 399 && temp <= 410) {
			return true;
		}
		return false;
	}

	private boolean checkIfAvailable() { // CHECKS IF ROOM IS AVAILABLE
		int temp = ci.cmbBox.getSelectedIndex() + 100;
		if (r2.containsValue(temp)) {
			return false;
		}
		return true;
	}

	private double calculateInvoice() { // CALCULATE THE AMOUNT THE USER WILL PAY FOR DURING THEIR STAY

		int total = 0;

		String checkInDate = ci.datePickerCheckIn.getDateStringOrEmptyString();
		String checkOutDate = ci.datePickerCheckOut.getDateStringOrEmptyString();

		int yearCI = Integer.parseInt(checkInDate.split("-")[0]);
		int yearCO = Integer.parseInt(checkOutDate.split("-")[0]);

		int monthCI = Integer.parseInt(checkInDate.split("-")[1]);
		int monthCO = Integer.parseInt(checkOutDate.split("-")[1]);

		int dayCI = Integer.parseInt(checkInDate.split("-")[2]);
		int dayCO = Integer.parseInt(checkOutDate.split("-")[2]);

		int year = yearCO - yearCI;
		int month = monthCO - monthCI;
		int day = dayCO - dayCI;

		System.out.println(year);
		System.out.println(month);
		System.out.println(day);

		if (year > 0 && day < 0) {
			total = (year * 365) + (month * 30) + day;
		} else if (month > 0 && day < 0) {
			total = (year * 365) + (month * 30) + day;
		} else if (year < 0 || month < 0 || day < 0) {
			return 0;
		} else {
			total = (year * 365) + (month * 30) + day;
		}
		return total;
	}

}
