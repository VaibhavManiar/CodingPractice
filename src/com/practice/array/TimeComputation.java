package com.practice.array;

public class TimeComputation {
    public static String[] solve(String[] p, String time){
        // Write your code here
        long timeInSeconds = timeInSeconds(time);
        String[] result = new String[p.length];
        int index = 0;
        for(String t : p) {
            long pTimeInSeconds = timeInSeconds(t);
            long diff = timeInSeconds - pTimeInSeconds;
            if(pTimeInSeconds == timeInSeconds) {
                result[index] = "now";
            } else if(diff / (60 * 60 ) < 24 && diff / (60 * 60) > 0) {
                long hour = diff / 3600;
                if(hour == 1) {
                    result[index] = (hour + " hour ago");
                } else {
                    result[index] = (hour + " hours ago");
                }
            } else if(diff / (60) > 0 && diff / (60) < 60) {
                long minute = diff / 60;
                if(minute == 1) {
                    result[index] = (minute + " minute ago");
                } else {
                    result[index] = (minute + " minutes ago");
                }
            } else {
                long second = diff;
                if(second == 1) {
                    result[index] = (second + " second ago");
                } else {
                    result[index] = (second + " seconds ago");
                }
            }
            index++;
        }
        return result;
    }

    private static long timeInSeconds(String time) {
        String[] timeArr = time.split(":");
        long hour = Long.parseLong(timeArr[0]);
        long minute = Long.parseLong(timeArr[1]);
        long secound = Long.parseLong(timeArr[2]);

        return (hour * 3600) + (minute * 60) + (secound);
    }

    public static void main(String[] args) {
        /*
        23:05:38
7
23:05:38
23:05:02
23:04:59
23:04:31
12:36:07
08:59:01
00:00:00

         */

        solve(new String[] {"23:05:38", "23:05:02", "23:04:59", "23:04:31", "12:36:07", "08:59:01", "00:00:00"}, "23:05:38");
    }
}
