package net.came20.monopoly.command.trade.parameter;

import net.came20.camecommand.parameter.Parameter;
import net.came20.monopoly.common.Player;

/**
 * Created by cameronearle on 12/27/16.
 */
abstract class TradeParameter extends Parameter {
    private Player to;
    private Player from;

    public Player getTo() {
        return to;
    }

    public Player getFrom() {
        return from;
    }
}
