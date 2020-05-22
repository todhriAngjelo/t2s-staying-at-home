package com.t2s.staying.home.T2S.StayingHome.manager;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReplayManager {
    private ArrayList<ActionListener> commandsize = new ArrayList<ActionListener>();


    public void replay() {
        int s =commandsize.size();
        for(int i=0; i<s; i++){
            commandsize.get(i).actionPerformed(null);
        }

    }

    public void add(ActionListener cm) {
        commandsize.add(cm);
    }

}
