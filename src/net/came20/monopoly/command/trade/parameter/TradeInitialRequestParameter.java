package net.came20.monopoly.command.trade.parameter;

import net.came20.camecommand.command.Command;
import net.came20.monopoly.command.trade.Trade;

/**
 * Created by cameronearle on 12/27/16.
 */
public class TradeInitialRequestParameter extends TradeParameter {
    @Override
    public Command getAssocCommand() {
        return Trade.TRADE_INIT_REQ;
    }
}
