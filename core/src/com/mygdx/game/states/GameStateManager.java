package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by pc on 07.08.2017.
 * Stateleri stackte tutan işlem sırasına alan sınıf
 */

public class GameStateManager {

    private Stack<State> states;



    public GameStateManager(){
        states = new Stack<State>();//yeni stack

    }

    public void push(State state){
        states.push(state);//state push
    }
    public void pop(){
        states.pop().dispose();
    }
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }
    public void update(float dt){
            states.peek().update(dt);


    }
    public void render(SpriteBatch sp){
        states.peek().render(sp);//render
    }
}
