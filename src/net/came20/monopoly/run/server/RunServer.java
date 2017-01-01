package net.came20.monopoly.run.server;

import net.came20.camecommand.CameCommand;
import net.came20.camecommand.command.Command;
import net.came20.camecommand.command.DefaultCommands;
import net.came20.camecommand.parameter.Parameter;
import net.came20.camecommand.parameter.ParameterNone;
import net.came20.monopoly.command.AnnounceWrapper;
import net.came20.monopoly.command.join.Join;
import net.came20.monopoly.command.join.parameter.JoinAnnounceParameter;
import net.came20.monopoly.command.join.parameter.JoinReplyParameter;
import net.came20.monopoly.command.join.parameter.JoinRequestParameter;
import net.came20.monopoly.common.Player;
import net.came20.monopoly.common.data.Expense;
import net.came20.monopoly.run.server.manager.BankManager;
import net.came20.monopoly.run.server.manager.PlayerManager;
import net.came20.monopoly.run.server.manager.RealEstateManager;
import net.came20.monopoly.run.server.manager.TradeManager;
import net.came20.monopoly.run.server.sequence.PlayerJoinSequence;
import org.zeromq.ZMQ;

/**
 * Created by cameronearle on 12/27/16.
 */
public class RunServer implements Runnable {
    @Override
    public void run() {
        //RUN INIT ON ALL MANAGERS
        BankManager.init();
        PlayerManager.init();
        RealEstateManager.init();
        TradeManager.init();

        //CONNECT SOCKETS
        CommSocket.init(); //Initialize the comm socket, binding it to this thread.
        CommSocket.connect("tcp://*:8100");
        AnnounceSocket announceSocket = new AnnounceSocket("tcp://*:8101");
        Thread announceSocketThread = new Thread(announceSocket);
        announceSocketThread.start();

        PlayerJoinSequence.joinPlayers(1); //Join 1 player, we now have a valid registered player

    }
}
