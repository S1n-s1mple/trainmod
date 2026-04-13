package net.smakkqq.trainmod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum CapibaraTypes {
    DEFAULT(0),
    WHITE(1);

    private static final CapibaraTypes[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(CapibaraTypes::getId)).toArray(CapibaraTypes[]::new);
    private final int id;

    CapibaraTypes(int id) {
	this.id = id;
    }

    public int getId() {
	return this.id;
    }

    public static CapibaraTypes byId(int id) {
	return BY_ID[id % BY_ID.length]; // хороший метод
    }
    
    
}
