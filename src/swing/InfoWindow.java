package swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InfoWindow extends JFrame {

	private JTextArea area = new JTextArea();

	/*
	 * INFO FOR STAFF TO READ AND IF NECCESSARY READ TO CUSTOMERS
	 * WILL OPEN RIGHT AFTER MAIN MANAGEMENT WINDOW IS OPENED
	 * 
	 */
	
	InfoWindow() {
		setSize(800, 500);
		setTitle("INFORMATION TAB");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		area.setText("NOTES FOR STAFF TO READ: "
				+ "\nROOMS 100-299 ARE SINGLEROOMS\nROOMS 299-399 ARE DOUBLEROOMS\nROOMS 400-410 ARE SUITES"
				+ "\nSINGLEROOM: 150$ PER NIGHT (FOOD INCLUDED)\nDOUBLEROOM: 300$ PER NIGHT (FOOD INCLUDED)"
				+ "\nSUITE: 450$ (FOOD INCLUDED)\nFOOD PAGE IS ONLY FOR INVENTORY, THERE IS NO ROOM SERVICE IN OUR HOTEL."
				+ "\nPLEASE ENTER NAMES, ADDRESSES, CONTACT NUMBERS AND DATES PROPERLY."
				+ "\nSTAFF TAB SHOULD ONLY BE USED BY MANAGERS.");
		
		
		add(area);
		area.setLineWrap(true);
		area.setEditable(false);
		area.setFont(new Font("Arial", Font.BOLD, 16));
	}

}
