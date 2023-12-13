package swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

@SuppressWarnings("serial")
public class CheckIn extends JFrame implements ActionListener {

	private JLabel lblName = new JLabel("Name:");
	private JLabel lblAddress = new JLabel("Address:");
	private JLabel lblContactNo = new JLabel("Contact No:");
	private JLabel lblRoomNumber = new JLabel("Room Number:");
	private JLabel lblCheckInDate = new JLabel("Check-in Date:");
	private JLabel lblCheckOutDate = new JLabel("Checkout Date:");
	private JLabel lblRoomType = new JLabel("Room Type:");
	JTextField txtName = new JTextField();
	JTextField txtAddress = new JTextField();
	JTextField txtContactNo = new JTextField();
	JTextField txtRoomNumber = new JTextField();
	private Vector<Integer> vector = new Vector<Integer>();
	JComboBox<Integer> cmbBox = new JComboBox<Integer>(vector);
	JRadioButton rdBtnSR = new JRadioButton("SR");
	JRadioButton rdBtnDR = new JRadioButton("DR");
	JRadioButton rdBtnSUITE = new JRadioButton("SUITE");
	private ButtonGroup btnGroup = new ButtonGroup();
	private JPanel pnlName = new JPanel(new GridLayout(1, 2));
	private JPanel pnlAddress = new JPanel(new GridLayout(1, 2));
	private  JPanel pnlContactNo = new JPanel(new GridLayout(1, 2));
	private JPanel pnlRoomNumber = new JPanel(new GridLayout(1, 2));
	private JPanel pnlCheckInDate = new JPanel(new GridLayout(1, 2));
	private JPanel pnlCheckoutDate = new JPanel(new GridLayout(1, 2));
	private JPanel pnlRoomType = new JPanel(new GridLayout(1, 3));
	JButton btnSubmit = new JButton("SUBMIT");
	JButton btnClear = new JButton("CLEAR");
	private DatePickerSettings s = new DatePickerSettings();
	private DatePickerSettings s2 = new DatePickerSettings();
	DatePicker datePickerCheckIn = new DatePicker(s);
	DatePicker datePickerCheckOut = new DatePicker(s2);

	public CheckIn() {
		/*
		 * ALL SIZES AND COMPONENTS ARE DECLARED HERE ALL LISTENERS ARE ADDED HERE
		 * 
		 */
		setSize(600, 600);
		setTitle("CHECK-IN");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		pnlName.add(lblName);
		pnlName.add(txtName).setFont(new Font("Times New Roman", Font.BOLD, 18));
		pnlAddress.add(lblAddress);
		pnlAddress.add(txtAddress).setFont(new Font("Times New Roman", Font.BOLD, 18));
		pnlContactNo.add(lblContactNo);
		pnlContactNo.add(txtContactNo).setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		pnlRoomNumber.add(lblRoomNumber);
		pnlRoomNumber.add(cmbBox);
//		.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pnlRoomType.add(lblRoomType);
		pnlRoomType.add(rdBtnSR);
		pnlRoomType.add(rdBtnDR);
		pnlRoomType.add(rdBtnSUITE);
		pnlCheckInDate.add(lblCheckInDate);
		pnlCheckInDate.add(datePickerCheckIn);
		pnlCheckoutDate.add(lblCheckOutDate);
		pnlCheckoutDate.add(datePickerCheckOut);
		add(pnlName).setPreferredSize(new Dimension(500, 60));
		add(pnlAddress).setPreferredSize(new Dimension(500, 60));
		add(pnlContactNo).setPreferredSize(new Dimension(500, 60));
		add(pnlRoomNumber).setPreferredSize(new Dimension(500, 60));
		add(pnlCheckInDate).setPreferredSize(new Dimension(500, 60));
		add(pnlCheckoutDate).setPreferredSize(new Dimension(500, 60));
		add(pnlRoomType).setPreferredSize(new Dimension(500, 60));
		add(btnSubmit).setPreferredSize(new Dimension(200, 60));
		add(btnClear).setPreferredSize(new Dimension(200, 60));
		btnGroup.add(rdBtnSR);
		btnGroup.add(rdBtnDR);
		btnGroup.add(rdBtnSUITE);
		rdBtnSR.setSelected(true);
		s.setAllowKeyboardEditing(false);
		s.setFontValidDate(new Font("Times New Roman", Font.BOLD, 24));
		s2.setAllowKeyboardEditing(false);
		s2.setFontValidDate(new Font("Times New Roman", Font.BOLD, 24));
		btnSubmit.addActionListener(this);
		btnClear.addActionListener(this);
		comboBoxAdd();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) { // RESET ALL FIELDS
			txtName.setText("");
			txtAddress.setText("");
			txtContactNo.setText("");
			txtRoomNumber.setText("");
			datePickerCheckIn.clear();
			datePickerCheckOut.clear();
		}
	}
	private void comboBoxAdd() { //ADD ALL ROOMS TO THE COMBO BOX
		for (int i = 100; i < 411; i++) {
			vector.add(i);
		}
	}
}
