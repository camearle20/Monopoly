package net.came20.monopoly.command.join.parameter;

import net.came20.camecommand.command.Command;
import net.came20.camecommand.parameter.Parameter;
import net.came20.monopoly.command.join.Join;

/**
 * Created by cameronearle on 12/28/16.
 */
public class JoinAnnounceParameter extends Parameter {
    private String playerName;
    private String token;

    public JoinAnnounceParameter(String playerName, String token) {
        this.playerName = playerName;
        this.token = token;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Command getAssocCommand() {
        return Join.JOIN_ANN;
    }
}
