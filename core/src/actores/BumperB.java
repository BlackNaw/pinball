package actores;

import interfaces.IBumper;

public class BumperB implements IBumper {
	public int puntuacionBumberB;

	public BumperB(int puntuacionBumberB) {
		this.puntuacionBumberB = puntuacionBumberB;
	}

	@Override
	public int choque(Ball ball) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void subirNivel() {
		// TODO Auto-generated method stub

	}

}
