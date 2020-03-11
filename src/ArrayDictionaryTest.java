import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        int[] checkKeysNoCol = {1, 4};
        int[] checkKeysCol = {2, 3, 4};

        boolean[] answersNoCol = new boolean[2];
        answersNoCol[0] = true;

        boolean[] answersCol = new boolean[3];
        answersCol[0] = true;
        answersCol[1] = true;

        ArrayDictionary empty = new ArrayDictionary(0);
        ArrayDictionary noCol = new ArrayDictionary(2);
        noCol.add(0, 7);
        noCol.add(1, 4);
        ArrayDictionary col = new ArrayDictionary(4);
        col.add(2, 80);
        col.add(3, 60);
        col.add(3, 68);
        col.add(5, 22);

        assertTrue(String.valueOf(empty.remove(1)), false);

        for(int i = 0; i < checkKeysNoCol.length; i++) {
            assertTrue(String.valueOf(col.remove(checkKeysNoCol[i])), answersNoCol[i]);
        }

        for(int j = 0; j < checkKeysCol.length; j++) {
            assertTrue(String.valueOf(col.remove(checkKeysCol[j])), answersCol[j]);
        }
    }

    @Test
    public void contains() {
        // Case 1
        ArrayDictionary emptyDict = new ArrayDictionary(0);
        int[] emptyKeys = {-1, 0, 1};
        boolean[] emptyAnswers = new boolean [3];
        for(int i = 0; i < emptyKeys.length; i++){
            assertTrue(String.valueOf(emptyDict.contains(emptyKeys[i])), emptyAnswers[i]);
        }

        // Case 2
        ArrayDictionary dict1 = new ArrayDictionary(1);
        dict1.add(0, 103);
        int[] keys1 = {2, 0};
        boolean[] case1Answers = new boolean[2];
        case1Answers[1] = true;
        for(int i = 0; i < keys1.length; i++){
            assertTrue(String.valueOf(dict1.contains(keys1[i])), case1Answers[i]);
        }

        // Case 3
        ArrayDictionary dict2 = new ArrayDictionary(2);
        dict2.add(0, 103);
        dict2.add(1, 105);
        int[] keys2 = {0, 1, 2, 3};
        boolean[] case2Answers = new boolean[4];
        case2Answers[0] = true;
        case2Answers[1] = true;
        for(int i = 0; i < keys2.length; i++){
            assertTrue(String.valueOf(dict2.contains(keys2[i])), case2Answers[i]);
        }

        // Case 4
        ArrayDictionary dict3 = new ArrayDictionary(3);
        dict3.add(0, 103);
        dict3.add(1, 105);
        ArrayDictionary dict4 = new ArrayDictionary(3);
        dict4.add(0, 103);
        dict4.add(1, 105);
        dict4.add(2, 206);
        int[] keys3 = {3, 1};
        assertTrue(String.valueOf(dict3.contains(3)), false);
        assertTrue(String.valueOf(dict4.contains(1)), true);

        // Case 5
        ArrayDictionary dict5 = new ArrayDictionary(3);
        dict5.add(0, 103);
        dict5.add(1, 105);
        dict5.add(2, 206);
        dict5.add(4, 407);
        int[] keys5 = {1, 4, 7, 8};
        boolean[] case5Answers = new boolean[4];
        case5Answers[0] = true;
        case5Answers[1] = true;
        for(int i = 0; i < keys5.length; i++){
            assertTrue(String.valueOf(dict5.contains(keys5[i])), case5Answers[i]);
        }
    }
}