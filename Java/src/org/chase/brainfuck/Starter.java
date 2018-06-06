package org.chase.brainfuck;

import java.io.File;
import java.io.FileNotFoundException;

public class Starter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Not enough Arguments given. Expected 1");
            return;
        }

        File bfFile = new File(args[0]);

        BrainfuckInterpreter interpreter;
        try {
            interpreter = new BrainfuckInterpreter(bfFile);

            try {
                interpreter.interpretCode();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
                System.out.println(interpreter);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find File " + args[0]);
        }
    }
}
