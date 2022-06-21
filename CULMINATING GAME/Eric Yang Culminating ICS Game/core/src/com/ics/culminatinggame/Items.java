package com.ics.culminatinggame;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;

public class Items extends GameObject{

    private int itemX;
    private int itemY;

    private Array<Rectangle> keys;

    public Items (Texture objectTexture, Rectangle objectHitBox, int itemX, int itemY) {

        super (objectTexture, objectHitBox);

        this.itemX = itemX;
        this.itemY = itemY;
    }


}
