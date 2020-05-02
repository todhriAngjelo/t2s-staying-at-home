package com.t2s.staying.home.T2S.StayingHome.factory;

import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveDocument;
import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class CommandsFactory {

	private Document document;

	public ActionListener createCommand(String commandKind) {

		if (commandKind.equals("saveDocument")) {
			SaveDocument saveDocument = new SaveDocument();
			return saveDocument;
		}

		if (commandKind.equals("newDocument")) {
			NewDocument newDocument = new NewDocument();
			return newDocument;
		}

		return null; // todo implement the rest of the commands
	}


}