package behaviors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import bodies.MyBody;

public abstract class MyBehavior {
	MyBody myBody;
	
	public MyBehavior(MyBody myBody) {
		this.myBody=myBody;
	}
	
	public abstract void act(float delta);
	public abstract void draw(Batch batch, float parentAlpha);
	
	
	
	
}
