package com.practice.array;

import java.util.*;
import java.util.stream.Collectors;

public class Result {


    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {

        List<List<String>> filteredList = applications.stream().filter(application-> Float.parseFloat(application.get(1)) >=5.8 && Integer.parseInt(application.get(2)) <= 23 ).collect(Collectors.toList());

        List<List<String>> probableStrikersList = filteredList.stream().filter(application-> Integer.parseInt(application.get(3)) >= 50).collect(Collectors.toList());

        Set<String> strikersName = probableStrikersList.stream().map(application-> application.get(0)).collect(Collectors.toSet());

        List<List<String>> probableDefendersList = filteredList.stream().filter(application-> Integer.parseInt(application.get(4)) >= 30).filter(application-> {
            // is better defender then striker
            if(strikersName.contains(application.get(0))) {
                String s = isBestStrikerOrDefender(application);
                if(s.equalsIgnoreCase("defend")) {
                    probableStrikersList.remove(application);
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());

        // to get maximum number of strikers and defenders
        int countDiff = probableStrikersList.size() - probableDefendersList.size();
        while(countDiff > 1 || countDiff < -1) {
            if(countDiff > 1) {
                int index = betterDefenderFromStrikerList(probableStrikersList);
                if(index > -1) {
                    probableDefendersList.add(probableStrikersList.get(index));
                    probableStrikersList.remove(index);
                }
            }

            if(countDiff < -1) {
                int index = betterStrikerFromDefenderList(probableDefendersList);
                if(index > -1) {
                    probableStrikersList.add(probableDefendersList.get(index));
                    probableDefendersList.remove(index);
                }
            }
            countDiff = probableStrikersList.size() - probableDefendersList.size();
        }

        Set<String> strikerNames = probableStrikersList.stream().map(application-> application.get(0)).collect(Collectors.toSet());
        Set<String> defenderNames = probableDefendersList.stream().map(application-> application.get(0)).collect(Collectors.toSet());

        // Generate result
        int maxDefender = Math.min(probableStrikersList.size(), probableDefendersList.size());
        int maxStriker = maxDefender;
        List<List<String>> result = new ArrayList<>();
        for (List<String> application : applications) {

            String name = application.get(0);

            if (strikerNames.contains(name) && maxStriker > 0) {
                List<String> list = new ArrayList<>();
                list.add(application.get(0));
                list.add("SELECT");
                list.add("STRIKER");
                result.add(list);
                maxStriker--;
            } else if (defenderNames.contains(name) && maxDefender > 0) {
                List<String> list = new ArrayList<>();
                list.add(application.get(0));
                list.add("SELECT");
                list.add("DEFENDER");
                result.add(list);
                maxDefender--;
            } else {
                List<String> list = new ArrayList<>();
                list.add(application.get(0));
                list.add("REJECT");
                list.add("NA");
                result.add(list);
            }
        }

        result.sort(Comparator.comparing(s -> s.get(0)));

        return result;
    }

    private static String isBestStrikerOrDefender(List<String> application) {
        int difStrikes = Integer.parseInt(application.get(3)) - 50;
        int difDefends = Integer.parseInt(application.get(4)) - 30;

        return difStrikes > difDefends ? "strike" : "defend";
    }

    private static int betterDefenderFromStrikerList(List<List<String>> applications) {
        int index = -1;
        int maxDefended = -1;

        for(int i = 0; i < applications.size(); i++) {
            int defended = Integer.parseInt(applications.get(i).get(4));
            if(defended >= 30 && defended > maxDefended) {
                maxDefended = defended;
                index = i;
            }
        }
        return index;
    }

    private static int betterStrikerFromDefenderList(List<List<String>> applications) {
        int index = -1;
        int maxStrike = -1;

        for(int i = 0; i < applications.size(); i++) {
            int striker = Integer.parseInt(applications.get(i).get(3));
            if(striker >= 50 && striker > maxStrike) {
                maxStrike = striker;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        /*
        Boateng 6.1 22 24 45
Kaka 6 22 1 1
Ronaldo 5.8 21 120 0
Suarez 5.9 20 100 1
         */
        List<List<String>> applications = new ArrayList<>();
        List<String> application = new ArrayList<>();
        application.add("Boateng");
        application.add("6.1");
        application.add("22");
        application.add("24");
        application.add("45");
        applications.add(application);

        application = new ArrayList<>();
        application.add("Kaka");
        application.add("6");
        application.add("22");
        application.add("1");
        application.add("1");
        applications.add(application);


        application = new ArrayList<>();
        application.add("Ronaldo");
        application.add("5.8");
        application.add("21");
        application.add("120");
        application.add("0");
        applications.add(application);

        application = new ArrayList<>();
        application.add("Suarez");
        application.add("5.9");
        application.add("20");
        application.add("100");
        application.add("1");
        applications.add(application);

        List<List<String>> result = getSelectionStatus(applications);

        for(List<String> l : result) {
            System.out.println(String.join(" ", l));
        }
    }

}
