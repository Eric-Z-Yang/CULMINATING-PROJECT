package com.ics.culminatinggame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Door extends GameObject{

    public Door (Texture objectTexture, Rectangle objectHitBox) {
        super (objectTexture, objectHitBox);

        doorImageOpen = new Texture("Door Open 64ver.png");
        doorImageClose = new Texture("Door Closed 64ver.png");

        doorRectangleOpen = new Rectangle(1, 1, doorRectangleOpen.getWidth(), doorImageOpen.getHeight());
        doorRectangleClose = new Rectangle(1, 1, doorRectangleClose.getWidth(), doorImageClose.getHeight());
    }

    //public void () {



   // }
}
