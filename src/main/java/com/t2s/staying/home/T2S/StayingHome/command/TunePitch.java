package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class TunePitch implements ChangeListener {
    DocumentEditorView view;
    private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
    TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
    public TunePitch(DocumentEditorView view) {this.view = view; }

    @Override
    public void stateChanged(ChangeEvent e) {
        t2s.setPitch(view.getVoicePitchSlider().getValue());
        System.out.println("getVoicePitchSlider.getValue()  " + view.getVoicePitchSlider().getValue());
    }

}
