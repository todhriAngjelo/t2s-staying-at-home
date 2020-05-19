package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Atbash extends TuneEncoding {
    public Atbash(DocumentEditorView textArea) {
        super(textArea);
    }
    private Document document;
    private static DocumentEditorView view;


    public void actionPerformed(ActionEvent e) {
    String allchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String plainText=DocumentManager.getCurrentDocument(document);
    plainText=plainText.replaceAll(" ", "");
    plainText=plainText.toUpperCase();
    int len= plainText.length();
    int len1 = allchar.length();
    String cipher="";

    try {
        for (int i = 0; i < len; i++) {
            char b = plainText.charAt(i);
            for (int j = 0; j < len1; j++) {
                char c = allchar.charAt(j);
                if (c == b) {
                    int index = allchar.indexOf(c);
                    int position = (len1 - 1) - index;
                    cipher += allchar.charAt(position);
                    break;

                }
            }
        }
    }catch (Exception e1){
        e1.printStackTrace();
    }
}
}
