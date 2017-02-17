package fixturas;

import static comunes.Constantes.PIXELS_TO_METERS;

import com.badlogic.gdx.graphics.g3d.particles.values.RectangleSpawnShapeValue;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

import bodies.MyBody;
import comunes.Constantes;

public class BotonFixture extends MyFixture {

	public BotonFixture(MyBody myBody,float giro) {
		super(myBody);
		shape=new PolygonShape();
		((PolygonShape) shape).setAsBox(myBody.sprite.getWidth()/2 / PIXELS_TO_METERS, myBody.sprite.getHeight() / 2 / PIXELS_TO_METERS,
				new Vector2((myBody.sprite.getWidth()/2 / PIXELS_TO_METERS)-2/PIXELS_TO_METERS,(myBody.sprite.getHeight() / 2 / PIXELS_TO_METERS)-8/PIXELS_TO_METERS),(float) (giro*Math.PI)/180);
//		((PolygonShape) shape).setAsBox(myBody.sprite.getWidth()/2 / PIXELS_TO_METERS, myBody.sprite.getHeight() / 2 / PIXELS_TO_METERS);
		fixtureDef.shape = shape;
		myBody.body.createFixture(fixtureDef);
		myBody.body.setFixedRotation(false);
		shape.dispose();
	}

}
