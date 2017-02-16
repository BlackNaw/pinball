package actores;

import com.badlogic.gdx.physics.box2d.World;

import behaviors.TableroBehavior;
import bodies.TableroBody;
import fixturas.TableroFixture;

public class Tablero extends MyActor {

	public Tablero(World world, float posX, float posY) {
		super(world, posX, posY);
		TableroBody tableroBody=new TableroBody(world,posX,posY);
		myBehavior=new TableroBehavior(tableroBody);
		myFixture=new TableroFixture(tableroBody);
		
	}

}
