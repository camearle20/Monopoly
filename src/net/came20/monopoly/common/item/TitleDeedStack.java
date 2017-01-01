package net.came20.monopoly.common.item;

import net.came20.monopoly.common.event.EventGroup;
import net.came20.monopoly.common.event.TitleDeedStackChangeEvent;
import net.came20.monopoly.common.event.TitleDeedStackChangeEventHandler;
import net.came20.monopoly.common.realestate.Properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cameronearle on 12/28/16.
 */
public class TitleDeedStack extends Item {
    private LinkedHashMap<Properties, TitleDeed> titleDeeds = new LinkedHashMap<>();

    public TitleDeedStack() {
        setEventGroup(new EventGroup<TitleDeedStackChangeEventHandler>());
    }

    public LinkedHashMap<Properties, TitleDeed> getTitleDeedMap() {
        return titleDeeds;
    }

    public void setTitleDeedMap(LinkedHashMap<Properties, TitleDeed> titleDeeds) {
        this.titleDeeds = titleDeeds;
    }

    public void addTitleDeed(TitleDeed titleDeed) {
        titleDeeds.put(titleDeed.getProperty(), titleDeed);
        getEventGroup().callGroup(new TitleDeedStackChangeEvent(titleDeeds));
    }

    public TitleDeed getTitleDeedByProperty(Properties property) {
        if (!titleDeeds.containsKey(property)) {
            return new TitleDeed(Properties.NONE);
        } else {
            TitleDeed toReturn = titleDeeds.remove(property);
            getEventGroup().callGroup(new TitleDeedStackChangeEvent(titleDeeds));
            return toReturn;
        }
    }

    public int getNumberOfTitleDeeds() {
        return titleDeeds.size();
    }

    @Deprecated
    public TitleDeed getTitleByIndex(int index) { //Really, please don't use this.  It probably really seriously doesn't work
        if (index >= titleDeeds.size()) {
            return new TitleDeed(Properties.NONE);
        } else {
            Properties wantedProperty = (Properties) titleDeeds.keySet().toArray()[index];
            TitleDeed toReturn =  titleDeeds.remove(wantedProperty);
            getEventGroup().callGroup(new TitleDeedStackChangeEvent(titleDeeds));
            return toReturn;
        }
    }
}
