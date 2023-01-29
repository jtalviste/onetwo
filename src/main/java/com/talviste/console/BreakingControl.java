package com.talviste.console;

public class BreakingControl {

    private boolean hasOccured = false;
    private Thread interruptThread;

    public boolean isStopped() {
        return hasOccured;
    }

    public void stop() {
        this.hasOccured = true;
        interruptThread.interrupt();
    }

    public void setInterruptThread(Thread interruptThread) {
        this.interruptThread = interruptThread;
    }
}