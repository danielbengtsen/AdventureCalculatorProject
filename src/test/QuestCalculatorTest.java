package test;

import main.QuestCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class QuestCalculatorTest {

    @Test
    public void calcTimesToDoChildQuestTest() {
        int qOutput = 3;
        int qNeeded = 100;
        int qRepeatQuest = 6;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(1);
        expected.add(4);

        ArrayList<Integer> result = QuestCalculator.calcTimesToDoChildQuest(qOutput, qNeeded, qRepeatQuest);

        assertEquals(expected.get(0), result.get(0));
        assertEquals(expected.get(1), result.get(1));
        assertEquals(expected.get(2), result.get(2));
    }

    // Testing that max rep is before the mixed, if mixed is not needed
    @Test
    public void calcTimesToDoChildQuestTestForMaxRep() {
        int qOutput = 1;
        int qNeeded = 1;
        int qRepeatQuest = 1;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);
        expected.add(0);

        ArrayList<Integer> result = QuestCalculator.calcTimesToDoChildQuest(qOutput, qNeeded, qRepeatQuest);

        assertEquals(expected.get(0), result.get(0));
        assertEquals(expected.get(1), result.get(1));
        assertEquals(expected.get(2), result.get(2));
    }


    @Test
    public void calcActionTimesToLevelUpTest() {
        int xpGained = 587;
        int xpLevelUp = 97234;
        boolean hasXPBoost = false;

        // test without xp boost
        int expected = 166;
        int result = QuestCalculator.calcActionTimesToLevelUp(xpGained, xpLevelUp, hasXPBoost);

        assertEquals(expected, result);

        // test with xp boost
        hasXPBoost = true;
        expected = 83;
        result = QuestCalculator.calcActionTimesToLevelUp(xpGained, xpLevelUp, hasXPBoost);

        assertEquals(expected, result);

    }



}