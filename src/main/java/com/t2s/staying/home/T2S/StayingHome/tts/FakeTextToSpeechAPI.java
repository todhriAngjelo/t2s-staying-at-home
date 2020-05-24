package com.t2s.staying.home.T2S.StayingHome.tts;

/**
 * todo documentation
 */
public class FakeTextToSpeechAPI implements TextToSpeechAPI {

    private String lastText;

    private float lastVolume;
    private int lastPitch;
    private int lastRate;

    public void play(String text){
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

    public String getLastText(){


        return lastText;
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
