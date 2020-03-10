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
        int[] checkKeysNoCol = {1, 5};
        int[] checkKeysCol = {2, 3, 7};
        boolean [] answers = new boolean[8];
        answers[1] = true;
        answers[2] = true;
        answers[6] = true;
        answers[7] = true;
        List<Boolean> test = new ArrayList<>();

        ArrayDictionary empty = new ArrayDictionary(0);
        ArrayDictionary noCol = new ArrayDictionary(2);
        noCol.add(0, 7);
        noCol.add(1, 4);
        ArrayDictionary col = new ArrayDictionary(4);
        col.add(2, 80);
        col.add(3, 60);
        col.add(3, 68);
        col.add(5, 22);

        test.add(empty.remove(1));

        //for(int i = 0; i < checkKeysNoCol.length; i++) {
        for (int value : checkKeysNoCol) {
            test.add(noCol.remove(value));
        }

        for(int j = 0; j < checkKeysCol.length; j++) {
            test.add(col.remove(checkKeysCol[j]));
            System.out.println("Testing with collision: " + test.get(j));
        }

        // Checking answers
        for(int i = 0; i < test.size(); i++) {
            assertTrue(String.valueOf(test.get(i)), answers[i]);
        }
    }

    @Test
    public void contains() {
        List<Boolean> tested = new ArrayList<>();
        boolean[] plugIn = new boolean[15];     //{false, false, false, false, true, true, true, false, false, false, true, true, true, false, false};
        plugIn[4] = true;
        plugIn[5] = true;
        plugIn[6] = true;
        plugIn[10] = true;
        plugIn[11] = true;
        plugIn[12] = true;

        // Case 1
        ArrayDictionary emptyDict = new ArrayDictionary(0);
        int[] emptyKeys = {-1, 0, 1};
        for(int i = 0; i < emptyKeys.length; i++){
            tested.add(emptyDict.contains(emptyKeys[i]));
        }

        // Case 2
        ArrayDictionary dict1 = new ArrayDictionary(1);
        int[] keys1 = {2, 0};
        dict1.add(0, 103);
        for(int i = 0; i < keys1.length; i++){
            tested.add(dict1.contains(keys1[i]));
        }

        // Case 3
        ArrayDictionary dict2 = new ArrayDictionary(2);
        int[] keys2 = {0, 1, 2, 3};
        dict2.add(0, 103);
        dict2.add(1, 105);
        for(int i = 0; i < keys2.length; i++){
            tested.add(dict2.contains(keys2[i]));
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
        for(int i = 0; i < keys3.length; i++){
            tested.add(dict3.contains(keys3[i]));
        }

        // Case 5
        ArrayDictionary dict5 = new ArrayDictionary(3);
        dict5.add(0, 103);
        dict5.add(1, 105);
        dict5.add(2, 206);
        dict5.add(4, 407);
        int[] keys5 = {1, 4, 7, 8};
        for(int i = 0; i < keys5.length; i++){
            tested.add(dict5.contains(keys5[i]));
        }

        // Comparing to check answers
        for(int i = 0; i < tested.size(); i++) {
            assertTrue(String.valueOf(tested.get(i).booleanValue()), plugIn[i]);
        }
    }
}