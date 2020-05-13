package com.t2s.staying.home.T2S.StayingHome.t2sClasses;
import java.io.*;
import com.t2s.staying.home.T2S.StayingHome.ApplicationConstants;
import  com.sun.speech.freetts.*;

public class FreeTTSAdapter {
    Voice voice;
    VoiceManager vm = VoiceManager.getInstance();
    public static final String VOICE_KEVIN16 = "kevin16";
    public static final String VOICE_KEVIN = "kevin";
    public static final String VOICE_ALAN = "alan";

    public FreeTTSAdapter(){

        this.voice = vm.getVoice(VOICE_KEVIN16);
        voice.allocate();
    }

    public void play(String text){
        this.voice.speak(text);

    }
    public void setVolume(int volume){

    }
    public void setPitch(int pitch){

    }
    public void setRate(int rate){

    }
}
