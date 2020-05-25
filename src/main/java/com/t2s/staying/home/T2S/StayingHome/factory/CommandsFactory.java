package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.command.*;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;

import java.awt.event.ActionListener;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

public class CommandsFactory {

	public ActionListener createCommand(String commandKind, Object view) {

		if (commandKind.equals(OPEN_DOCUMENT_COMMAND)) {
			OpenDocument openDocument = new OpenDocument((DocumentEditorView) view);
			return openDocument;
		} else if (commandKind.equals(NEW_DOCUMENT_COMMAND)) {
			NewDocument saveDocument = new NewDocument((NewDocumentView) view);
			return saveDocument;
		} else if(commandKind.equals(SAVE_DOCUMENT_COMMAND)){
			SaveEdited saveEdited = new SaveEdited((DocumentEditorView) view);
			return saveEdited;
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
		} else if (commandKind.equals(ENCODE_ALL_ATBASH)) {
			EncodeAllAtbash encodeAllAtbash = new EncodeAllAtbash((DocumentEditorView) view);
			return encodeAllAtbash;
		} else if (commandKind.equals(ENCODE_LINE_ATBASH)) {
			EncodeLineAtbash encodeLineAtbash = new EncodeLineAtbash((DocumentEditorView) view);
			return encodeLineAtbash;
		} else if (commandKind.equals(ENCODE_ALL_ROT13)){
			EncodeAllRiot13 encodeAllRiot13 = new EncodeAllRiot13((DocumentEditorView) view);
			return encodeAllRiot13;
		}else if (commandKind.equals(ENCODE_LINE_ROT13)){
			EncodeLineRiot13 encodeLineRiot13 = new EncodeLineRiot13((DocumentEditorView) view);
			return encodeLineRiot13;
		}else if(commandKind.equals(REPLAY_COMMAND)){
		if (view instanceof DocumentEditorView) {
			ReplayCommand replayCommand = new ReplayCommand(((DocumentEditorView) view).getReplayManager());
			return replayCommand;
		}
	}
		return null;
	}
}