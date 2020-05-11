package com.t2s.staying.home.T2S.StayingHome.factory;

import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.command.EditDocument;
import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;

public class CommandsFactory {

	public ActionListener createCommand(String commandKind, Object viewClass) {

		if (commandKind.equals("newDocument") && viewClass instanceof NewDocumentView) {
			NewDocument newDocument = new NewDocument((NewDocumentView) viewClass);
			return newDocument;
		} else if (commandKind.equals("editCommand")) {
			EditDocument editDocument = new EditDocument();
			return editDocument;
		}

		return null; // todo implement the rest of the commands
	}


}