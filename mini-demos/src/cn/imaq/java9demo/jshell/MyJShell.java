package cn.imaq.java9demo.jshell;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MyJShell {
    public static void main(String[] args) {
        JShell shell = JShell.create();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("\n> ");
            try {
                String cmd = reader.readLine();
                List<SnippetEvent> results = shell.eval(cmd);
                for (SnippetEvent e : results) {
                    if (!e.status().isActive() && !e.status().isDefined()) {
                        System.out.println(e.status());
                    } else if (e.exception() != null) {
                        System.out.println("< " + e.exception());
                    } else {
                        System.out.println("< " + e.value());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
