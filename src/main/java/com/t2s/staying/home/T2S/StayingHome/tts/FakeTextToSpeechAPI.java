package com.t2s.staying.home.T2S.StayingHome.tts;

import java.util.ArrayList;
import java.util.List;

public class FakeTextToSpeechAPI implements TextToSpeechAPI {

    private String lastText;
    private float lastVolume;
    private int lastPitch;
    private int lastRate;
    private List<String> wholeText = new ArrayList<>();

    public void play(String text){
        wholeText.add(text);
        lastText = text;

    }

    public void setVolume(float volume){
        lastVolume = volume;
    }

    public void setPitch(int pitch){
        lastPitch = pitch;
    }

    public void setRate(int rate){
        lastRate = rate;
    }

    public List<String> getLastText(){
        return wholeText;
    }

    public float getLastVolume() {
        return lastVolume;
    }

    public int getLastPitch() {
        return lastPitch;
    }

    public int getLastRate() {
        return lastRate;
    }
}
