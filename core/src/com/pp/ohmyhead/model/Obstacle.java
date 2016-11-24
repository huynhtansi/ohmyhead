package com.pp.ohmyhead.model;

/**
 * Created by htsi.
 * Since: 11/24/16 on 4:57 PM
 * Project: ohmyhead
 */
public class Obstacle extends VerticalScrollable {

    private int type;

    public Obstacle(float x, float y, int width, int height, float speedScroll) {
        super(x, y, width, height, speedScroll);
        type = 1;
    }

    public void restart(float y, float scrollSpeed) {
        position.y = y;
        velocity.y = scrollSpeed;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
