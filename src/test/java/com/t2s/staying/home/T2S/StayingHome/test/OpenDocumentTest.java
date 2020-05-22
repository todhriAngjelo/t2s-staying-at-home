package com.t2s.staying.home.T2S.StayingHome.test;

import com.t2s.staying.home.T2S.StayingHome.command.OpenDocument;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OpenDocumentTest {



    @Test
    void openTest() {

        DocumentEditorView view = new DocumentEditorView();

        OpenDocument loadButton = new OpenDocument(view);
        loadButton.actionPerformed(null);
        String text = "";
        Document document = DocumentManager.getCurrentDocument();


       List<Line> lines= document.getLines();
        for (Line line : lines) {
            List<String>  words = line.getWords();
            for (String word : words) {
                text.concat(word).concat(" ");
            }
        }




        //assertEquals(text, );

    }
}