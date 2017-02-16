package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import behaviors.MyBehavior;
import bodies.MyBody;
import fixturas.MyFixture;

public abstract class MyActor extends Actor{
	
	MyBehavior myBehavior;
	MyFixture myFixture;
	
	public MyActor(World world,float posX,float posY) {
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		myBehavior.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		myBehavior.draw(batch, parentAlpha);
	}
	
	

}
