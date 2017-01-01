package net.came20.monopoly.command.update.parameter;

import net.came20.camecommand.command.Command;
import net.came20.camecommand.parameter.Parameter;
import net.came20.monopoly.command.update.PlayerUpdate;
import net.came20.monopoly.common.Player;

/**
 * Created by cameronearle on 12/28/16.
 */
public class NewServerPlayerUpdateReferenceParameter extends Parameter {
    private Player newPlayerRef;

    public NewServerPlayerUpdateReferenceParameter(Player player) {
        newPlayerRef = player;
    }

    public Player getNewPlayerRef() {
        return newPlayerRef;
    }

    @Override
    public Command getAssocCommand() {
        return PlayerUpdate.NEW_SERVER_PLAYER_UPDATE_REF;
    }
}
