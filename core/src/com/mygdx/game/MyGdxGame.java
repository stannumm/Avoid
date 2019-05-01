package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.Time;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class MyGdxGame extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT=800;
	public static final String TITLE = "Avoid" ;

	private GameStateManager gsm;
	private SpriteBatch sp;
	private Music music;

	@Override
	public void create () {

		music = Gdx.audio.newMusic(Gdx.files.internal("dubba.mp3"));
		music.setLooping(true);
		music.setVolume(1f);
		music.play();
		gsm = new GameStateManager();
		sp = new SpriteBatch();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));//menu state

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());//stackteki statelerin delta time alıp updatelenmesi
		gsm.render(sp);

	}
	@Override
	public void dispose () {
		sp.dispose();
		music.dispose();

	}

	@Override
	public void pause() {
		super.pause();
		dispose();



	}

	@Override
	public void resume() {
		super.resume();
		create();

	}


}
