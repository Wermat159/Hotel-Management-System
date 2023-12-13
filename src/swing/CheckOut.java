package swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import hotel.Guest;

@SuppressWarnings("serial")
public class CheckOut extends JFrame implements ActionListener {

	DefaultListModel<Guest> dlm = new DefaultListModel<Guest>();
	JList<Guest> list = new JList<Guest>(dlm);
	private JScrollPane scroll = new JScrollPane(list);
	JButton btnCheckOut = new JButton("Check Out");

	public CheckOut(LinkedList<Guest> guestList) { // REFRESH THE CHECK OUT LIST
		for (int i = 0; i < guestList.size(); i++) {
			dlm.addElement(guestList.get(i));
		}
		setSize(1000, 500);
		setTitle("CHECK-OUT");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(scroll).setPreferredSize(new Dimension(900, 400));
		add(btnCheckOut).setPreferredSize(new Dimension(400, 50));
		btnCheckOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = list.getSelectedIndex();
		if (e.getSource() == btnCheckOut) {
			if (index != -1) {
				dlm.removeElement(index);
			}
		}
	}
}
