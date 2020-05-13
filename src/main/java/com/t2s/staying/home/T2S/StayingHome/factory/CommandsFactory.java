package com.t2s.staying.home.T2S.StayingHome.factory;

import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.command.EditDocument;
import com.t2s.staying.home.T2S.StayingHome.command.OpenDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveDocument;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class CommandsFactory {

	public ActionListener createCommand(String commandKind, Object viewClass) {

		if (commandKind.equals("editCommand")) {
			EditDocument editDocument = new EditDocument();
			return editDocument;
		}else if (commandKind.equals("openDocument") ) {
			OpenDocument openDocument = new OpenDocument((DocumentEditorView) viewClass);
			return openDocument;
		}else if (commandKind.equals("saveDocument") ) {
			SaveDocument saveDocument = new SaveDocument((DocumentEditorView) viewClass);
			return saveDocument;
		}
		return null; // todo implement the rest of the commands
	}


}