package com.pp.ohmyhead.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by htsi.
 * Since: 11/18/16 on 11:34 AM
 * Project: ohmyhead
 */
public class ScreenScrolling {

    public static final int SCROLL_SPEED = 1;

    private Background bA, bB;
    public int overMap = 0;

    private Background startLine;

    private long lastSpawbObstacleTime;
    public Array<Obstacle> obstacles;

    public int distance;

    public ScreenScrolling() {

        bA = new Background(0, 0, 1536, 2048, SCROLL_SPEED);
        bB = new Background(0, -bA.height/4, 1536, 2048, SCROLL_SPEED);

        startLine = new Background(0, 474, 1536, 154, SCROLL_SPEED);

        obstacles = new Array<Obstacle>();
        spawnObstacle();
    }

    private void spawnObstacle() {

        int obType = MathUtils.random(1) + 1;
        int width = 0, height = 0;

        switch (overMap) {
            case 0:
                width = 600; height = 216;
                break;
            case 1:
                width = 605; height = 236;
                if (obType == 2) {
                    width = 600; height = 223;
                }
                break;
            case 2:
                width = 600; height = 200;
                break;

        }

        Obstacle obstacle = new Obstacle(MathUtils.random(0, 384-75), -54, width, height, SCROLL_SPEED);
        obstacle.setType(obType);

        Gdx.app.log("SpawnObstacle",
                "X: " + obstacle.getX() +
                " Y: " + obstacle.getY() +
                " Width: " + obstacle.getWidth() +
                " Height: " + obstacle.getHeight() +
                " Type: " + obstacle.getType());

        obstacles.add(obstacle);
        lastSpawbObstacleTime = TimeUtils.millis();
    }

    public void update(float delta) {

        if (TimeUtils.millis() - lastSpawbObstacleTime > 4000) {
            spawnObstacle();
        }

        for (Obstacle obstacle:obstacles)
            obstacle.update(delta);

        bA.update(delta);
        bB.update(delta);
        startLine.update(delta);



        if (bA.isVerticalScrolling) {
            if (distance > 500 && bA.getMapType() == 1) {
                bA.setMapType(2);
                if (overMap == 0) {
                    startLine.reset(-38);
                    overMap += 1;
                }
            }
            if (distance > 1500 && bA.getMapType() == 2) {
                bA.setMapType(3);
                if (overMap == 1) {
                    startLine.reset(-38);
                    overMap += 1;
                }
            }
            bA.reset(-bA.height/4);
        }

        if (bB.isVerticalScrolling) {
            if (distance > 500 && bB.getMapType() == 1) {
                bB.setMapType(2);
                if (overMap == 0) {
                    startLine.reset(-38);
                    overMap += 1;
                }
            }
            if (distance > 1500 && bB.getMapType() == 2) {
                bB.setMapType(3);
                if (overMap == 1) {
                    startLine.reset(-38);
                    overMap += 1;
                }
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
