package org.chase.brainfuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.util.Scanner;

public class BrainfuckInterpreter {
    private CodeIterator iterator;
    private Band band = new Band();

    public BrainfuckInterpreter(String code) {
        iterator = new CodeIterator(code);
    }

    public BrainfuckInterpreter(File brainfuckFile) throws FileNotFoundException {
        this(new Scanner(brainfuckFile).useDelimiter("\\A").next());
    }

    public void interpretCode() {
        char c = iterator.current();
        do {
            interpretChar(c);
        } while ((c = iterator.next()) !=CharacterIterator.DONE);
    }

    public void interpretChar(char c) {
        switch (c) {
            case '+':
                band.increment();
            break;
            case '-':
                band.decrement();
                break;
            case '>':
                band.next();
                break;
            case '<':
                band.previous();
                break;
            case '[':
                if (band.current() == 0) {
                    iterator.findNext(']');
                }
                break;
            case ']':
                if (band.current() != 0) {
                    iterator.findPrevious('[');
                }
                break;
            case ',':
                break;
            case'.':
                 System.out.print((char) band.current());
                break;
        }
    }

    public Band getBand() {
        return band;
    }
}
