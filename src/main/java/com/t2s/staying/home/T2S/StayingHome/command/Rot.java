package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.StayingHome.model.Document;

import java.awt.event.ActionEvent;

public class Rot extends TuneEncoding {

    private Document document;
    private static DocumentEditorView view;

   public Rot(DocumentEditorView view) {
       super();

       this.view = view;
   }
    public void actionPerformed(ActionEvent e) {
        StringBuilder builder = new StringBuilder();
        String s = DocumentManager.getCurrentDocument(document);

        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'm') c += 13;
                else if (c >= 'A' && c <= 'M') c += 13;
                else if (c >= 'n' && c <= 'z') c -= 13;
                else if (c >= 'N' && c <= 'Z') c -= 13;
                builder.append(c);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }


}
