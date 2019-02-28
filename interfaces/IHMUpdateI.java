package jeudes.interfaces;

public interface IHMUpdateI {

	void updateScoreDe(int scoreD1, int scoreD2);

	void updateJ1(String nom, int score);

	void updateJ2(String nom, int score);

	void updateNbrTour(int nbTour);

	void updateVisibilityButton(boolean visibleLancerJ1, boolean visibleLancerJ2, boolean visiblerestart);

	void updateTextGanant(String text, boolean visible);
}
