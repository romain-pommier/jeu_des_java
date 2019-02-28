package jeudes;

public class Controler {

	// IHM
	IHM ihm;

	// Données
	PartieBean pb;

	public Controler() {
		pb = new PartieBean("Toto", "Tata");
	}

	public void refreshScreen() {

		// Update du joueur 1
		ihm.updateJ1(pb.getJ1().getNom(), pb.getJ1().getScorePartie());
		// Update du joueur 2
		ihm.updateJ2(pb.getJ2().getNom(), pb.getJ2().getScorePartie());

		// update nombre de tour
		ihm.updateNbrTour(pb.getTour());
		// update des dés ??
		if (pb.getJoueurCourant() == pb.getJ1()) {
			// J1 le joueur courant
			ihm.updateScoreDe(pb.getJ2().getGobelet().getD1().getValue(), pb.getJ2().getGobelet().getD2().getValue());
			ihm.updateVisibilityButton(true, false, false);
		} else {
			ihm.updateScoreDe(pb.getJ1().getGobelet().getD1().getValue(), pb.getJ1().getGobelet().getD2().getValue());
			ihm.updateVisibilityButton(false, true, false);
		}

		// condition de fin de partie
		if (pb.isTerminee()) {
			ihm.updateVisibilityButton(false, false, true);
			JoueurBean gagnant = pb.getGagnant();
			if (gagnant == null) {
				ihm.updateTextGanant("Egalité", true);
			} else {
				ihm.updateTextGanant(gagnant.getNom() + " a gagné", true);
			}
		} else {
			ihm.updateTextGanant("", false);
		}
	}

	// --------------------------
	// Methode pour prévenir le controler
	// ----------------------

	public void clicOnLancerJ1() {
		// MODIFIER LES DONNEES
		// Je fais lancer J1
		pb.getJ1().lancer();
		// S'il fait 7 ou + on lui ajoute un point
		if (pb.getJ1().getGobelet().getScoreDes() >= PartieBean.SCORE_A_ATTEINDRE) {
			pb.getJ1().ajouter1pt();
		}
		pb.setJoueurCourant(pb.getJ2());

		// AFFICHAGE
		refreshScreen();
	}

	public void clicOnLancerJ2() {
		// MODIFIER LES DONNEES
		// Je fais lancer J2
		pb.getJ2().lancer();
		// S'il fait 7 ou + on lui ajoute un point
		if (pb.getJ2().getGobelet().getScoreDes() >= PartieBean.SCORE_A_ATTEINDRE) {
			pb.getJ2().ajouter1pt();

		}
		pb.ajouter1Tour();
		pb.setJoueurCourant(pb.getJ1());

		// AFFICHAGE
		refreshScreen();
	}

	public void clicOnRestart() {
		pb = new PartieBean(pb.getJ1().getNom(), pb.getJ2().getNom());
		refreshScreen();
	}

	public void sauvegarderPartie() {
		try {
			PartieDAOUtils.sauvegarderPartie(pb);
			ihm.updateTextGanant("Partie sauvegardée", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ihm.updateTextGanant("Erreur de sauvegarde : " + e.getMessage(), true);
		}
	}

	public void chargerPartie() {
		try {
			pb = PartieDAOUtils.chargerPartie();
			refreshScreen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ihm.updateTextGanant("Erreur de chargement : " + e.getMessage(), true);
		}

	}
	// ---------------------
	// Getter setter
	// --------------------

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

}
