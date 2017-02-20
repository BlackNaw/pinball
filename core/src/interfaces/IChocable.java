package interfaces;

import com.badlogic.gdx.physics.box2d.Body;

import actores.Ball;

public interface IChocable {
	
	void chocar(Body bodyBola);

	void finalizarChoque();

}
