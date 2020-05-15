package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseAll implements ActionListener {

    DocumentEditorView reverseAllView;
    public ReverseAll(DocumentEditorView reverseAllView){this.reverseAllView = reverseAllView;}

    @Override
    public void actionPerformed(ActionEvent e) {
        String doc = reverseAllView.getTextArea();

        List<String> lines = Arrays.asList(doc.split(" "));
        Collections.reverse(lines);

        FreeTTSAdapter freeTTS = new FreeTTSAdapter();
        try {
            for (int n = 0; n < lines.size(); n += 1)
            {
                freeTTS.play(lines.get(n));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}
