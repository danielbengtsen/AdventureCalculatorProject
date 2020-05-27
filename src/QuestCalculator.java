import java.util.ArrayList;

public class QuestCalculator {

    // qOutput = The amount of the item you get from completing the child quest.
    // qNeeded = The amount of the item needed to complete the parent quest.
    // qItemsForQuest = The amount of times you can complete the child quest by collection the max stock pr. child quest item.
    public static ArrayList<Integer> calcTimesToDoChildQuest(int qOutput, int qNeeded, int qRepeatQuest) {
        ArrayList<Integer> result = new ArrayList<>();

        double maxRepOutput = qOutput * qRepeatQuest;
        double maxRepOutputCount = maxRepOutput;

        double maxRepTimesForNeeded = qNeeded / maxRepOutput;
        int maxRepTimesForNeededCeil = (int) Math.ceil(qNeeded / maxRepOutput);
        int count = 0;

        if(maxRepTimesForNeeded % 1 != 0) {
            for(int i = 0; i < maxRepTimesForNeededCeil-1; i++) {
                if(maxRepOutput < qNeeded) {
                    count++;
                    maxRepOutputCount += maxRepOutput;
                }
            }
        }

        double percentDecimal = maxRepTimesForNeeded % 1;
        int qRepeatQuestLast = (int) Math.round(qRepeatQuest * percentDecimal);

        int leftForNeeded = (count*(int)maxRepOutput) + (qOutput*qRepeatQuestLast);
        if(leftForNeeded < qNeeded) {
            int addOn = qNeeded - leftForNeeded;
            qRepeatQuestLast += addOn;
        }

        result.add(count);
        result.add(qRepeatQuestLast);

        return result;
    }

}
