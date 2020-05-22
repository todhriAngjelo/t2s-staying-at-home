package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.encoding.EncodingStrategy;
import com.t2s.staying.home.T2S.StayingHome.factory.StrategiesFactory;
import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ROT13;

public class EncodeAllRiot13 implements ActionListener {

    private DocumentManager documentManager = new DocumentManager();
    private DocumentEditorView view;
    private StrategiesFactory strategy = new StrategiesFactory();
    EncodingStrategy rot13 = strategy.createStrategy(ROT13);
    public EncodeAllRiot13(DocumentEditorView view) { this.view=view;}

    private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
    TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
    @Override
    public void actionPerformed(ActionEvent e) {
        List<Line> currentLines = documentManager.getCurrentDocument().getLines();
        try {
            for (Line currentLine : currentLines) {
                for (String word : currentLine.getWords()) {
                    System.out.println(rot13.encode(word));
                    t2s.play(rot13.encode(word));
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        view.getReplayManager().add(this);

    }
}
