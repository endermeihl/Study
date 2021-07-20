package DataStructure.linearList;

import base.OverException;

public class ArrayList {

    Integer[] arr;
    final int size;
    int length;

    public ArrayList(int size) {
        arr = new Integer[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void clearList() {
        for (int i = 0; i < length; i++) {
            arr[i] = null;
        }
    }

    public int getElem(int i) throws RuntimeException {
        if (i > length) {
            throw new OverException();
        }
        return arr[i - 1];
    }
}
