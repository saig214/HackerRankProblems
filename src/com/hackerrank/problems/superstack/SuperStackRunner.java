package com.hackerrank.problems.superstack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by prasanna-4077.
 */
public class SuperStackRunner {
    public static void main(String[] args) {
        List<String> testFilePathList = Arrays.asList(
                "src/com/hackerrank/problems/superstack/test/TestCase1.txt",
                "src/com/hackerrank/problems/superstack/test/TestCase2.txt",
                "src/com/hackerrank/problems/superstack/test/TestCase3.txt",
                "src/com/hackerrank/problems/superstack/test/TestCase4.txt",
                "src/com/hackerrank/problems/superstack/test/TestCase5.txt"
        );

        testFilePathList.stream()
                        .map(SuperStackRunner::getCommands)
                        .forEach(SuperStackRunner::runCommands);
    }

    private static List<String[]> getCommands(String filePath) {
        System.out.println("Running " + filePath);
        List<String[]> commands = new ArrayList<>();
        try {
            commands = Files.lines(Paths.get(filePath))
                            .skip(1)        
                            .map( line -> line.split(" "))
                            .collect(Collectors.toList());
        } catch (IOException expeption) {
            System.out.println("Exception in getting file -> " + filePath);
        }
        return commands;
    }

    private static void runCommands(List<String[]> commands) {
        IntegerSuperStack superStack = new IntegerSuperStackUsingLinkedList();
        commands.forEach( command -> {
//            System.out.println(Arrays.asList(command));
            String operation = command[0];
            switch ( operation ){
                case "push":
                    int el = Integer.parseInt( command[1] );
                    superStack.push(el);
                    break;
                case "pop":
                    superStack.pop();
                    break;
                case "inc":
                    int rows = Integer.parseInt(command[1]);
                    el = Integer.parseInt(command[2]);
                    superStack.inc( el, rows);
                    break;
            }
            int top = superStack.getLast();
            System.out.println( top == -1 ? "EMPTY" : top);
        });
    }

}
