package com.mygdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.Background;
import com.mygdx.game.actor.Rock;
import com.mygdx.game.actor.Ship;

/**
 * Created by pc on 07.08.2017.
 */

public class PlayState extends State{

    private AssetManager assetManager;
    private Ship ship;
    private Background back;
    private Array<Rock> rocks;
    private long time;
    public Time endtime;
    private BitmapFont font;



    public PlayState(GameStateManager gsm){
        super(gsm);

        assetManager = new AssetManager();
        font = new BitmapFont();
        font.setColor(Color.BLUE);
        endtime = new Time();
        time = (System.currentTimeMillis());
        ship = new Ship(110,0);
        back = new Background(0);
        rocks = new Array<Rock>();
        cam.setToOrtho(false,MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);

        for(int i = 10;i>0;i--)
            rocks.add(new Rock());

        assetManager.load("background.png",Texture.class);
        assetManager.load("ship.png",Texture.class);
        assetManager.load("background.png",Texture.class);
        assetManager.load("rock.png",Texture.class);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {

            if (Gdx.input.getX() > Gdx.graphics.getWidth()/2) {
                if (ship.getPosition().x >= 0 && ship.getPosition().x < 220)
                    ship.goRight();
            } else if (Gdx.input.getX() < Gdx.graphics.getWidth()/2) {

                if (ship.getPosition().x > 0 && ship.getPosition().x <= 220)
                    ship.goLeft();
            }
        }
    }

    @Override
    public void update(float dt) {

        if (assetManager.update()) {
            ship.update(dt);
            cam.position.y = ship.getPosition().y + 120;

            if (ship.getPosition().y > (back.getP1pos().y + MyGdxGame.HEIGHT + 200)) {
                back.reposition();
            } else if (ship.getPosition().y > (back.getP2pos().y + MyGdxGame.HEIGHT + 200)) {
                back.reposition();
            }

            for (Rock rock : rocks) {
                if (cam.position.y - (cam.viewportHeight / 2) > rock.getRockPosition().y) {
                    rock.setRockPosition((MyGdxGame.WIDTH / 2) - 10, -20, Math.round(cam.position.y + cam.viewportHeight) + 200,
                            Math.round(cam.position.y + cam.viewportHeight / 2));
                }
                if (rock.collides(ship.getShip_collision())) {
                    gsm.set(new EndState(gsm));
                    endtime.setTime(((System.currentTimeMillis() - time) / 1000));
                    break;//break koymazsak sürekli new endstate ypıyo iterator hatası veriyo
                }
            }
            cam.update();
            handleInput();
        }
    }



    @Override
    public void render(SpriteBatch sp) {

        if(assetManager.update()) {
            sp.setProjectionMatrix(cam.combined);
            sp.begin();
            sp.draw(assetManager.get("background.png",Texture.class), 0, -100);
            sp.draw(assetManager.get("background.png",Texture.class), 0, back.getP1pos().y, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
            sp.draw(assetManager.get("background.png",Texture.class), 0, back.getP2pos().y, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
            sp.draw(assetManager.get("ship.png",Texture.class), ship.getPosition().x, ship.getPosition().y, 20, 20);
            for (Rock rock : rocks) {
                sp.draw(assetManager.get("rock.png", Texture.class), rock.getRockPosition().x, rock.getRockPosition().y, 30, 30);
            }
            sp.end();
        }else
        {
            sp.begin();
            font.draw(sp,"Loading....",cam.position.x-20,cam.position.y);
            sp.end();
        }


    }


    @Override
    public void dispose(){
        assetManager.dispose();
        font.dispose();
    }
}
