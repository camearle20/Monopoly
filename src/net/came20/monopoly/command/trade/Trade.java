package net.came20.monopoly.command.trade;

import net.came20.camecommand.command.Command;

/**
 * Created by cameronearle on 12/27/16.
 */
public enum Trade implements Command {
    TRADE_INIT_REQ,
    TRADE_INIT_REP,
    TRADE_INIT_ANN,
    TRADE_ACPT_REQ,
    TRADE_ACPT_REP,
    TRADE_ACPT_ANN,
    TRADE_DENY_REQ,
    TRADE_DENY_REP,
    TRADE_OFFR_REQ,
    TRADE_OFFR_REP,
    TRADE_OFFR_ANN,
    TRADE_APPR_REQ,
    TRADE_APPR_REP,
    TRADE_APPR_ANN,
    TRADE_RJCT_REQ,
    TRADE_RJCT_REP,
    TRADE_RJCT_ANN
}
