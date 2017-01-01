package net.came20.monopoly.run.server.sequence;

import net.came20.camecommand.CameCommand;
import net.came20.monopoly.command.AnnounceWrapper;
import net.came20.monopoly.command.error.Error;
import net.came20.monopoly.command.error.parameter.NotApplicableErrorParameter;
import net.came20.monopoly.command.join.Join;
import net.came20.monopoly.command.join.parameter.JoinAnnounceParameter;
import net.came20.monopoly.command.join.parameter.JoinReplyParameter;
import net.came20.monopoly.command.join.parameter.JoinRequestParameter;
import net.came20.monopoly.common.Player;
import net.came20.monopoly.run.server.AnnounceSocket;
import net.came20.monopoly.run.server.CommSocket;
import net.came20.monopoly.run.server.manager.PlayerManager;

/**
 * Created by cameronearle on 12/29/16.
 */
public class PlayerJoinSequence {
    public static void joinPlayers(int numberOfPlayers) {
        while (PlayerManager.getNumberOfPlayers() < numberOfPlayers) { //While there are not enough players
            CameCommand recvCommand = CommSocket.listen(); //Listen for commands
            if (recvCommand.getParameter().equals(Join.JOIN_REQ)) { //If the command is a join request
                JoinRequestParameter parameter = (JoinRequestParameter) recvCommand.getParameter(); //Cast the parameter
                System.out.println("Player [" + parameter.getPlayerName() + "] has requested to join");
                Player player = new Player(parameter.getPlayerName()); //Create a new player object with the received name
                PlayerManager.addPlayer(player); //Add the new player to the playermanager
                CameCommand replyCommand = new CameCommand(Join.JOIN_REP, new JoinReplyParameter(player)); //Build a response containing the player
                CommSocket.respond(recvCommand); //Send the response

                CameCommand joinAnnouncement = new CameCommand(Join.JOIN_ANN, new JoinAnnounceParameter(player.getName(), player.getToken())); //Build an announcement to send to all other players
                AnnounceSocket.addToQueue(new AnnounceWrapper(joinAnnouncement)); //Send the announcement
            } else { //The command is not a join request
                CommSocket.respond(new CameCommand(Error.NOT_APPLICABLE_ERR, new NotApplicableErrorParameter()));
            }
        }
    }
}
