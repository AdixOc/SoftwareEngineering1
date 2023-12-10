package de.hbrs.team22.parkhaus_projekt;

import java.util.LinkedList;
import java.util.List;

public class Parkhaus {
    private final List<ParkhausLevel> levels;

    public Parkhaus() {
        this.levels = new LinkedList<>();
    }

    public List<ParkhausLevel> getLevels() {
        return levels;
    }

    public boolean isLevelPresentByName(String name) {
        for (ParkhausLevel level : levels) {
            if (level.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // TODO: maybe throw exception if level is not present
    public ParkhausLevel getLevelByName(String name) {
        for (ParkhausLevel level : levels) {
            if (level.getName().equals(name)) {
                return level;
            }
        }
        return null;
    }

    public void addLevel(ParkhausLevel level) {
        this.levels.add(level);
    }

    public void addLevel(String name, int capacity, double price) {
        this.levels.add(new ParkhausLevel(name, capacity, price));
    }

    public boolean removeLevel(ParkhausLevel level) {
        return this.levels.remove(level);
    }
}
