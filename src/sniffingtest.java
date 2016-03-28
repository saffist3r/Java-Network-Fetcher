import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.nmap4j.data.nmaprun.Host;

import com.alee.laf.WebLookAndFeel;

public class sniffingtest {

	static JFrame mainwind = new JFrame("Host List");
	public static JComboBox<String> combo;
	static ArrayList<String> adrs = new ArrayList<String>();
	public static ArrayList<Host> verifier_nmap;
	ArrayList<Host> hosts = new ArrayList<>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public sniffingtest(String ip) {
		WebLookAndFeel.install();
		JButton bouton = new JButton("get info");
		JPanel panecent = new JPanel(new FlowLayout());
		JPanel panEast = new JPanel(new FlowLayout());
		sniffer.sniffing(ip);
		bouton.addActionListener(new hostview());
		combo = new JComboBox(adrs.toArray());	
		panecent.add(combo);
		panEast.add(bouton);
		mainwind.setLocationRelativeTo(null);
		mainwind.add(panecent, BorderLayout.CENTER);
		mainwind.add(panEast, BorderLayout.EAST);
		mainwind.setSize(400, 200);
		mainwind.setVisible(true);
	}
}