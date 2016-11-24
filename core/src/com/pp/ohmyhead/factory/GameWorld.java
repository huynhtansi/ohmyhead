package com.pp.ohmyhead.factory;

import com.pp.ohmyhead.model.ScreenScrolling;

/**
 * Created by htsi.
 * Since: 11/18/16 on 11:35 AM
 * Project: ohmyhead
 */
public class GameWorld {

    private ScreenScrolling screenScrolling;

    public enum GameStatus {
        READY, RUNNING, END
    }

    private GameStatus gameStatus;

    public GameWorld() {
        screenScrolling = new ScreenScrolling();
        gameStatus = GameStatus.RUNNING;
    }

    public void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        screenScrolling.update(delta);
    }

    public void update(float delta) {
        switch (gameStatus) {
            case RUNNING:
                updateRunning(delta);
        }
    }

    public ScreenScrolling getScreenScrolling() {
        return screenScrolling;
    }
}
