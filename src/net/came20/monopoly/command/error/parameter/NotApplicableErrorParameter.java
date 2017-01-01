package net.came20.monopoly.command.error.parameter;

import net.came20.camecommand.command.Command;
import net.came20.camecommand.parameter.Parameter;
import net.came20.monopoly.command.error.Error;

/**
 * Created by cameronearle on 12/29/16.
 */
public class NotApplicableErrorParameter extends Parameter {
    @Override
    public Command getAssocCommand() {
        return Error.NOT_APPLICABLE_ERR;
    }
}
