package control;

import java.net.DatagramSocketImplFactory;

import javax.swing.plaf.basic.BasicLabelUI;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import comunes.MakingACage;
import comunes.Constantes;

public class MyGdxGame extends ApplicationAdapter {
	World world;
	Game game;

	@Override
	public void create() {
		world = new World(new Vector2(0, 0), true);
		world.setGravity(new Vector2(0, Constantes.GRAVEDAD_Y));
		game=new Game(world);
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(67/255f, 5/255f, 44/255f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.step(1f / 60f, 6, 2);
		game.act();
		game.render();


	}

	@Override
	public void dispose() {
		game.dispose();
		world.dispose();
	}

}
