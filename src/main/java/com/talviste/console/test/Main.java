package com.talviste.console.test;

import com.talviste.console.BreakingControl;
import com.talviste.console.ConsoleProgram;

public class Main {

    public static void main(String[] args) {
        ConsoleProgram testProgram = new ConsoleProgram() {
            @Override
            protected Runnable makeMainRunnable(BreakingControl breakingNews) {
                return () -> {
                    int n = 0;
                    while(!breakingNews.isStopped()) {
                        try {
                            System.out.println("printing iter " + (++n));
                            Thread.sleep(100);
                        } catch (InterruptedException ignored) {
                        }
                    }
                };
            }
        };
        testProgram.start();
    }

}