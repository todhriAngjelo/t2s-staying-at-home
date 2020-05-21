package com.t2s.staying.home.T2S.StayingHome.encoding;

public abstract class TemplateEncoding implements EncodingStrategy{

    public TemplateEncoding(){}

    public String encode(String text){
        return null;
    }

    protected abstract char mapCharacter(char ch);


}
