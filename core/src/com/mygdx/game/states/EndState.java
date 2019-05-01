package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.awt.Color;

import sun.rmi.runtime.Log;

/**
 * Created by pc on 19.08.2017.
 */

public class EndState extends State {

    private Texture end_background;
    private BitmapFont font;
    private Time time;
    private Preferences pref;

    public EndState(GameStateManager gsm) {
        super(gsm);
        pref = new Gdx().app.getPreferences("Score");
        font = new BitmapFont();
        font.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        end_background = new Texture("dead.png");
        cam.setToOrtho(false,MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
        time = new Time();
      save(time.getTime());
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
        sp.draw(end_background,cam.position.x-(cam.viewportWidth/2),cam.position.y-((cam.viewportHeight/4)+100),
                cam.position.x*2,cam.position.y*2);
        font.draw(sp,"Your Score!",cam.position.x-40,cam.position.y-(cam.viewportHeight/4));
        font.draw(sp,Long.toString(time.getTime()),cam.position.x,cam.position.y-(cam.viewportHeight/4)-20);
        font.draw(sp,"Highest Score!",cam.position.x-45,cam.position.y-(cam.viewportHeight/4)-40);
        font.draw(sp,Long.toString(pref.getLong("point")),cam.position.x,cam.position.y-((cam.viewportHeight/4)+60));
        sp.end();
    }

    @Override
    public void dispose() {
        end_background.dispose();
        font.dispose();

    }
  public void save(long time){
        if(pref.getLong("point") == 0){
            pref.putLong("point", time);
        }
        else if (pref.getLong("point")<time)
        {
            pref.putLong("point",time);
        }
        pref.flush();
    }
}
