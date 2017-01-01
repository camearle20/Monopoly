package net.came20.monopoly.common.item;

import net.came20.monopoly.common.realestate.Properties;
import net.came20.monopoly.common.realestate.PropertyType;

/**
 * Created by cameronearle on 12/27/16.
 */
public class TitleDeed extends Item {
    private Properties property;
    private boolean mortgaged;

    public TitleDeed(Properties property) {
        this.property = property;
        mortgaged = false;
    }

    public Properties getProperty() {
        return property;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }
}
