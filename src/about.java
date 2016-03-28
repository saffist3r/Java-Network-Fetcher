import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;

@SuppressWarnings("serial")
public class about extends JFrame {
	public about() {
		WebLookAndFeel.install();
		JLabel lab1 = new JLabel("Sniffing APP V0 Made with Love by Safwene Ladhari");
		JLabel lab2 = new JLabel("Credits to : jsvede");
		JLabel lab3 = new JLabel("https://sourceforge.net/projects/nmap4j/");
		JPanel pane = new JPanel(new GridLayout(3,1));
		Border b = new EmptyBorder(150,5,150,0);
		pane.add(lab1);
		pane.add(lab2);
		pane.add(lab3);
		pane.setBorder(b);
		add(pane);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("About");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
