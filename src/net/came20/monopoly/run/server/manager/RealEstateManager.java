package net.came20.monopoly.run.server.manager;

import net.came20.monopoly.common.item.TitleDeed;
import net.came20.monopoly.common.realestate.Properties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cameronearle on 12/27/16.
 */
public class RealEstateManager {
    private static Map<Properties, TitleDeed> realEstateBank = new HashMap<>();

    public static void init() {
        realEstateBank.put(Properties.WRITING_RAILROAD, new TitleDeed(Properties.WRITING_RAILROAD));
        realEstateBank.put(Properties.NEVADA_RALIROAD, new TitleDeed(Properties.NEVADA_RALIROAD));
        realEstateBank.put(Properties.DEODORANT_RAILROAD, new TitleDeed(Properties.DEODORANT_RAILROAD));
        realEstateBank.put(Properties.LONG_LINE, new TitleDeed(Properties.LONG_LINE));
        realEstateBank.put(Properties.CABLE_COMPANY, new TitleDeed(Properties.CABLE_COMPANY));
        realEstateBank.put(Properties.SEWAGE_PLANT, new TitleDeed(Properties.SEWAGE_PLANT));
        realEstateBank.put(Properties.AEGEAN_AVENUE, new TitleDeed(Properties.AEGEAN_AVENUE));
        realEstateBank.put(Properties.SIBERIA_STREET, new TitleDeed(Properties.SIBERIA_STREET));
        realEstateBank.put(Properties.TIBETAN_LANE, new TitleDeed(Properties.TIBETAN_LANE));
        realEstateBank.put(Properties.NEWHAMPSHIRE_STREET, new TitleDeed(Properties.NEWHAMPSHIRE_STREET));
        realEstateBank.put(Properties.RHODEISLAND_WAY, new TitleDeed(Properties.RHODEISLAND_WAY));
        realEstateBank.put(Properties.SAINTGEORGES_PLACE, new TitleDeed(Properties.SAINTGEORGES_PLACE));
        realEstateBank.put(Properties.COLONY_LANE, new TitleDeed(Properties.COLONY_LANE));
        realEstateBank.put(Properties.CAROLINA_COURT, new TitleDeed(Properties.CAROLINA_COURT));
        realEstateBank.put(Properties.SAINTTHOMAS_PLACE, new TitleDeed(Properties.SAINTTHOMAS_PLACE));
        realEstateBank.put(Properties.KENTUCKY_COURT, new TitleDeed(Properties.KENTUCKY_COURT));
        realEstateBank.put(Properties.NEWJERSEY_AVENUE, new TitleDeed(Properties.NEWJERSEY_AVENUE));
        realEstateBank.put(Properties.OHIO_BOULEVARD, new TitleDeed(Properties.OHIO_BOULEVARD));
        realEstateBank.put(Properties.WISCONSIN_WAY, new TitleDeed(Properties.WISCONSIN_WAY));
        realEstateBank.put(Properties.MICHIGAN_LANE, new TitleDeed(Properties.MICHIGAN_LANE));
        realEstateBank.put(Properties.PACIFIC_PROMENADE, new TitleDeed(Properties.PACIFIC_PROMENADE));
        realEstateBank.put(Properties.ARAPAHO_AVENUE, new TitleDeed(Properties.ARAPAHO_AVENUE));
        realEstateBank.put(Properties.COLORADO_CONSERVATORY, new TitleDeed(Properties.COLORADO_CONSERVATORY));
        realEstateBank.put(Properties.GULF_VISTA, new TitleDeed(Properties.GULF_VISTA));
        realEstateBank.put(Properties.COSTAL_COLONNADE, new TitleDeed(Properties.COSTAL_COLONNADE));
        realEstateBank.put(Properties.DELAWARE_BOULEVARD, new TitleDeed(Properties.DELAWARE_BOULEVARD));
        realEstateBank.put(Properties.XANADU_WAY, new TitleDeed(Properties.XANADU_WAY));
        realEstateBank.put(Properties.NIRVANA, new TitleDeed(Properties.NIRVANA));
    }

    public static TitleDeed getDeedFromBank(Properties property) {
        if (realEstateBank.containsKey(property)) {
            return realEstateBank.remove(property);
        } else {
            return new TitleDeed(Properties.NONE);
        }
    }

    public static void putDeedInBank(TitleDeed titleDeed) {
        realEstateBank.put(titleDeed.getProperty(), titleDeed);
    }

    public static boolean containsDeed(Properties property) {
        return realEstateBank.containsKey(property);
    }
}
