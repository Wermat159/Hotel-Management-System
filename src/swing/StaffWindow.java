package swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import hotel.Staff;
import hotel.StaffRank;

@SuppressWarnings("serial")
public class StaffWindow extends JFrame implements ActionListener {

	private String[] names = { "ID", "Name", "Rank", "Salary($)" };
	private Object[][] data = {};
	private DefaultTableModel model = new DefaultTableModel(data, names);
	private JTable table = new JTable(model) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	private JScrollPane scroll = new JScrollPane(table);
	private JButton btnDelete = new JButton("DELETE");
	private JButton btnAdd = new JButton("ADD");
	private JButton btnEdit = new JButton("EDIT");
	private StaffEditWindow sew = new StaffEditWindow();
	private int id = 104;

	public StaffWindow() {
		addStaff();
		table.setFont(new Font("Arial", Font.BOLD, 16));
		table.setRowHeight(50);
		setSize(600, 500);
		setTitle("STAFF");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		add(scroll).setPreferredSize(new Dimension(550, 380));
		add(btnAdd).setPreferredSize(new Dimension(150, 50));
		add(btnDelete).setPreferredSize(new Dimension(150, 50));
		add(btnEdit).setPreferredSize(new Dimension(150, 50));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnEdit.addActionListener(this);
		sew.btnSave.addActionListener(this);
	}

	private void addStaff() {
		Staff s1 = new Staff("Tommy Vercetti", StaffRank.MANAGER, 1000);
		Staff s2 = new Staff("Carl Johnson", StaffRank.RECEPTIONIST, 200);
		Staff s3 = new Staff("Franklin Clinton", StaffRank.CLEANER, 300);
		Staff s4 = new Staff("Trevor Phillips", StaffRank.COOK, 500);
		Staff[] staff = { s1, s2, s3, s4 };
		for (int i = 0; i < staff.length; i++) {
			model.addRow(new Object[] { i + 100, staff[i].getName(), staff[i].getStaffRank(), staff[i].getSalary() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) { // ADD BUTTON
			model.addRow(new Object[] { id, null, null, null });
			id++;
		} else if (e.getSource() == btnDelete) { // DELETE BUTTON
			if (table.getSelectedRow() != -1) {
				model.removeRow(table.getSelectedRow());
			}
		} else if (e.getSource() == btnEdit) { // EDIT BUTTON
			int row = table.getSelectedRow();
			if (row != -1) {
				String name = null;
				double salary = 0;
				;
				try {
					name = (String) model.getValueAt(row, 1);
					salary = Double.parseDouble(model.getValueAt(row, 3) + "");
				} catch (Exception e2) {
				}
				sew.editStaff(name, salary);
				sew.setVisible(true);
			}
		} else if (e.getSource() == sew.btnSave) { // SAVE BUTTON IN EDIT WINDOW
			int row = table.getSelectedRow();
			try {
				String name = sew.txtName.getText();
				Double salary = Double.parseDouble(sew.txtSalary.getText());
				StaffRank staffRank = staffRankChecker();
				if (!name.matches("[A-Za-z\\s]+")) {
					JOptionPane.showMessageDialog(null, "Name can only contatin letters and spaces.");
				} else if (salary < 0) {
					JOptionPane.showMessageDialog(null, "Salary field must only contain positive numbers.");
				} else {
					model.setValueAt(name, row, 1);
					model.setValueAt(staffRank, row, 2);
					model.setValueAt(salary, row, 3);
					sew.dispose();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Salary field must only contain positive numbers.");
			}
		}
	}

	public StaffRank staffRankChecker() { // CHECKS THE RANK TO BE ADDED TO THE STAFF
		if (sew.rdBtnManager.isSelected()) {
			return StaffRank.MANAGER;
		} else if (sew.rdBtnCleaner.isSelected()) {
			return StaffRank.CLEANER;
		} else if (sew.rdBtnCook.isSelected()) {
			return StaffRank.COOK;
		} else if (sew.rdBtnReceptionist.isSelected()) {
			return StaffRank.RECEPTIONIST;
		}
		return null;
	}
}
