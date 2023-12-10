package de.hbrs.team22.parkhaus_projekt.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;

import java.util.List;

public class ChartDataCommand implements ServletCommandI {
    ParkhausLevelService parkhausLevelService;

    public ChartDataCommand(ParkhausLevelService parkhausLevelService) {
        this.parkhausLevelService = parkhausLevelService;
    }

    @Override
    public String execute() {
        List<ParkhausLevel> levels = parkhausLevelService.getLevels();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (ParkhausLevel level : levels) {
            JsonArray tmp = new JsonArray();
            tmp.add(level.getFreePlaces());
            tmp.add(level.getOccupiedPlaces());
            jsonArray.add(tmp);
        }
        jsonObject.add("chartData", jsonArray);

        return gson.toJson(jsonObject);
    }
}
