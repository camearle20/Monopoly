package net.came20.monopoly.command;

import net.came20.camecommand.CameCommand;

/**
 * Created by cameronearle on 12/29/16.
 */
public class AnnounceWrapper {
    private CameCommand command;
    private String target;

    public AnnounceWrapper(CameCommand command, String target) {
        this.command = command;
        this.target = target;
    }

    public AnnounceWrapper(CameCommand command) {
        this(command, "ALL");
    }

    public CameCommand getCommand() {
        return command;
    }

    public String getTarget() {
        return target;
    }

}
