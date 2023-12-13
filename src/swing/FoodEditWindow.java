package swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FoodEditWindow extends JFrame{

	private JLabel lblName = new JLabel("NAME");
	private JLabel lblQuantity = new JLabel("QUANTITY");
	private JLabel lblPrice = new JLabel("PRICE");
	JTextField txtName = new JTextField();
	JTextField txtQuantity = new JTextField();
	JTextField txtPrice = new JTextField();
	private JPanel pnlName = new JPanel();
	private JPanel pnlQuantity = new JPanel();
	private JPanel pnlPrice = new JPanel();
	JButton btnSave = new JButton("SAVE");
	
	
	/*
	 * EDIT THE SELECTED TABLE OF FOOD
	 */
	
	FoodEditWindow(){
		
		setSize(500,300);
		setTitle("EDIT FOOD");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		pnlName.setLayout(new GridLayout(1,2));
		pnlQuantity.setLayout(new GridLayout(1,2));
		pnlPrice.setLayout(new GridLayout(1,2));
		pnlName.add(lblName);
		pnlName.add(txtName);
		pnlQuantity.add(lblQuantity);
		pnlQuantity.add(txtQuantity);
		pnlPrice.add(lblPrice);
		pnlPrice.add(txtPrice);
		txtName.setFont(new Font("Arial", Font.BOLD, 18));
		txtQuantity.setFont(new Font("Arial", Font.BOLD, 18));
		txtPrice.setFont(new Font("Arial", Font.BOLD, 18));
		add(pnlName).setPreferredSize(new Dimension(400, 60));
		add(pnlQuantity).setPreferredSize(new Dimension(400, 60));
		add(pnlPrice).setPreferredSize(new Dimension(400, 60));
		add(btnSave).setPreferredSize(new Dimension(300, 60));
	}

	
	
	public void editFood(String name, int quantity, double price) {
		txtName.setText(name);
		txtQuantity.setText(quantity+"");
		txtPrice.setText(price+"");
	}
	
}
