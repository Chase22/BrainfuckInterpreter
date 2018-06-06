package org.chase.brainfuck;

import java.io.*;
import java.text.CharacterIterator;
import java.util.Scanner;

public class BrainfuckInterpreter {
    private CodeIterator iterator;
    private BandIterator bandIterator = new BandIterator();

    public BrainfuckInterpreter(String code) {
        iterator = new CodeIterator(code);
    }

    public BrainfuckInterpreter(File brainfuckFile) throws FileNotFoundException {
        this(new Scanner(brainfuckFile).useDelimiter("\\A").next());
    }

    public void interpretCode() throws IOException {
        char c = iterator.current();
        do {
            interpretChar(c);
        } while ((c = iterator.next()) !=CharacterIterator.DONE);
    }

    public void interpretChar(char c) throws IOException {
        switch (c) {
            case '+':
                bandIterator.increment();
            break;
            case '-':
                bandIterator.decrement();
                break;
            case '>':
                bandIterator.next();
                break;
            case '<':
                bandIterator.previous();
                break;
            case '[':
                if (bandIterator.current() == 0) {
                    int index = iterator.findNext(']');
                    if (index == -1) throw new BrainfuckException("No closing bracket found");
                }
                break;
            case ']':
                if (bandIterator.current() != 0) {
                    int index =iterator.findPrevious('[');
                    if (index == -1) throw new BrainfuckException("No opening bracket found");
                }
                break;
            case ',':
                bandIterator.set(new BufferedReader(new InputStreamReader(System.in)).read());
                break;
            case'.':
                 System.out.print((char) bandIterator.current());
                 System.out.flush();
                break;
        }
    }

    public BandIterator getBandIterator() {
        return bandIterator;
    }
    public CodeIterator getIterator() {
        return iterator;
    }

    @Override
    public String toString() {
        return "BrainfuckInterpreter={\n" + bandIterator + "\nCode=" + iterator +"\n}";
    }
}
