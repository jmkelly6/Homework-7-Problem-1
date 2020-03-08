import org.junit.Test;

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
        boolean test = true;

        ArrayDictionary empty = new ArrayDictionary();
        ArrayDictionary noCol = new ArrayDictionary(2);
        noCol.add(1, 7);
        noCol.add(2, 4);
        ArrayDictionary col = new ArrayDictionary(3);
        col.add(2, 80);
        col.add(3, 60);
        col.add(3, 68);

        test = empty.remove(0);

        for(int i = 0; i < checkKeysNoCol.length; i++) {
            test = (test || noCol.remove(checkKeysNoCol[i]));
        }

        for(int j = 0; j < checkKeysCol.length; j++) {
            test = (test || col.remove(checkKeysCol[j]));
        }
        assertTrue(test);
    }

    @Test
    public void get() {

        assertTrue(false);  // place holder
    }

    @Test
    public void contains() {
        ArrayDictionary dict = new ArrayDictionary();
        int[] keys = {-1, 0, 1};
        boolean test = true;
        for(int i = 0; i < keys.length; i++){
            if(!dict.contains(keys[i])) {
                test = false;
                break;
            }
        }
        assertTrue(test);
    }
}