import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.alee.laf.WebLookAndFeel;

public class mainwindow extends JFrame {
	static JTextField ipadr;
	static JButton btn;
	static JLabel loading = new JLabel("");
	static JLabel imgLab;

	public mainwindow() {
		setTitle("Sniffing APP V0");
		WebLookAndFeel.install();
		JMenuBar barTop = new JMenuBar();
		JMenu menu = new JMenu("Fichier");
		JMenu other = new JMenu("?");
		JMenuItem about1 = new JMenuItem("About");
		about1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				about a = new about();
			}
		});
		other.add(about1);
		JMenuItem item1 = new JMenuItem("Export Network");
		JMenuItem item2 = new JMenuItem("Sniff Another Network");
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainwindow w = new mainwindow();
			}
		});
		JMenuItem item3 = new JMenuItem("Exit");
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		barTop.add(menu);
		barTop.add(other);
		JPanel pane = new JPanel();
		btn = new JButton("Fetch this network");
		ipadr = new JTextField();
		ipadr.setPreferredSize(new Dimension(100, 20));
		pane.add(ipadr);
		pane.add(btn);
		add(pane, BorderLayout.CENTER);
		add(barTop, BorderLayout.NORTH);
		ImageIcon img = new ImageIcon("loading.gif");
		JPanel paneSouth = new JPanel(new FlowLayout());
		imgLab = new JLabel(img);
		imgLab.setVisible(false);
		paneSouth.add(loading);
		paneSouth.add(imgLab);
		add(paneSouth, BorderLayout.SOUTH);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		mainwindow wind = new mainwindow();
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrintThread t = new PrintThread();
				loading.setText("wait for it <3");
				imgLab.setVisible(true);
				t.start();

			}

		});
	}

}
