package com.t2s.staying.home.T2S.StayingHome.model;

abstract class EncodingTemplate implements EncodingStrategy {

    @Override
    public String encode(String textA) {
        String str = "";
        for (int i = 0; i < textA.length(); i++) {
            char ch = textA.charAt(i);
            if ((ch >= 'a' && ch <= 'z') && (ch >= 'A' && ch <= 'Z')) {
                ch = template(ch);
            }
            str = str + ch;
        }
        return str;
    }

    protected abstract char template(char ch);

}