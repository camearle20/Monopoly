package net.came20.monopoly.run.server.manager;

import net.came20.camecommand.CameCommand;
import net.came20.monopoly.command.AnnounceWrapper;
import net.came20.monopoly.command.update.PlayerUpdate;
import net.came20.monopoly.command.update.parameter.NewServerPlayerUpdateReferenceParameter;
import net.came20.monopoly.common.Player;
import net.came20.monopoly.common.event.*;
import net.came20.monopoly.run.server.AnnounceSocket;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cameronearle on 12/27/16.
 */
public class PlayerManager {
    private static List<Player> players = new ArrayList<>();

    private static EventGroup<PlayerUpdateEventHandler> eventGroup = new EventGroup<>();

    public static void init() {
        eventGroup.addEventHandler(new PlayerUpdateEventHandler() {
            @Override
            @Sided(Side.SERVER)
            public void onEvent(PlayerUpdateEvent playerUpdateEvent) {
                AnnounceSocket.addToQueue(new AnnounceWrapper(new CameCommand(PlayerUpdate.NEW_SERVER_PLAYER_UPDATE_REF,
                        new NewServerPlayerUpdateReferenceParameter(playerUpdateEvent.getNewPlayer())),
                        playerUpdateEvent.getNewPlayer().getToken()));
                System.out.println("Player [" + playerUpdateEvent.getNewPlayer().getName() + "] has been updated, broadcasting!");
            }
        });
    }

    public static void addPlayer(Player player) {
        players.add(player);
        //LINK ALL EVENT HANDLERS TO THE MASTER PLAYER UPDATE HOOK:
        player.getBankAccount().getEventGroup().addEventHandler(new MoneyStackChangeEventHandler() {
            @Override
            @Sided(Side.SERVER)
            public void onEvent(MoneyStackChangeEvent moneyStackChangeEvent) {
                eventGroup.callGroup(new PlayerUpdateEvent(player));
            }
        });
        player.getRealEstateBank().getEventGroup().addEventHandler(new TitleDeedStackChangeEventHandler() {
            @Override
            @Sided(Side.SERVER)
            public void onEvent(TitleDeedStackChangeEvent titleDeedStackChangeEvent) {
                eventGroup.callGroup(new PlayerUpdateEvent(player));
            }
        });
    }

    public static Player getPlayerByIndex(int index) {
        if (index >= players.size()) {
            return null;
        } else {
            return players.get(index);
        }
    }

    public static Player getPlayerByToken(String token) {
        Player finalPlayer = null;
        for (Player player : players) {
            if (player.getToken().equals(token)) {
                finalPlayer = player;
                break;
            }
        }
        return finalPlayer;
    }

    public static int getIndexByPlayer(Player player) {
        return players.indexOf(player);
    }

    public static int getNumberOfPlayers() {
        return players.size();
    }
}
