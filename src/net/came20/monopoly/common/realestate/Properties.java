package net.came20.monopoly.common.realestate;

/**
 * Created by cameronearle on 12/27/16.
 */
public enum Properties {
    WRITING_RAILROAD(PropertyType.RAILROAD),
    NEVADA_RALIROAD(PropertyType.RAILROAD),
    DEODORANT_RAILROAD(PropertyType.RAILROAD),
    LONG_LINE(PropertyType.RAILROAD),

    CABLE_COMPANY(PropertyType.UTILITY),
    SEWAGE_PLANT(PropertyType.UTILITY),

    AEGEAN_AVENUE(PropertyType.HOVEL_HABITAT),
    SIBERIA_STREET(PropertyType.HOVEL_HABITAT),
    TIBETAN_LANE(PropertyType.TRASHY_TRAILERPARK),
    NEWHAMPSHIRE_STREET(PropertyType.TRASHY_TRAILERPARK),
    RHODEISLAND_WAY(PropertyType.TRASHY_TRAILERPARK),
    SAINTGEORGES_PLACE(PropertyType.HUMBLE_HOMESTEAD),
    COLONY_LANE(PropertyType.HUMBLE_HOMESTEAD),
    CAROLINA_COURT(PropertyType.HUMBLE_HOMESTEAD),
    SAINTTHOMAS_PLACE(PropertyType.TRENDY_TOWNHOUSE),
    KENTUCKY_COURT(PropertyType.TRENDY_TOWNHOUSE),
    NEWJERSEY_AVENUE(PropertyType.TRENDY_TOWNHOUSE),
    OHIO_BOULEVARD(PropertyType.ABOVEAVERAGE_ABODE),
    WISCONSIN_WAY(PropertyType.ABOVEAVERAGE_ABODE),
    MICHIGAN_LANE(PropertyType.ABOVEAVERAGE_ABODE),
    PACIFIC_PROMENADE(PropertyType.ELEGANT_ESTATE),
    ARAPAHO_AVENUE(PropertyType.ELEGANT_ESTATE),
    COLORADO_CONSERVATORY(PropertyType.ELEGANT_ESTATE),
    GULF_VISTA(PropertyType.PRESTIGIOUS_PENTHOUSE),
    COSTAL_COLONNADE(PropertyType.PRESTIGIOUS_PENTHOUSE),
    DELAWARE_BOULEVARD(PropertyType.PRESTIGIOUS_PENTHOUSE),
    XANADU_WAY(PropertyType.POMPOUS_PALACE),
    NIRVANA(PropertyType.POMPOUS_PALACE),

    NONE(null);


    private PropertyType type;

    Properties(PropertyType type) {
        this.type = type;
    }

    public PropertyType getType() {
        return type;
    }
}
