package org.chase.brainfuck;

import java.util.Arrays;

public class Band {
    private int[] buffer;

    public Band(int initialSize) {
        buffer = new int[initialSize];
    }

    public Band(int... initialElements) {
        buffer = initialElements;
    }

    public void add(int i) {
        buffer = grow(size()+1);
        buffer[size()-1] = i;
    }

    public void set(int index, int i) {
        buffer[index] = i;
    }

    public int get(int index) {
        return buffer[index];
    }

    public int size() {
        return buffer.length;
    }

    private int[] grow(int minSize) {
        return Arrays.copyOf(buffer, minSize);
    }
}
