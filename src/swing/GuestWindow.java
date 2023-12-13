package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import hotel.Guest;

@SuppressWarnings("serial")
public class GuestWindow extends JFrame {

	private DefaultListModel<Guest> dlm = new DefaultListModel<Guest>();
	private JList<Guest> list = new JList<Guest>(dlm);
	private JScrollPane scroll = new JScrollPane(list);

	GuestWindow(LinkedList<Guest> guestList) {
		for (int i = 0; i < guestList.size(); i++) {
			dlm.addElement(guestList.get(i));
		}

		/*
		 * DISPLAYS GUEST LIST
		 */
		
		setSize(1800, 900);
		setTitle("GUEST LIST");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		list.setFont(new Font("Arial", Font.BOLD, 20));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(scroll);
	}

}
