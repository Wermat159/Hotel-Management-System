package swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StaffEditWindow extends JFrame {

	
	private JLabel lblName = new JLabel("NAME");
	private JLabel lblSalary = new JLabel("SALARY");
	JTextField txtName = new JTextField();
	JTextField txtSalary = new JTextField();
	private JPanel pnlName = new JPanel();
	private JPanel pnlSalary = new JPanel();
	JButton btnSave = new JButton("SAVE");
	JRadioButton rdBtnManager = new JRadioButton("Manager");
	JRadioButton rdBtnCleaner = new JRadioButton("Cleaner");
	JRadioButton rdBtnReceptionist = new JRadioButton("Receptionist");
	JRadioButton rdBtnCook = new JRadioButton("Cook");
	private ButtonGroup btnGroup = new ButtonGroup();
	private JPanel pnlStaffRank = new JPanel(new GridLayout(1, 4));
	
	/*
	 *  WINDOW FOR STAFF INFO TO BE EDITED
	 *  REGEX IS CHECKED IN ORDER:
	 *  NAME MUST ONLY BE STRING
	 *  SALARY MUST ONLY BE POSITIVE DOUBLE VALUES
	 *  NO REGEX NEEDED FOR POSITION AS IT IS SELECTED BY RADIO BUTTON
	 * 
	 */
	
	StaffEditWindow() {

		setSize(500, 300);
		setTitle("EDIT STAFF");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		pnlName.setLayout(new GridLayout(1, 2));
		pnlSalary.setLayout(new GridLayout(1, 2));
		pnlName.add(lblName);
		pnlName.add(txtName);
		pnlSalary.add(lblSalary);
		pnlSalary.add(txtSalary);
		txtName.setFont(new Font("Arial", Font.BOLD, 18));
		txtSalary.setFont(new Font("Arial", Font.BOLD, 18));
		add(pnlName).setPreferredSize(new Dimension(400, 60));
		add(pnlSalary).setPreferredSize(new Dimension(400, 60));
		add(btnSave).setPreferredSize(new Dimension(300, 60));
		pnlStaffRank.add(rdBtnManager);
		pnlStaffRank.add(rdBtnCleaner);
		pnlStaffRank.add(rdBtnReceptionist);
		pnlStaffRank.add(rdBtnCook);
		btnGroup.add(rdBtnManager);
		btnGroup.add(rdBtnCleaner);
		btnGroup.add(rdBtnReceptionist);
		btnGroup.add(rdBtnCook);
		add(pnlStaffRank);
		rdBtnCook.setSelected(true);
	}

	public void editStaff(String name, double salary) {
		txtName.setText(name);
		txtSalary.setText(salary + "");
	}
}
