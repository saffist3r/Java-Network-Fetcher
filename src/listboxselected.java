import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.nmap4j.data.host.Ports;
import org.nmap4j.data.host.ports.Port;
import org.nmap4j.data.nmaprun.Host;

public class listboxselected implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JTable tab;
		String[] columnNames = { "Port", "Service" };
		String dataValues[][];
		int j = 0;
		JFrame sec = new JFrame("Host : " + sniffingtest.verifier_nmap.get(sniffingtest.combo.getSelectedIndex())
				.getAddresses().get(0).getAddr());
		sec.setLocationRelativeTo(null);
		sec.setVisible(true);
		Host h = sniffingtest.verifier_nmap.get(sniffingtest.combo.getSelectedIndex());
		Ports p = h.getPorts();
		ArrayList<Port> liste_ports = p.getPorts();
		dataValues = new String[liste_ports.size()][2];
		for (Port port : liste_ports) {
			dataValues[j][0] = String.valueOf(port.getPortId());
			dataValues[j][1] = port.getService().getName();
			j++;
		}
		JPanel panenorth = new JPanel(new GridLayout(4, 2));
		tab = new JTable(dataValues, columnNames);
		JLabel lab6, lab8;
		JLabel lab1 = new JLabel("Hostname : ");
		JLabel lab2 = new JLabel();// (h.getHostnames().getHostname().getName());
		JLabel lab3 = new JLabel("Status : ");
		JLabel lab4 = new JLabel(h.getStatus().getState());
		JLabel lab5 = new JLabel("OS :");
		if (sniffingtest.verifier_nmap.get(sniffingtest.combo.getSelectedIndex()).getOs().getOsMatches().isEmpty())
			lab6 = new JLabel("NONE");
		else
			lab6 = new JLabel(sniffingtest.verifier_nmap.get(sniffingtest.combo.getSelectedIndex()).getOs()
					.getOsMatches().get(0).getName());
		JLabel lab7 = new JLabel("Marque");
		if (sniffingtest.verifier_nmap.get(sniffingtest.combo.getSelectedIndex()).getAddresses().size() >= 2)
			lab8 = new JLabel(sniffingtest.verifier_nmap.get(sniffingtest.combo.getSelectedIndex()).getAddresses()
					.get(1).getVendor());
		else
			lab8 = new JLabel("NONE");
		panenorth.add(lab1);
		panenorth.add(lab2);
		panenorth.add(lab3);
		panenorth.add(lab4);
		panenorth.add(lab5);
		panenorth.add(lab6);
		panenorth.add(lab7);
		panenorth.add(lab8);
		sec.setSize(400, 400);
		sec.add(panenorth, BorderLayout.NORTH);
		sec.add(new JScrollPane(tab));
	}
}