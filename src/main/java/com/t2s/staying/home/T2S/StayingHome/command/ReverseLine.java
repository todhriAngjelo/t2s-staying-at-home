package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class ReverseLine implements ActionListener {

    DocumentEditorView view;
    private DocumentManager documentManager = new DocumentManager();
    private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
    TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
    public ReverseLine(DocumentEditorView view) { this.view = view;}

    @Override
    public void actionPerformed(ActionEvent e) {
        int lineNumber = view.getLineNumber();
        List<Line> currentLines = documentManager.getCurrentDocument().getLines();
        try {

            for (int n = 0; n < currentLines.size(); n += 1){
                if (lineNumber == n) {
                    Collections.reverse(currentLines.get(n).getWords());
                    for (String word : currentLines.get(n).getWords()) {
                        {
                            t2s.play(word);
                        }
                        Collections.reverse(currentLines.get(n).getWords());
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
