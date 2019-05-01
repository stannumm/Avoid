package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.states.Time;

/**
 * Created by pc on 15.08.2017.
 */

public class Background {

    private Vector2 p1pos,p2pos;
    public Background(float y){

        p1pos = new Vector2(0,y);
        p2pos = new Vector2(0,y+MyGdxGame.HEIGHT);
    }

    public Vector2 getP1pos() {
        return p1pos;
    }

    public Vector2 getP2pos() {
        return p2pos;
    }

    public void reposition(){
        if(p1pos.y>p2pos.y){
            p2pos.y = p2pos.y + (2*MyGdxGame.HEIGHT);
        }
        else if(p1pos.y<p2pos.y){
            p1pos.y = p1pos.y + (2*MyGdxGame.HEIGHT);
        }

}
}
