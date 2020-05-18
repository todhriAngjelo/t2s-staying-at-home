package com.t2s.staying.home.T2S.StayingHome.factory;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import com.t2s.staying.home.T2S.StayingHome.command.*;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;

import java.awt.event.ActionListener;

public class CommandsFactory {

	public ActionListener createCommand(String commandKind, Object view) {

		if (commandKind.equals(OPEN_DOCUMENT_COMMAND)) {
			OpenDocument openDocument = new OpenDocument((DocumentEditorView) view);
			return openDocument;
		} else if (commandKind.equals(NEW_DOCUMENT_COMMAND)) {
			NewDocument saveDocument = new NewDocument((NewDocumentView) view);
			return saveDocument;
		} else if (commandKind.equals(DOC_TO_SPEECH_COMMAND)) {
			DocumentToSpeech docToSpeech = new DocumentToSpeech((DocumentEditorView) view);
			return docToSpeech;
		} else if (commandKind.equals(LINE_TO_SPEECH)) {
			LineToSpeech lineToSpeech = new LineToSpeech((DocumentEditorView) view);
			return lineToSpeech;
		} else if (commandKind.equals(REVERSE_ALL_COMMAND)) {
			ReverseAll reverseAll = new ReverseAll((DocumentEditorView) view);
			return reverseAll;
		} else if (commandKind.equals(REVERSE_LINE_COMMAND)) {
			ReverseLine reverseLine = new ReverseLine((DocumentEditorView) view);
			return reverseLine;
		}
		else if (commandKind.equals("tuneEncoding")){
			TuneEncoding tuneEncoding = new TuneEncoding((DocumentEditorView) view);
			return tuneEncoding;
		}
		else if (commandKind.equals("rot")){
			Rot rot = new Rot((DocumentEditorView)view);
			return rot;
		}
		return null; // todo implement the rest of the commands
	}


}