package interfaces;

import javax.swing.plaf.basic.BasicLabelUI;

import actores.Ball;

public interface IBumper {
	/**
	 * 	La clase Bumper se iluminar� cuando choque la bola
	 * La clase Bumper tiene un parametro puntuaci�n que entrar� por parametro en el constructor, para tener diferentes bumper con diferentes puntuaciones
	 * @param ball entra la bola para saber la direcci�n que lleva y modificar su direccion al chocar
	 * @return	devuelve la puntuaci�n que tiene el Bumper
	 */
	public int choque(Ball ball);
	
	/**
	 * Este m�todo lo que hace es aumentar la puntuaci�n y cambia el color
	 */
	public void subirNivel();
}
