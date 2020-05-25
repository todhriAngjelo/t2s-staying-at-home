package com.t2s.staying.home.T2S.StayingHome.encoding;

public class AtbashEncoding extends TemplateEncoding{


    @Override
    protected char mapCharacter(char ch) {

        if (ch >= 'a' && ch <= 'z') {
            return (char) ('z' - (ch - 'a'));

        }else if (ch >= 'A' && ch <= 'Z') {
            return(char)('Z'-(ch-'A'));

        }

        return 0;
    }

}
