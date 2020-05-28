package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        int result;
        ArrayList<Integer> resultArr = new ArrayList<>();

        while(isRunning) {
            MainMenu.show();

            int choice = intScanner();

            switch (choice) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    System.out.println("Type child quest output:");
                    int qOutput = intScanner();
                    System.out.println("Type parent quest needed:");
                    int qNeeded = intScanner();
                    System.out.println("Type child quest output for max stock pr. child quest item:");
                    int qRepeatQuest = intScanner();
                    resultArr = QuestCalculator.calcTimesToDoChildQuest(qOutput, qNeeded, qRepeatQuest);
                    System.out.println(printWithFillersChildQuest("You need to do the child quest ", resultArr.get(0),
                            " time(s) with max stock rep, and ", resultArr.get(1),
                            " time(s) with stock rep: ", resultArr.get(2)));
                    break;
                case 2:
                    System.out.println("Type the amount of XP gained from doing the action:");
                    int xpGained = intScanner();
                    System.out.println("Type the amount of XP needed to level up:");
                    int xpLevelUp = intScanner();
                    System.out.println("Is XP boost on or off? [1 = ON, 0 = OFF]");
                    boolean hasXPBoost = intToBoolean(intScanner());
                    result = QuestCalculator.calcActionTimesToLevelUp(xpGained, xpLevelUp, hasXPBoost);
                    System.out.println(printWithFillersLevelUp("You need to do the action ", result,
                            " time(s)", " [XP boost is turned ", hasXPBoost, "]"));
                    break;
            }
        }


    }

    public static int intScanner() {
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        scan.nextLine();
        return result;
    }

    public static boolean intToBoolean(int number) {
        boolean result;
        if(number == 1) {
            result = true;
        } else if(number == 0) {
            result = false;
        } else {
            System.out.println("You didn't enter a correct number.");
            result = false;
        }
        return result;
    }

    public static String printWithFillersChildQuest(String beforeResult1, int resultCount1, String afterResult1, int resultCount2, String afterCount2, int resultStock2) {
        String count1Length = String.valueOf(resultCount1);
        String count2Length = String.valueOf(resultCount2);
        String stock2Length = String.valueOf((resultStock2));

        int allStringsLength = beforeResult1.length() + count1Length.length() + afterResult1.length() +
                count2Length.length() + afterCount2.length() + stock2Length.length();

        String filler = "";

        for(int i = 0; i < allStringsLength; i++) {
            filler += "*";
        }

        String result = filler + "\n" + beforeResult1 + resultCount1 + afterResult1 + resultCount2 +
                afterCount2 + resultStock2 + "\n" + filler;

        return result;
    }


    public static String printWithFillersLevelUp(String beforeResult, int resultTimes, String afterResult, String beforeBoolean, boolean hasXPBoost, String afterBoolean) {
        String resultTimesLength = String.valueOf(resultTimes);
        String xpBoost;

        if(hasXPBoost) {
            xpBoost = "ON";
        } else {
            xpBoost = "OFF";
        }

        int allStringsLength = beforeResult.length() + resultTimesLength.length() + afterResult.length() +
                beforeBoolean.length() + xpBoost.length() + afterBoolean.length();
        String filler = "";


        for(int i = 0; i < allStringsLength; i++) {
            filler += "*";
        }

        String result = filler + "\n" + beforeResult + resultTimes + afterResult + beforeBoolean + xpBoost +
                afterBoolean + "\n" + filler;

        return result;
    }




}
