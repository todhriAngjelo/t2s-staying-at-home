package com.t2s.staying.home.T2S.StayingHome.model;


public class Rot extends EncodingTemplate {



    protected char template(char ch) {

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
