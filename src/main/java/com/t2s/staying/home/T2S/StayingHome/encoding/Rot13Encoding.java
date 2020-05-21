package com.t2s.staying.home.T2S.StayingHome.encoding;

public class Rot13Encoding extends TemplateEncoding{
    @Override

    protected char mapCharacter(char ch) {

        if (ch >= 'a' && ch <= 'z') {

            if (ch > 'm') {
                return  (char)(ch - 13);
            } else {
                return  (char)(ch + 13);
            }
        } else if (ch >= 'A' && ch <= 'Z') {

            if (ch > 'M') {
                return  (char)  (ch -13);
            } else {
                return (char)(ch + 13);
            }

        }
        return 0;
    }

}
