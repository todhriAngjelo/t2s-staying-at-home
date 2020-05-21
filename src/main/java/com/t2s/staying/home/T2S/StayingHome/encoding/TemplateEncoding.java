package com.t2s.staying.home.T2S.StayingHome.encoding;

public abstract class TemplateEncoding implements EncodingStrategy{

    public TemplateEncoding(){}

    public String encode(String text){
        String str = "";
        for(int i = 0; i < text.length(); i++){

            char ch = text.charAt(i);

            if ((ch >= 'a' && ch <= 'z') && (ch >= 'A' && ch <= 'Z')) {
                ch = mapCharacter(ch);
            }
            str = str + ch;
        }
        return str;
    }

    protected abstract char mapCharacter(char ch);


}
