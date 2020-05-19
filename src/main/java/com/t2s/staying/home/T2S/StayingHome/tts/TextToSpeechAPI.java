package com.t2s.staying.home.T2S.StayingHome.tts;

/**
 * Interface for the Text to speech API basic desired functionalities.
 * Any class implementing this class needs to implement the following methods.
 *
 */
public interface TextToSpeechAPI {

    void play(String pl);
    void setVolume(float volume);
    void setPitch(int pitch);
    void setRate(int rate);
}
