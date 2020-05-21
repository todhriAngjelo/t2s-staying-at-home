package com.t2s.staying.home.T2S.StayingHome.encoding;



public abstract class TemplateEncoding implements EncodingStrategy{

    public TemplateEncoding(){}

    public String encode(String text){
        String str = "";
        for(int i = 0; i < text.length(); i++){

            char ch = text.charAt(i);

            if (checkIfLetter(ch)) {
                ch = mapCharacter(ch);
            }
            str = str + ch;
        }
        return str;
    }


    private boolean checkIfLetter(char ch){
        if (ch >= 'a' && ch <= 'z')
            return true;


            else if(ch >= 'A' && ch <= 'Z')
                return false;


        return false;
    }
    protected abstract char mapCharacter(char ch);


}
