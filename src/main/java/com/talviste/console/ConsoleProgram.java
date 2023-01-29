package com.talviste.console;

public abstract class ConsoleProgram {

    protected abstract Runnable makeMainRunnable(BreakingControl breakingControl);

    public void start() {
        BreakingControl breakingControl = new BreakingControl();
        Runnable mainRunnable = makeMainRunnable(breakingControl);
        Thread iteratingThread = new Thread(mainRunnable);
        breakingControl.setInterruptThread(iteratingThread);
        iteratingThread.start();
        SystemInReadBreaking systemInReadBreaking = new SystemInReadBreaking(breakingControl);
        systemInReadBreaking.listenToStop();
    }

}
