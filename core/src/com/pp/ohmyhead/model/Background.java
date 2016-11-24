package com.pp.ohmyhead.model;

/**
 * Created by htsi.
 * Since: 11/18/16 on 11:34 AM
 * Project: ohmyhead
 */
public class Background extends VerticalScrollable {

    private int mapType;

    public Background(float x, float y, int width, int height, float speedScroll) {
        super(x, y, width, height, speedScroll);
        mapType = 1;
    }

    public void restart(float y, float scrollSpeed) {
        position.y = y;
        velocity.y = scrollSpeed;
    }

    public void setMapType(int mapType) {
        this.mapType = mapType;
    }

    public int getMapType() {
        return mapType;
    }
}
