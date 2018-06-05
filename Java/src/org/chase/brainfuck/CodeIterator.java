package org.chase.brainfuck;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class CodeIterator implements CharacterIterator {
    private StringCharacterIterator internalIterator;

    /**
     * Constructs an iterator with an initial index of 0.
     *
     * @param text the {@code String} to be iterated over
     */
    public CodeIterator(String text)
    {
        this(text, 0);
    }

    /**
     * Constructs an iterator with the specified initial index.
     *
     * @param  text   The String to be iterated over
     * @param  pos    Initial iterator position
     */
    public CodeIterator(String text, int pos)
    {
        this(text, 0, text.length(), pos);
    }

    /**
     * Constructs an iterator over the given range of the given string, with the
     * index set at the specified position.
     *
     * @param  text   The String to be iterated over
     * @param  begin  Index of the first character
     * @param  end    Index of the character following the last character
     * @param  pos    Initial iterator position
     */
    public CodeIterator(String text, int begin, int end, int pos) {
        internalIterator = new StringCharacterIterator(text, begin, end, pos);
    }

    /**
     * Advances the Iterator until the character is found and returns the index of the character. Returns -1 if the character was not found
     * @param find
     * @return
     */
    public int findNext(char find) {
        if (this.current() == find) return this.getIndex();
        while (this.next() != find) {
            if (this.current() == StringCharacterIterator.DONE) return -1;
        }
        return getIndex();
    }

    /**
     * Advances the Iterator backwards until the character is found and returns the index of the character. Returns -1 if the character was not found
     * @param find
     * @return
     */
    public int findPrevious(char find) {
        if (this.current() == find) return this.getIndex();
        while (this.previous() != find) {
            if (this.current() == StringCharacterIterator.DONE) return -1;
        }
        return getIndex();
    }

    @Override
    public char first() {
        return internalIterator.first();
    }

    @Override
    public char last() {
        return internalIterator.last();
    }

    @Override
    public char current() {
        return internalIterator.current();
    }

    @Override
    public char next() {
        return internalIterator.next();
    }

    @Override
    public char previous() {
        return internalIterator.previous();
    }

    @Override
    public char setIndex(int position) {
        return internalIterator.setIndex(position);
    }

    @Override
    public int getBeginIndex() {
        return internalIterator.getBeginIndex();
    }

    @Override
    public int getEndIndex() {
        return internalIterator.getEndIndex();
    }

    @Override
    public int getIndex() {
        return internalIterator.getIndex();
    }

    @Override
    public Object clone() {
        try {
            CodeIterator other
                    = (CodeIterator) super.clone();
            return other;
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
