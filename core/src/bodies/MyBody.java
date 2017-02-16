package bodies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import behaviors.MyBehavior;
import fixturas.MyFixture;

public abstract class MyBody {
	public Sprite sprite;
	TextureAtlas textureMapa;
	TextureRegion textura;
	BodyDef bodyDef = new BodyDef();
	public Body body;
	public MyBehavior myBehavior;
	
	public MyBody(World world,float posX,float posY) {
	}
	
	
	
	
	
	
}