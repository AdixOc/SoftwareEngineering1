package de.hbrs.team22.parkhaus_projekt.commands;

import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;
import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;

public class CarsCommand implements ServletCommandI {
    ParkhausLevelService parkhausLevelService;

    public CarsCommand(ParkhausLevelService parkhausLevelService) {
        this.parkhausLevelService = parkhausLevelService;
    }

    @Override
    public String execute(){
        StringBuilder sb = new StringBuilder();
        for (ParkhausLevel level : parkhausLevelService.getLevels()) {
            sb.append(level.getName()).append(": ").append(level.getCars().size()).append("\n");
            for (Car car : level.getCars()) {
                sb.append(car.toString()).append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
