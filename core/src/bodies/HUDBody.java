package bodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.physics.box2d.World;

public class HUDBody extends MyBody {
	
	
	
	public HUDBody(World world, float posX, float posY) {
		super(world, posX, posY);
		marcoSuperior=new Texture("Imagenes/efectoMarco.png");
		marcoInferior=new Texture("Imagenes/efectoMarcoVolteado.png");
		this.font=new BitmapFont(Gdx.files.internal("Fuente/painball.fnt"));
	}

}
