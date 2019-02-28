package jeudes;

public class PartieBean {

	public static final int NB_LANCER = 10;
	public static final int SCORE_A_ATTEINDRE = 7;

	private JoueurBean j1, j2;
	private int tour;
	private JoueurBean joueurCourant;

	public PartieBean(String nomj1, String nomj2) {
		j1 = new JoueurBean(nomj1);
		j2 = new JoueurBean(nomj2);
		joueurCourant = j1;
		tour = 1;
	}

	public void echangerjoueurCourant() {
		if (j1 == joueurCourant) {
			joueurCourant = j2;
		} else {
			joueurCourant = j1;
		}
	}

	public void ajouter1Tour() {
		tour++;
	}

	public boolean isTerminee() {
		return tour > NB_LANCER;
	}

	/**
	 * Retourne le joueur qui gagne ou null si égalité
	 *
	 * @return
	 */
	public JoueurBean getGagnant() {
		if (j1.getScorePartie() > j2.getScorePartie()) {
			return j1;
		} else if (j1.getScorePartie() < j2.getScorePartie()) {
			return j2;
		} else {
			return null;
		}
	}

	// -------------------
	// GETTER / SETTER
	// -------------------

	public JoueurBean getJ1() {
		return j1;
	}

	public void setJ1(JoueurBean j1) {
		this.j1 = j1;
	}

	public JoueurBean getJ2() {
		return j2;
	}

	public void setJ2(JoueurBean j2) {
		this.j2 = j2;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public JoueurBean getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(JoueurBean joueurCourant) {
		this.joueurCourant = joueurCourant;
	}

}
