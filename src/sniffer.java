import java.util.ArrayList;
import java.util.Iterator;
import org.nmap4j.Nmap4j;
import org.nmap4j.core.nmap.NMapExecutionException;
import org.nmap4j.core.nmap.NMapInitializationException;
import org.nmap4j.data.NMapRun;
import org.nmap4j.data.host.Ports;
import org.nmap4j.data.nmaprun.Host;
import org.nmap4j.parser.OnePassParser;

public class sniffer {
	static ArrayList<Host> sniffing(String ipadr) {
		try {// chemin des fichiers binaires de NMAP
			String path = "/usr";
			// constructeur de l'objet nmap4j
			Nmap4j nmap4j = new Nmap4j(path);
			// les options dans la commande
			nmap4j.addFlags("-T4 -O");
			nmap4j.includeHosts(ipadr);
			nmap4j.execute();
			if (!nmap4j.hasError()) {
				String nmapRun = nmap4j.getOutput();
				// instancier le parseur
				OnePassParser opp = new OnePassParser();
				// donner les options : type d'entrée fichier ou String et nom
				// du variable où fichier
				NMapRun nmapRun1 = opp.parse(nmapRun,OnePassParser.STRING_INPUT);
				// obtenir les hosts trouvés
				ArrayList<Host> hosts = nmapRun1.getHosts();
				sniffingtest.verifier_nmap = nmapRun1.getHosts();
				// parcourir les hosts pour afficher les informations voulus
				for (Iterator iterator = hosts.iterator(); iterator.hasNext();) {
					Host host = (Host) iterator.next();
					Ports p = host.getPorts();
					sniffingtest.adrs.add(host.getAddresses().get(0).getAddr());				
				}
			}
		} catch (NMapInitializationException e) {	
			e.printStackTrace();
		} catch (NMapExecutionException e) {
			e.printStackTrace();
		}
		return (sniffingtest.verifier_nmap);
	}

}
