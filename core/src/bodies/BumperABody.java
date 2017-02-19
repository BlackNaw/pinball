package bodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import comunes.Constantes;

public class BumperABody extends MyBody{
	Texture textures[]=new Texture [5];
	public BumperABody(World world, float posX, float posY) {
		super(world, posX, posY);
		
		textures[0]=new Texture(Gdx.files.internal("Imagenes/Bumpers/Nivel1/escudo.png"));
		textures[1]=new Texture(Gdx.files.internal("Imagenes/Bumpers/Nivel2/escudo.png"));
		textures[2]=new Texture(Gdx.files.internal("Imagenes/Bumpers/Nivel3/escudo.png"));
		textures[3]=new Texture(Gdx.files.internal("Imagenes/Bumpers/Nivel4/escudo.png"));
		textures[4]=new Texture(Gdx.files.internal("Imagenes/Bumpers/Nivel5/escudo.png"));
		texture=textures[0];
		sprite = new Sprite(texture);
		sprite.setPosition(posX, posY);
		sprite.setSize(40, 40);
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set((sprite.getX() + sprite.getWidth() / 2) / Constantes.PIXELS_TO_METERS,
				(sprite.getY() + sprite.getHeight() / 2) / Constantes.PIXELS_TO_METERS);
		this.body = world.createBody(bodyDef);
		body.setUserData(this);
	}
	
	
public void cambiarTexture(int nivel){
		sprite.setTexture(textures[nivel]);
	}

}
