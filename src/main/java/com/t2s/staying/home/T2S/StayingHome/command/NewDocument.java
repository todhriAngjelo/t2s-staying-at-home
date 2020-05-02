package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class NewDocument implements ActionListener {

	private Document document;

	@Override
	public void actionPerformed(ActionEvent e) {
//		e.getActionCommand()

		System.out.println("gmtx");

	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
