package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by pc on 09.08.2017.
 */

public class Ship {

    private Circle ship_collision;
    private Vector2 ship_position;
    private Vector2 velocity,velocity_test;


    public Ship(int x, int y){
        velocity_test = new Vector2(0,200);
        ship_position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        ship_collision = new Circle(ship_position.x,ship_position.y,10);
    }

    public Vector2 getVelocity() {
        return velocity;
    }
    public void setVelocity(int x,int y) {
        velocity.add(x,y);
    }

    public void goLeft(){
        ship_position.x += -10;
    }
    public void goRight(){
        ship_position.x += 10;
    }
    public void update(float dt){
        velocity_test.scl(dt);
        //Gdx.app.log("velo", Float.toString(velocity.y)); velocity ivmeli
       // normalde ship_position.add(velocity.x,2);
        ship_position.add(velocity_test);
     // Gdx.app.log("velo", Float.toString(velocity_test.y));
        velocity_test.scl(1/dt);
        ship_collision.setPosition(ship_position.x,ship_position.y);
    }


    public Circle getShip_collision() {
        return ship_collision;
    }
    public Vector2 getPosition() {
        return ship_position;

    }
}
