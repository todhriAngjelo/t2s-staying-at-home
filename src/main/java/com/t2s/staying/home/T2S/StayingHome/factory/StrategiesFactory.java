package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.encoding.AtbashEncoding;
import com.t2s.staying.home.T2S.StayingHome.encoding.EncodingStrategy;
import com.t2s.staying.home.T2S.StayingHome.encoding.Rot13Encoding;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ATBASH;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ROT13;

public class StrategiesFactory {

    public EncodingStrategy createStrategy(String strategy) {
        if (strategy.equals(ROT13)) {
            return new Rot13Encoding();
        } else if (strategy.equals(ATBASH)) {
            return new AtbashEncoding();
        }
        return null;
    }
}
