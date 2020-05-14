package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.command.*;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionListener;

public class CommandsFactory {

	public ActionListener createCommand(String commandKind, Object view) {

		if (commandKind.equals("editCommand")) {
			EditDocument editDocument = new EditDocument();
			return editDocument;
		}else if (commandKind.equals("openDocument") ) {
			OpenDocument openDocument = new OpenDocument((DocumentEditorView) view);
			return openDocument;
		}else if (commandKind.equals("saveDocument") ) {
			SaveDocument saveDocument = new SaveDocument((DocumentEditorView) view);
			return saveDocument;
		}else if (commandKind.equals("text2SpeechDocument")){
			DocumentToSpeech docToSpeech = new DocumentToSpeech((DocumentEditorView) view);
			return docToSpeech;
		}else if (commandKind.equals("text2SpeechLine")){
			LineToSpeech lineToSpeech = new LineToSpeech((DocumentEditorView) view);
			return lineToSpeech;
		}
		return null; // todo implement the rest of the commands
	}


}