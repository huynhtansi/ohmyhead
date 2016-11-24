package com.pp.ohmyhead.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by htsi.
 * Since: 11/18/16 on 11:31 AM
 * Project: ohmyhead
 */
public class VerticalScrollable {

    protected Vector2 position;
    protected Vector2 velocity;

    protected int width;
    protected int height;

    protected boolean isVerticalScrolling;

    public VerticalScrollable(float x, float y, int width, int height, float speedScroll) {
        position = new Vector2(x,y);
        velocity = new Vector2(0, speedScroll);

        this.width = width;
        this.height =height;

        isVerticalScrolling = false;
    }

    public void update(float delta) {
        position.y += 1;
        if (position.y > height/4) {
            isVerticalScrolling = true;
        }
    }

    public void stop() {
        velocity.y = 0;
    }

    public void reset(float newY) {
        position.y = newY;
        isVerticalScrolling = false;
    }

    public float getBottomY() {
        return position.y;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
