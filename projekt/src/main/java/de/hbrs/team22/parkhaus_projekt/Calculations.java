package de.hbrs.team22.parkhaus_projekt;

import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Calculations {


    /**
     * Calculate AVG of ArrayList<Double>
     * @param avgPrices
     * @return
     */
    public static double getDoubleAVG(ArrayList<Double> avgPrices) {
        return avgPrices == null ? 0 : avgPrices.stream().mapToDouble(prices -> prices).average().getAsDouble();
    }

    /**
     * Calculate SUM of ArrayList<Double>
     * @param sumPrices
     * @return
     */
    public static double getDoubleSUM(ArrayList<Double> sumPrices) {
        return sumPrices != null ? sumPrices.stream().reduce(0d, Double::sum) : 0;
    }

    /**
     * Convert double into String (Euro Format)
     * @param value
     * @return
     */
    public static String getValueInEuro(double value) {
        return Math.round(value * 100d) / 100d +"&#8364;";
    }

    /**
     * Calculate AVG of ArrayList<Long>
     * @param avgDurations
     * @return
     */
    public static double getLongAVG(ArrayList<Long> avgDurations) {
        return avgDurations == null ? 0 : avgDurations.stream().mapToLong(duration -> duration).average().getAsDouble();
    }

    /**
     * Calculate SUM of ArrayList<Long>
     * @param sumDurations
     * @return
     */
    public static long getLongSUM(ArrayList<Long> sumDurations) {
        return sumDurations != null ? sumDurations.stream().reduce(0l, Long::sum) : 0;

    }

    public static TreeMap <String, Double> getMonthlySum(ArrayList<Long> dates, ArrayList<Double> revenues) {
        ArrayList<String> onlyMonths = (ArrayList<String>) dates.stream().map(date -> DateTimeFormatter.ofPattern(Bankaccount.MONTHFORMAT).format(YearMonth.from(Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate()))).collect(Collectors.toList());
        TreeMap<String, Double> monthlyTurnovers = new TreeMap<String, Double>();
        for(int i = 0; i < revenues.size(); i++) {

            double turnover = 0;
            if(monthlyTurnovers.containsKey(onlyMonths.get(i))) {
                turnover = monthlyTurnovers.get(onlyMonths.get(i));

            }
            turnover += revenues.get(i);
            monthlyTurnovers.put(onlyMonths.get(i), turnover);
        }
        return monthlyTurnovers;
    }



}
