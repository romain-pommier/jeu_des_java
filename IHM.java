package jeudes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IHM {

	// Outils

	// Composants graphique
	JFrame frame;
	private JTextField textFieldScoreJ1;
	private JTextField textFieldDe1;
	private JTextField textFieldDe2;
	private JTextField textFieldScoreJ2;
	private JButton btnLancerJ1;
	private JLabel labelTourValue;
	private JButton btnLancerJ2;
	private JButton btnRestart;
	private JLabel lblJoueur1;
	private JLabel lblJoueur2;
	JCheckBox cbJ1, cbJ2;

	// Controler
	Controler controler;
	private JLabel lblGagnant;

	public IHM() {
		initialize();

		// lblJoueur1.setText("" + pb.getJ1().getNom());
		// lblJoueur2.setText("" + pb.getJ2().getNom());

	}

	/*******************
	 * Methode private
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblJoueur1 = new JLabel("Joueur 1");
		lblJoueur1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJoueur1.setBounds(39, 45, 82, 18);
		frame.getContentPane().add(lblJoueur1);

		lblJoueur2 = new JLabel("Joueur 2");
		lblJoueur2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJoueur2.setBounds(500, 45, 108, 18);
		frame.getContentPane().add(lblJoueur2);

		JLabel lblDe1 = new JLabel("DE 1");
		lblDe1.setBounds(235, 123, 46, 14);
		frame.getContentPane().add(lblDe1);

		final JLabel lblDe2 = new JLabel("DE 2");
		lblDe2.setBounds(315, 123, 46, 14);
		frame.getContentPane().add(lblDe2);

		final JLabel lblScoreJ1 = new JLabel("Score");
		lblScoreJ1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblScoreJ1.setBounds(33, 93, 57, 23);
		frame.getContentPane().add(lblScoreJ1);

		textFieldScoreJ1 = new JTextField();
		textFieldScoreJ1.setEditable(false);
		textFieldScoreJ1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreJ1.setBackground(Color.WHITE);
		textFieldScoreJ1.setText("0");
		textFieldScoreJ1.setBounds(86, 96, 35, 20);
		frame.getContentPane().add(textFieldScoreJ1);
		textFieldScoreJ1.setColumns(10);

		textFieldDe1 = new JTextField();
		textFieldDe1.setEditable(false);
		textFieldDe1.setText("1");
		textFieldDe1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDe1.setColumns(10);
		textFieldDe1.setBackground(Color.WHITE);
		textFieldDe1.setBounds(211, 148, 70, 64);
		frame.getContentPane().add(textFieldDe1);

		textFieldDe2 = new JTextField();
		textFieldDe2.setEditable(false);
		textFieldDe2.setText("1");
		textFieldDe2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDe2.setColumns(10);
		textFieldDe2.setBackground(Color.WHITE);
		textFieldDe2.setBounds(304, 148, 70, 64);
		frame.getContentPane().add(textFieldDe2);

		final JLabel labelScoreJ2 = new JLabel("Score : ");
		labelScoreJ2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelScoreJ2.setBounds(479, 93, 57, 23);
		frame.getContentPane().add(labelScoreJ2);

		textFieldScoreJ2 = new JTextField();
		textFieldScoreJ2.setEditable(false);
		textFieldScoreJ2.setText("0");
		textFieldScoreJ2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreJ2.setColumns(10);
		textFieldScoreJ2.setBackground(Color.WHITE);
		textFieldScoreJ2.setBounds(532, 96, 35, 20);
		frame.getContentPane().add(textFieldScoreJ2);

		final JLabel lblTour = new JLabel("Tour : ");
		lblTour.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTour.setBounds(247, 36, 67, 27);
		frame.getContentPane().add(lblTour);

		labelTourValue = new JLabel("0");
		labelTourValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelTourValue.setBounds(324, 36, 37, 27);
		frame.getContentPane().add(labelTourValue);

		btnLancerJ1 = new JButton("Lancer");
		btnLancerJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controler.clicOnLancerJ1();

			}
		});

		btnLancerJ1.setBounds(33, 169, 89, 23);
		frame.getContentPane().add(btnLancerJ1);

		btnLancerJ2 = new JButton("Lancer");
		btnLancerJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.clicOnLancerJ2();
			}

		});

		btnLancerJ2.setBounds(479, 169, 89, 23);
		frame.getContentPane().add(btnLancerJ2);

		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.clicOnRestart();
			}
		});

		btnRestart.setBounds(235, 293, 140, 23);
		frame.getContentPane().add(btnRestart);

		cbJ1 = new JCheckBox("Tricheur");

		cbJ1.setBounds(24, 119, 97, 23);
		frame.getContentPane().add(cbJ1);

		cbJ2 = new JCheckBox("Tricheur");

		cbJ2.setBounds(470, 119, 97, 23);
		frame.getContentPane().add(cbJ2);

		lblGagnant = new JLabel("Le joueur 1 a gagn\u00E9");
		lblGagnant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGagnant.setBounds(246, 245, 82, 18);
		frame.getContentPane().add(lblGagnant);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 666, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem menuSave = new JMenuItem("Sauvegarder");
		menuSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controler.sauvegarderPartie();
			}
		});
		mnNewMenu.add(menuSave);

		JMenuItem menuCharger = new JMenuItem("Charger");
		menuCharger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.chargerPartie();
			}
		});
		mnNewMenu.add(menuCharger);

	}

	public void setControler(Controler controler) {
		this.controler = controler;
	}

	// ---------------------------
	// Méthode pour mettre à jour l'IHM
	// -----------------------------

	public void updateScoreDe(int scoreD1, int scoreD2) {
		textFieldDe1.setText("" + scoreD1);
		textFieldDe2.setText("" + scoreD2);
	}

	public void updateJ1(String nom, int score) {
		textFieldScoreJ1.setText("" + score);
		lblJoueur1.setText(nom);
	}

	public void updateJ2(String nom, int score) {
		textFieldScoreJ2.setText("" + score);
		lblJoueur2.setText(nom);
	}

	public void updateNbrTour(int nbTour) {
		labelTourValue.setText("" + nbTour);
	}

	public void updateVisibilityButton(boolean visibleLancerJ1, boolean visibleLancerJ2, boolean visiblerestart) {
		btnLancerJ1.setVisible(visibleLancerJ1);
		btnLancerJ2.setVisible(visibleLancerJ2);
		btnRestart.setVisible(visiblerestart);
	}

	public void updateTextGanant(String text, boolean visible) {
		// TODO Auto-generated method stub
		lblGagnant.setText(text);
		lblGagnant.setVisible(visible);

	}
}
