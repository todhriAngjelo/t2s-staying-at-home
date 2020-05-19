package com.t2s.staying.home.T2S.StayingHome.model;

import com.t2s.staying.home.T2S.StayingHome.command.TuneEncoding;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Atbash extends EncodingTemplate {

    protected char template(char ch) {

        if (ch >= 'a' && ch <= 'z') {
            return (char) ('z' - (ch - 'a'));

        }else if (ch >= 'A' && ch <= 'Z') {
        return(char)('Z'-(ch-'A'));

        }

        return 0;
    }
}