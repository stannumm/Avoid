package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 * Created by pc on 07.08.2017.
 */

public class MenuState extends State {

    private Texture backGroundImage;
    private Texture button;



    public MenuState(GameStateManager gsm) {
        super(gsm);

        backGroundImage = new Texture("background.png");
        button = new Texture("start.png");
        cam.setToOrtho(false,MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
          dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sp) {
        sp.setProjectionMatrix(cam.combined);
        sp.begin();
        sp.draw(backGroundImage,cam.position.x-(Gdx.graphics.getWidth()/2),cam.position.y-(Gdx.graphics.getHeight()/2),
                MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
        sp.draw(button,cam.position.x-(Gdx.graphics.getWidth()/8),cam.position.y,
                Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/8);
        sp.end();
    }

    @Override
    public void dispose() {
        backGroundImage.dispose();
        button.dispose();
    }
}
