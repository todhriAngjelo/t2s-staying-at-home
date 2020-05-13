package com.t2s.staying.home.T2S.StayingHome.factory;

import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.command.EditDocument;
import com.t2s.staying.home.T2S.StayingHome.command.OpenDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveDocument;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class CommandsFactory {

	private Object DocumentEditorView;

	public ActionListener createCommand(String commandKind) {

		if (commandKind.equals("editCommand")) {
			EditDocument editDocument = new EditDocument();
			return editDocument;
		}else if (commandKind.equals("openDocument") ) {
			OpenDocument openDocument = new OpenDocument((com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView) DocumentEditorView);
			return openDocument;
		}else if (commandKind.equals("saveDocument") ) {
			SaveDocument saveDocument = new SaveDocument((com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView) DocumentEditorView);
			return saveDocument;
		}
		return null; // todo implement the rest of the commands
	}


}