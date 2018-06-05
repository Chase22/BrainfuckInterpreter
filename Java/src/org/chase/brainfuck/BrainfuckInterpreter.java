package org.chase.brainfuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class BrainfuckInterpreter {
    static CodeIterator iterator;
    static Band band = new Band();

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Not enough Arguments given. Expected 1");
            return;
        }

        File bfFile = new File(args[1]);

        String code = "";

        try {
            code = new Scanner(bfFile).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find File " + args[1]);
        }

        CodeIterator iterator = new CodeIterator(code);
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
        }
    }
}
