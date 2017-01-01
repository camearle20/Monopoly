package net.came20.monopoly.common.item;

import net.came20.monopoly.common.Tokenizer;
import net.came20.monopoly.common.event.EventGroup;

/**
 * Created by cameronearle on 12/27/16.
 */
public class Item {
    private final String token = Tokenizer.nextToken(); //Give every item a token
    private EventGroup eventGroup;

    public EventGroup getEventGroup() {
        return eventGroup;
    }

    public void setEventGroup(EventGroup eventGroup) { //Used to set up new handlers for items, and to patch in the static group when a new player update arrives
        this.eventGroup = eventGroup;
    }

    public String getToken() {
        return token;
    }
}
