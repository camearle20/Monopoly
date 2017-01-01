package net.came20.monopoly.run.player;

import net.came20.camecommand.CameCommand;
import net.came20.monopoly.command.join.Join;
import net.came20.monopoly.command.join.parameter.JoinReplyParameter;
import net.came20.monopoly.command.join.parameter.JoinRequestParameter;
import net.came20.monopoly.command.update.PlayerUpdate;
import net.came20.monopoly.common.Player;
import net.came20.monopoly.common.Tokenizer;
import net.came20.monopoly.common.data.Benefit;
import net.came20.monopoly.common.data.Expense;
import net.came20.monopoly.common.data.MoneyModifier;
import net.came20.monopoly.common.event.*;
import net.came20.monopoly.common.item.MoneyStack;
import net.came20.monopoly.run.player.gui.TestDialog;
import org.zeromq.ZMQ;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cameronearle on 12/27/16.
 */
public class RunPlayer implements Runnable {
    public static Player player;
    public static String token;
    public static final EventGroup<PlayerIncomingUpdateEventHandler> incomingUpdateGroup = new EventGroup<>();

    @Override
    public void run() {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect("tcp://127.0.0.1:8100");


        socket.send(new CameCommand(Join.JOIN_REQ, new JoinRequestParameter("BobbyJoe")).encode());
        CameCommand response = new CameCommand(socket.recvStr());

        Player gottenPlayer = ((JoinReplyParameter) response.getParameter()).getInitPlayer();

        token = gottenPlayer.getToken();

        AnnounceReceiver announceReceiver = new AnnounceReceiver("tcp://127.0.0.1:8101", token);
        Thread announceReceiverThread = new Thread(announceReceiver);
        announceReceiverThread.start();

        player = gottenPlayer;
        player.getBankAccount().getEventGroup().clearGroup();

        System.out.println("Got our player, stats:");
        System.out.println(player.getToken());
        System.out.println(player.getName());
        System.out.println(player.getBankAccount().getValue());

        incomingUpdateGroup.addEventHandler(new PlayerIncomingUpdateEventHandler() {
            @Override
            public void onEvent(PlayerIncomingUpdateEvent playerIncomingUpdateEvent) {
                System.out.println("Got a new player");
                EventGroup<MoneyStackChangeEventHandler> oldBankEventGroup = player.getBankAccount().getEventGroup(); //Backup the old event group
                player = new Player(playerIncomingUpdateEvent.getNewPlayer()); //Overwrite the player
                player.getBankAccount().getEventGroup().clearGroup(); //Wipe the event group
                player.getBankAccount().setEventGroup(oldBankEventGroup); //Restore the old event group
                player.getBankAccount().getEventGroup().callGroup(new MoneyStackChangeEvent(player.getBankAccount().getValue())); //Call an update to the handler
                System.out.println("Updated Player");
            }
        });

        player.getBankAccount().getEventGroup().addEventHandler(new MoneyStackChangeEventHandler() {
            @Override
            @Sided(Side.PLAYER)
            public void onEvent(MoneyStackChangeEvent moneyStackChangeEvent) {
                System.out.println(moneyStackChangeEvent.getAmount());
            }
        });

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
