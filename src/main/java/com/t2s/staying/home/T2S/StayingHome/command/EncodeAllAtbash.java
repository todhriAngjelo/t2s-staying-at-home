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

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ATBASH;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class EncodeAllAtbash implements ActionListener {

    private DocumentManager documentManager = new DocumentManager();
    private DocumentEditorView view;
    private StrategiesFactory strategy = new StrategiesFactory();
    EncodingStrategy atbash = strategy.createStrategy(ATBASH);

    public EncodeAllAtbash(DocumentEditorView view) {this.view = view;}

    private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
    TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Line> currentLines = documentManager.getCurrentDocument().getLines();
        String displayText = " ";
        try {
            for (Line currentLine : currentLines) {
                for (String word : currentLine.getWords()) {
                   System.out.println(atbash.encode(word));
                   t2s.play(atbash.encode(word));
                    displayText = displayText.concat(atbash.encode(word) + " ");
                }

            }
            view.showMessageDialog("The encoded text is: " + displayText);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        view.getReplayManager().add(this);
    }
}
