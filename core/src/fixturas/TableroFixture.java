package fixturas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import bodies.MyBody;
import comunes.BodyEditorLoader;
import comunes.Constantes;

public class TableroFixture extends MyFixture{
	public float ESCALA = 100f;

	public TableroFixture(MyBody myBody) {
		super(myBody);
		FileHandle file=Gdx.files.internal("tablero.json");
		String cadena=file.readString();
		BodyEditorLoader loader = new BodyEditorLoader(cadena);
		
		fixtureDef.density=1;
		fixtureDef.friction=3f;
		fixtureDef.restitution=0.0f;
		
		
		loader.attachFixture(myBody.body, "tablero", fixtureDef, myBody.sprite.getWidth()/ESCALA);
		
		
		
		

	}

}
