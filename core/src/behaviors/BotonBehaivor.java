package behaviors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;

import bodies.MyBody;
import interfaces.IReiniciable;

public class BotonBehaivor extends MyBehavior implements IReiniciable{
	
	public boolean activado=false;
	public BotonBehaivor(MyBody myBody) {
		super(myBody);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(!activado)
		myBody.sprite.draw(batch);
		
	}
	
	@Override
	public void chocar(Body bolaBody) {
		
		activado=true;
	}

	@Override
	public void reiniciar() {
		activado=false;
		
	}
	
	
	
	

}
