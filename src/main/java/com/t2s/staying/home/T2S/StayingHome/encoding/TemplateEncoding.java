package com.t2s.staying.home.T2S.StayingHome.encoding;

public abstract class TemplateEncoding implements EncodingStrategy{

    @Override
    public String encode(String text) {

        String str = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = mapCharacter(ch);
            str = str + ch;
        }
        return str;
    }
    protected abstract char mapCharacter(char ch);
}
