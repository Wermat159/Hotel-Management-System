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

import hotel.Food;

@SuppressWarnings("serial")
public class FoodWindow extends JFrame implements ActionListener {

	private String[] names = { "Name", "Quantity", "Price($)" };
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
	private Food f1 = new Food("Hamburger", 200, 4);
	private Food f2 = new Food("Sushi", 400, 2);
	private Food f3 = new Food("Fries", 500, 1);
	private FoodEditWindow few = new FoodEditWindow();

	public FoodWindow() {
		/*
		 * ADD 3 FOODS JUST FOR DEFAULT
		 * 
		 * ALL REGEX IS CHECKED IN ORDER:
		 * NAME MUST ONLY BE STRING
		 * QUANTITY AND PRICE MUST ONLY BE POSITIVE INTEGERS
		 */
		model.addRow(new Object[] { f1.getName(), f1.getQuantity(), f1.getPrice() });
		model.addRow(new Object[] { f2.getName(), f2.getQuantity(), f2.getPrice() });
		model.addRow(new Object[] { f3.getName(), f3.getQuantity(), f3.getPrice() });
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Arial", Font.BOLD, 20));
		table.setRowHeight(50);
		table.setPreferredSize(new Dimension(500, 450));
		table.getColumn("Name");
//		table.setRowSelectionAllowed(false);
		setSize(600, 500);
		setTitle("FOOD");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		add(scroll).setPreferredSize(new Dimension(550, 380));
		add(btnAdd).setPreferredSize(new Dimension(150, 50));
		add(btnDelete).setPreferredSize(new Dimension(150, 50));
		add(btnEdit).setPreferredSize(new Dimension(150, 50));
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnEdit.addActionListener(this);
		few.btnSave.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) { // ADD BUTTON ---- ADDS A NEW TABLE FOR FOOD
			model.addRow(new Object[] { "", "", "", "" });
		} else if (e.getSource() == btnDelete) {
			if (table.getSelectedRow() != -1) {
				model.removeRow(table.getSelectedRow());
			}
		} else if (e.getSource() == btnEdit) { // EDIT BUTTON ---- EDITS THE SELECTED TABLE
			int row = table.getSelectedRow();
			if (row != -1) {
				String name = null;
				int quantity = 0;
				double price = 0;
				try {
					name = (String) model.getValueAt(row, 0);
					quantity = Integer.parseInt(model.getValueAt(row, 1) + "");
					price = Double.parseDouble(model.getValueAt(row, 2) + "");
				} catch (Exception e2) {
				}
				few.editFood(name, quantity, price);
				few.setVisible(true);
			}
		} else if (e.getSource() == few.btnSave) { // FOOD EDIT WINDOWS SAVE BUTTON
			int row = table.getSelectedRow();

			try {
				String name = few.txtName.getText();
				int quantity = Integer.parseInt(few.txtQuantity.getText());
				double price = Double.parseDouble(few.txtPrice.getText());
				if (!name.matches("[A-Za-z\\s]+")) {
					JOptionPane.showMessageDialog(null, "Name can only contatin letters and spaces.");
				} else if (quantity < 0 || price < 0) {
					JOptionPane.showMessageDialog(null, "Quantity and price field must only contain positive numbers.");
				} else {
					model.setValueAt(name, row, 0);
					model.setValueAt(quantity, row, 1);
					model.setValueAt(price, row, 2);
					few.dispose();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Quantity and price field must only contain positive numbers.");
			}

		}
	}

}
