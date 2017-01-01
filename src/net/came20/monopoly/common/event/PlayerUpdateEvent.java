package net.came20.monopoly.common.event;

import net.came20.monopoly.common.Player;

/**
 * Created by cameronearle on 12/28/16.
 */
public class PlayerUpdateEvent implements Event {
    private Player newPlayer;

    public PlayerUpdateEvent(Player player) {
        newPlayer = player;
    }

    public Player getNewPlayer() {
        return newPlayer;
    }
}
