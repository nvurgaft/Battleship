package states;

import board.Board;

import java.util.logging.Logger;

public class GameSetupScreen extends State {

    public static Logger logger = Logger.getLogger(GameSetupScreen.class.getName());

    private Board board;

    @Override
    protected void onCreate() {
        logger.info("GameSetupScreen: onCreate");
        board = new Board();
    }

    @Override
    protected void onEnter() {
        logger.info("GameSetupScreen: onEnter");
    }
}
