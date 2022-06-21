package com.ics.culminatinggame;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;


public class GameObject {

    private Texture objectTexture;

    private Rectangle objectHitBox;

    public GameObject () {

    }

    public GameObject (Texture objectTexture, Rectangle objectHitBox) {

        this.objectTexture = objectTexture;
        this.objectHitBox = objectHitBox;
    }

    public Texture getObjectTexture() {

        return objectTexture;
    }

    public Rectangle getObjectHitBox() {

        return objectHitBox;
    }

    public void setObjectTexture(Texture newObjectTexture) {

        this.objectTexture = newObjectTexture;
    }

    public void setObjectHitBox(Rectangle newObjectHitBox) {

        this.objectHitBox = newObjectHitBox;
    }
}
