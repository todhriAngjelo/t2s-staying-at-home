package com.t2s.staying.home.T2S.StayingHome.manager;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReplayManager {
    private List<ActionListener> commands = new ArrayList<>();

    public void replay() {
        int s = commands.size();
        for(int i=0; i<s; i++){
            commands.get(i).actionPerformed(null);
        }
    }

    public void add(ActionListener cm) {
        commands.add(cm);
    }
}