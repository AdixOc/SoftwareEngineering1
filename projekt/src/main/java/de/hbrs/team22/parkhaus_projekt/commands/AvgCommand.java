package de.hbrs.team22.parkhaus_projekt.commands;

import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;

public class AvgCommand implements ServletCommandI {
    ParkhausLevelService parkhausLevelService;

    public AvgCommand(ParkhausLevelService parkhausLevelService) {
        this.parkhausLevelService = parkhausLevelService;
    }

    @Override
    public String execute() {
        double avg = 0.0;
        for (ParkhausLevel level : parkhausLevelService.getLevels()) {
            avg += level.getPrice();
        }
        return String.valueOf(avg / parkhausLevelService.getLevels().size());
    }
}
