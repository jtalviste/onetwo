package com.talviste.console;

import java.io.IOException;

public class SystemInReadBreaking {

    private final BreakingControl stoppingIntermediary;

    public SystemInReadBreaking(BreakingControl stoppingIntermediary) {
        this.stoppingIntermediary = stoppingIntermediary;
    }

    public BreakingControl listenToStop(){
        new Thread(()->{
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stoppingIntermediary.stop();
        }).start();
        return stoppingIntermediary;
    }

}
