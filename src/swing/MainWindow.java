package swing;

import java.awt.FlowLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	/*
	 * WINDOW FOR HOTEL WINDOW
	 */

	public MainWindow() {
		setSize(1000, 700);
		setTitle("HOTEL");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
