package com.t2s.staying.home.T2S.StayingHome.test;

import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;
import org.junit.jupiter.api.Test;
import org.w3c.dom.views.DocumentView;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NewDocumentTest {

    @Test
    void newTest() {

        NewDocumentView newDocumentView = new NewDocumentView();
        NewDocument saveButton = new NewDocument(newDocumentView);
        saveButton.actionPerformed(null);
        Document document = DocumentManager.getCurrentDocument();
        assertNotNull(document);


       // assertEquals(0, contents.size());

    }
}
