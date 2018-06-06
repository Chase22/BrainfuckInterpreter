package org.chase.brainfuck;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Band implements ListIterator<Integer> {

    private List<Integer> band = new ArrayList<>(100);
    private int currentIndex = 0;

    public Band() {
        band.add(0);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if (++currentIndex == band.size()) {
            band.add(0);
        }
        return band.get(currentIndex);
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex >= 1;
    }

    @Override
    public Integer previous() {
        return band.get(--currentIndex);
    }

    @Override
    public int nextIndex() {
        return Math.min(currentIndex + 1, band.size());
    }

    @Override
    public int previousIndex() {
        return Math.max(currentIndex - 1, 0);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Integer integer) {
        if (integer < 0) throw new NegativeNumberException();
        band.set(currentIndex, integer);
    }

    @Override
    public void add(Integer integer) {
        throw new UnsupportedOperationException();
    }

    public void set(int i) {
        if (i < 0) throw new NegativeNumberException();
        band.set(currentIndex, i);
    }

    public void increment() {
        set(current()+1);
    }

    public void decrement() {
        set(current()-1);
    }

    public int current() {
        return band.get(currentIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band1 = (Band) o;
        return currentIndex == band1.currentIndex &&
                Objects.equals(band, band1.band);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, currentIndex);
    }

    @Override
    public String toString() {
        return "Band{\n" +
                "band=" + band +
                "\ncurrentIndex=" + currentIndex +
                "}";
    }
}
