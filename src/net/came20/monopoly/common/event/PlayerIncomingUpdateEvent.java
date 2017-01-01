package net.came20.monopoly.common.event;

import net.came20.monopoly.common.Player;

/**
 * Created by cameronearle on 12/28/16.
 */
public class PlayerIncomingUpdateEvent implements Event {
    private Player newPlayer;

    public PlayerIncomingUpdateEvent(Player newPlayer) {
        this.newPlayer = newPlayer;
    }

    public Player getNewPlayer() {
        return newPlayer;
    }
}
