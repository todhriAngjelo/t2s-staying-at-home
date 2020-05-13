package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.command.DocumentToSpeech;
import com.t2s.staying.home.T2S.StayingHome.command.EditDocument;
import com.t2s.staying.home.T2S.StayingHome.command.OpenDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveDocument;
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
		}
		return null; // todo implement the rest of the commands
	}


}