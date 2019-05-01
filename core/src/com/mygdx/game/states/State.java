package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by pc on 07.08.2017.
 */

public abstract class State {

    protected OrthographicCamera cam; //kamera
    protected Vector3 mouse; //3 boyutlu
    protected  GameStateManager gsm;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;//diğer sınıflardaki super(gsm) ile burdaki gsm e ulaşıyor
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    protected abstract void handleInput();//input
    public abstract void update(float dt);//dt = delta time
    public abstract void render(SpriteBatch sp);
    public abstract void dispose();
}
