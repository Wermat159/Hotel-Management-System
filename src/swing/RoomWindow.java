package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import hotel.Doubleroom;
import hotel.Room;
import hotel.Singleroom;
import hotel.Suite;

@SuppressWarnings("serial")
public class RoomWindow extends JFrame {

	private DefaultListModel<Room> dlm = new DefaultListModel<Room>();
	private JList<Room> list = new JList<Room>(dlm);
	private JScrollPane scroll = new JScrollPane(list);

	/*
	 *  WINDOW FOR ROOM LIST
	 *  ROOMS ARE REFRESHED AFTER EVERY OPERATION ---->
	 *  CHECK-IN AND CHECKOUT 
	 */
	
	RoomWindow(HashMap<Integer, Room> rooms, int place) {
		addAllRooms();
		setSize(950, 500);
		setTitle("ROOMS");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Arial", Font.BOLD, 16));
		add(scroll);

	}

	public void roomWindowRefresh(HashMap<Integer, Room> rooms, int place) { //IS CALLED WHEN CHECK-IN IS DONE
		if (rooms.get(place) == null) {
			return;
		} else {
			dlm.setElementAt(rooms.get(place), place);
			rooms.remove(place);
		}
	}
	
	public void roomWindowRefresh(HashMap<Integer, Room> rooms, int place, boolean empty) { //IS CALLED WHEN CHECK-IN IS DONE
		if (rooms.get(place) == null) {
			return;
		} else {
			dlm.getElementAt(place).setEmpty(empty);
			rooms.remove(place);
		}
	}

	private void addAllRooms() { // ADD ROOMS TO QUEUE AND AFTER ADD ALL ELEMENTS IN ORDER TO LIST
		Queue<Room> q = new LinkedList<>();
		for (int i = 100; i < 411; i++) {
			if (i < 300) {
				Room temp = new Singleroom(i, 1, true, false);
				q.add(temp);
			} else if (i < 400) {
				Room temp2 = new Doubleroom(i, 2, true, false);
				q.add(temp2);
			} else {
				Room temp3 = new Suite(i, 4, true, true);
				q.add(temp3);
			}
		}
		for (int i = 100; i < 411; i++) {
			dlm.addElement(q.peek());
			q.remove();
		}
	}
}
