package com.garak.ingestor.conf;

import java.util.List;
import java.util.TimerTask;

public class IotTimerTask extends TimerTask {
    private List<String> oldDatabase;
    private List<String> newDatabase;

    public IotTimerTask(List<String> oldDatabase, List<String> newDatabase) {
        this.oldDatabase = oldDatabase;
        this.newDatabase = newDatabase;
    }

    @Override
    public void run() {
        newDatabase.addAll(oldDatabase);
    }
}
