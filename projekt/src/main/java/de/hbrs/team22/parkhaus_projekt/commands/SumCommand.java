package de.hbrs.team22.parkhaus_projekt.commands;

import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;

public class SumCommand implements ServletCommandI {
    ParkhausLevelService parkhausLevelService;

    public SumCommand(ParkhausLevelService parkhausLevelService) {
        this.parkhausLevelService = parkhausLevelService;
    }

    @Override
    public String execute() {
        double sum = 0.0;
        for (ParkhausLevel level : parkhausLevelService.getLevels()) {
            sum += level.getPrice();
        }
        return String.valueOf(sum);
    }
}
