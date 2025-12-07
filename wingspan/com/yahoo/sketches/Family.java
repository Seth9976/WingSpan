package com.yahoo.sketches;

import java.util.HashMap;
import java.util.Map;

public enum Family {
    ALPHA(1, "Alpha", 3, 3),
    QUICKSELECT(2, "QuickSelect", 3, 3),
    COMPACT(3, "Compact", 1, 3),
    UNION(4, "Union", 4, 4),
    INTERSECTION(5, "Intersection", 3, 3),
    A_NOT_B(6, "AnotB", 3, 3),
    HLL(7, "HLL", 1, 1),
    QUANTILES(8, "QUANTILES", 1, 2),
    TUPLE(9, "TUPLE", 1, 1),
    FREQUENCY(10, "FREQUENCY", 1, 4),
    RESERVOIR(11, "RESERVOIR", 1, 2),
    RESERVOIR_UNION(12, "RESERVOIR_UNION", 1, 1),
    VAROPT(13, "VAROPT", 1, 4),
    VAROPT_UNION(14, "VAROPT_UNION", 1, 4),
    KLL(15, "KLL", 1, 2);

    private String famName_;
    private int id_;
    private static final Map lookupFamName;
    private static final Map lookupID;
    private int maxPreLongs_;
    private int minPreLongs_;

    private static Family[] $values() [...] // Inlined contents

    static {
        Family.lookupID = new HashMap();
        Family.lookupFamName = new HashMap();
        Family[] arr_family = (Family[])Family.$VALUES.clone();
        for(int v = 0; v < arr_family.length; ++v) {
            Family family0 = arr_family[v];
            Family.lookupID.put(family0.getID(), family0);
            Family.lookupFamName.put(family0.getFamilyName().toUpperCase(), family0);
        }
    }

    private Family(int id, String famName, int minPreLongs, int maxPreLongs) {
        this.id_ = id;
        this.famName_ = famName.toUpperCase();
        this.minPreLongs_ = minPreLongs;
        this.maxPreLongs_ = maxPreLongs;
    }

    public void checkFamilyID(int id) {
        if(id != this.id_) {
            throw new SketchesArgumentException("Possible Corruption: This Family " + this.toString() + " does not match the ID of the given Family: " + Family.idToFamily(id).toString());
        }
    }

    public String getFamilyName() {
        return this.famName_;
    }

    public int getID() {
        return this.id_;
    }

    public int getMaxPreLongs() {
        return this.maxPreLongs_;
    }

    public int getMinPreLongs() {
        return this.minPreLongs_;
    }

    public static Family idToFamily(int id) {
        Family family0 = (Family)Family.lookupID.get(id);
        if(family0 == null) {
            throw new SketchesArgumentException("Possible Corruption: Illegal Family ID: " + id);
        }
        return family0;
    }

    public static Family stringToFamily(String famName) {
        Family family0 = (Family)Family.lookupFamName.get(famName.toUpperCase());
        if(family0 == null) {
            throw new SketchesArgumentException("Possible Corruption: Illegal Family Name: " + famName);
        }
        return family0;
    }

    @Override
    public String toString() {
        return this.famName_;
    }
}

