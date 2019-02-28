package jeudes;

import java.awt.EventQueue;

public class Main {

	public static void main(final String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// V1
					// Controler controler = new Controler();

					// V2

					IHM ihm = new IHM();
					Controler controler = new Controler();
					ihm.frame.setVisible(true);
					ihm.setControler(controler);
					controler.setIhm(ihm);
					controler.refreshScreen();

				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
