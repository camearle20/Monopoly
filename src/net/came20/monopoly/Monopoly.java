package net.came20.monopoly;

import net.came20.monopoly.common.event.Side;
import net.came20.monopoly.run.board.RunBoard;
import net.came20.monopoly.run.player.RunPlayer;
import net.came20.monopoly.run.server.RunServer;

/**
 * Created by cameronearle on 12/27/16.
 */
public class Monopoly {
    private static Side side = null;

    public static Side getSide() {
        return side;
    }

    public static void main(String[] args) {
        String run = "player";
        if (args.length > 0) {
            run = args[0];
        }

        switch (run.toLowerCase()) {
            case "player":
                side = Side.PLAYER;
                RunPlayer runPlayer = new RunPlayer();
                runPlayer.run();
                break;
            case "server":
                side = Side.SERVER;
                RunServer runServer = new RunServer();
                runServer.run();
                break;
            case "board":
                side = Side.BOARD;
                RunBoard runBoard = new RunBoard();
                runBoard.run();
                break;
            default:
                side = Side.PLAYER;
                RunPlayer runPlayer1 = new RunPlayer();
                runPlayer1.run();
                break;
        }
    }
}
