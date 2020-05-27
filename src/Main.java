import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        int result = 0;
        ArrayList<Integer> resultArr = new ArrayList<>();

        while(isRunning) {
            System.out.println("Choose calculation for:");
            System.out.println("1. Calculate amount of times to do child quest to complete parent quest.");
            System.out.println("0. Quit.");


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
                    System.out.println(printWithFillers("You need to do the child quest", resultArr.get(0),
                            "time(s) with max stock rep and", resultArr.get(1),
                            "time(s) with stock rep:", resultArr.get(2)));
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






    public static String printWithFillers(String beforeResult1, int resultCount1, String afterResult1, int resultCount2, String afterCount2, int resultStock2) {
        String count1Length = String.valueOf(resultCount1);
        String count2Length = String.valueOf(resultCount2);
        String stock2Length = String.valueOf((resultStock2));
        int finalStringLength = beforeResult1.length() + count1Length.length() + afterResult1.length() +
                count2Length.length() + afterCount2.length() + stock2Length.length();
        String filler = "";

        final int SPACES_IN_RESULT = 5;
        for(int i = 0; i < finalStringLength+SPACES_IN_RESULT; i++) {
            filler += "*";
        }

        String result = filler + "\n" + beforeResult1 + " " + resultCount1 + " " + afterResult1 + " " + resultCount2 +
                " " + afterCount2 + " " + resultStock2 + "\n" + filler;

        return result;
    }







}
