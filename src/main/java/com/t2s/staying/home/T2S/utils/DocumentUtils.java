package com.t2s.staying.home.T2S.utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;

public class DocumentUtils {

    private static final Document document = new Document();

    public static Document getCurrentDocument() {
        return document;
    }

    public static String getListWordsInAString(List<String> words) {
        AtomicReference<String> textFromWords = new AtomicReference<>("");

        words.forEach(word ->
                textFromWords.set(textFromWords.get().concat(word).concat(" ")));

        return textFromWords.get();
    }

    public static String getTextFromDocument(Document document) {
        AtomicReference<String> textFromLines = new AtomicReference<>("");

        document.getLines().forEach(line -> {
            line.getWords().forEach(word ->
                    textFromLines.set(textFromLines.get().concat(word).concat(" ")));
            textFromLines.set(textFromLines.get().concat("<br>"));
        });

        return textFromLines.get();
    }

    public static Line findDocumentLineFromCaretPosition(Integer caretPosition, Document document) {

        int charsPassed = 1;
        for (Line line : document.getLines()) {
            for (String word : line.getWords()) {
                if ((charsPassed <= caretPosition) && (caretPosition <= (charsPassed + word.length()))) {
                    return line;
                }
                charsPassed = charsPassed + word.length();
            }
        } // fixme
        return null;
    }
}

