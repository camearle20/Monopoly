package net.came20.monopoly.common.event;

import net.came20.monopoly.common.item.TitleDeed;
import net.came20.monopoly.common.realestate.Properties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cameronearle on 12/28/16.
 */
public class TitleDeedStackChangeEvent implements Event {
    private LinkedHashMap<Properties, TitleDeed> titleDeeds = new LinkedHashMap<>();

    public TitleDeedStackChangeEvent(LinkedHashMap<Properties, TitleDeed> titleDeeds) {
        this.titleDeeds = titleDeeds;
    }

    public LinkedHashMap<Properties, TitleDeed> getTitleDeeds() {
        return titleDeeds;
    }

}
