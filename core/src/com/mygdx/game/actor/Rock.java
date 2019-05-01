package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;


/**
 * Created by pc on 15.08.2017.
 */

public class Rock {

    private Circle rock_collision;
    private Vector2 rockPosition;
    private Random random;

    public Rock(){

        random = new Random();
        rockPosition = new Vector2(0,0);
        rock_collision = new Circle(rockPosition.x,rockPosition.y,13);
    }
    public void setRockPosition(int xmax,int xmin,int ymax,int ymin){

        random = new Random();
        rockPosition.set(random.nextInt(xmax-xmin)+xmin,random.nextInt(ymax-ymin)+ymin);
        rock_collision.setPosition(rockPosition.x,rockPosition.y);
    }

    public boolean collides(Circle ship_collision){
        return ship_collision.overlaps(rock_collision);
    }
    public Vector2 getRockPosition() {
        return rockPosition;
    }
}
