package com.t2s.staying.home.T2S.StayingHome.model;

public class StrategySelecter {
     public EncodingStrategy pickAStrategy(String cipher){
         if(cipher.equals("Rot"))
             return new Rot();
         else if(cipher.equals("Atbash"))
             return new Atbash();
         return null;
    }
}
