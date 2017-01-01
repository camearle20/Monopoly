package net.came20.monopoly.command.join.parameter;

import net.came20.camecommand.command.Command;
import net.came20.camecommand.parameter.Parameter;
import net.came20.monopoly.command.join.Join;
import net.came20.monopoly.common.Player;

/**
 * Created by cameronearle on 12/28/16.
 */
public class JoinReplyParameter extends Parameter {
    private Player initPlayer;

    public JoinReplyParameter(Player initPlayer) {
        this.initPlayer = initPlayer;
    }

    public Player getInitPlayer() {
        return initPlayer;
    }

    @Override
    public Command getAssocCommand() {
        return Join.JOIN_REP;
    }
}
