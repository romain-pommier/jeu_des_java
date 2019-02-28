package jeudes;

public class GobeletBean {

	private DeBean d1, d2;

	public GobeletBean() {
		d1 = new DeBean();
		d2 = new DeBean();
	}

	public void lancer() {
		d1.lancer();
		d2.lancer();
	}

	public int getScoreDes() {
		return d1.getValue() + d2.getValue();
	}

	// -------------------
	// GETTER / SETTER
	// -------------------

	public DeBean getD1() {
		return d1;
	}

	public void setD1(DeBean d1) {
		this.d1 = d1;
	}

	public DeBean getD2() {
		return d2;
	}

	public void setD2(DeBean d2) {
		this.d2 = d2;
	}

}
