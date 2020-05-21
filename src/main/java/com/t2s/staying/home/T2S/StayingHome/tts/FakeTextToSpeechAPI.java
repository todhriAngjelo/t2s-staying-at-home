package com.t2s.staying.home.T2S.StayingHome.tts;

/**
 * todo documentation
 */
public class FakeTextToSpeechAPI implements TextToSpeechAPI {

    private String textA;

    public void play(String textA) {
        this.textA = textA;
    }

    public void setVolume(float volume){}

    public void setPitch(int pitch){}

    public void setRate(int rate){}



}
