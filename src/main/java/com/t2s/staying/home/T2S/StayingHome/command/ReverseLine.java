package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class ReverseLine implements ActionListener {

    DocumentEditorView reverseLineView;

    public ReverseLine(DocumentEditorView reverseLineView) { this.reverseLineView = reverseLineView;}

    @Override
    public void actionPerformed(ActionEvent e) {
        int lineNumber = reverseLineView.getLineNumber();
        String doc = reverseLineView.getTextArea();

        List<String> lines = Arrays.asList(doc.split("\n"));
        //List<lines> words = Arrays.asList(lines.split(" "));
        //Collections.reverse(lines);

        FreeTTSAdapter freeTTS = new FreeTTSAdapter();
        try {
            for (int n = 0; n < reverseLineView.getJTextArea().getLineCount(); n += 1)
            {
                if (lineNumber == n) {
                    freeTTS.play(lines.get(n));
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
