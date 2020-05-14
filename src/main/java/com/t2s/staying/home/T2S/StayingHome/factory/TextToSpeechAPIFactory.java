package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FakeTextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.theinterfaces.TextToSpeechAPI;

public class TextToSpeechAPIFactory {

    public TextToSpeechAPIFactory(){
    }
    public TextToSpeechAPI createTTSAPI(String t2skind) {
        if (t2skind.equals("freeTTSAdapter")) {
            return new FreeTTSAdapter();
        } else if (t2skind.equals("FakeT2s")) {
            return new FakeTextToSpeechAPI();
        }
        return null;
    }
}
