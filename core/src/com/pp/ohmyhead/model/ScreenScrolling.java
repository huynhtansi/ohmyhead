package com.pp.ohmyhead.model;

import com.badlogic.gdx.Gdx;

/**
 * Created by htsi.
 * Since: 11/18/16 on 11:34 AM
 * Project: ohmyhead
 */
public class ScreenScrolling {

    public static final int SCROLL_SPEED = 1;

    private Background bA, bB;

    private Background startLine;

    public int distance;

    public ScreenScrolling() {

        bA = new Background(0, 0, 1536, 2048, SCROLL_SPEED);
        bB = new Background(0, -bA.height/4, 1536, 2048, SCROLL_SPEED);

        startLine = new Background(0, 474, 1536, 154, SCROLL_SPEED);
    }

    public void update(float delta) {

        bA.update(delta);
        bB.update(delta);
        startLine.update(delta);

        if (bA.isVerticalScrolling) {
            if (distance > 500 && distance < 520) {
                bA.setMapType(2);

                startLine.reset(-38);
            }
            bA.reset(-bA.height/4);
        }

        if (bB.isVerticalScrolling) {
            if (distance > 500 && distance < 520) {
                bB.setMapType(2);
                startLine.reset(-38);
            }
            bB.reset(-bB.height/4);
        }

        distance += 1;
    }

    public Background getbA() {
        return bA;
    }

    public Background getbB() {
        return bB;
    }

    public Background getStartLine() {
        return startLine;
    }
}
