public class PrintThread extends Thread {

	@Override
	public void run() {
		new sniffingtest(mainwindow.ipadr.getText());
		mainwindow.loading.setText("");
		mainwindow.imgLab.setVisible(false);

	}

}