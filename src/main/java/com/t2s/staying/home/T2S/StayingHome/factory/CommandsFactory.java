package com.t2s.staying.home.T2S.StayingHome.factory;

import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.command.EditDocument;
import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;

public class CommandsFactory {

	public ActionListener createCommand(String commandKind) {

		if (commandKind.equals("newDocument")) {
			NewDocument newDocument = new NewDocument();
			return newDocument;
		} else if (commandKind.equals("editCommand")) {
			EditDocument editDocument = new EditDocument();
			return editDocument;
		}

		return null; // todo implement the rest of the commands
	}


}