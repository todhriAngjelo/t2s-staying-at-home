package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.EncodingStrategy;
import com.t2s.staying.home.T2S.StayingHome.model.StrategySelecter;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class TuneEncoding implements ActionListener {

	DocumentEditorView view;

	public TuneEncoding(DocumentEditorView view) {
		this.view = view;
	}

	public TuneEncoding() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Document document = DocumentEditorView.getCurrentDocument();
		String cipher = DocumentEditorView.getEncoding();
		StrategySelecter strategySelecter = new StrategySelecter();
		EncodingStrategy encodingStrategy = strategySelecter.pickAStrategy(cipher);
		// todo
		document.tuneEncoding(encodingStrategy);
	}


}

