package net.came20.monopoly.command.join.parameter;

import net.came20.camecommand.command.Command;
import net.came20.camecommand.parameter.Parameter;
import net.came20.monopoly.command.join.Join;

import java.net.NetworkInterface;

/**
 * Created by cameronearle on 12/27/16.
 */
public class JoinRequestParameter extends Parameter {
    private String playerName;

    public JoinRequestParameter(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public Command getAssocCommand() {
        return Join.JOIN_REQ;
    }
}
