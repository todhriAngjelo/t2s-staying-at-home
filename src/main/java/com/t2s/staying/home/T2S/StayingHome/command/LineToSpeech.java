package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;


public class LineToSpeech implements ActionListener {

	private DocumentEditorView lineToSpeechView;
	//private Document doc = new Document();
	public LineToSpeech(DocumentEditorView lineToSpeechView){this.lineToSpeechView = lineToSpeechView;}
	@Override
	public void actionPerformed(ActionEvent e) {
		int lineNumber = lineToSpeechView.getLineNumber();
		String doc = lineToSpeechView.getTextArea();

		List<String> lines = Arrays.asList(doc.split("\n"));

			FreeTTSAdapter freeTTS = new FreeTTSAdapter();
			try {
				for (int n = 0; n < lineToSpeechView.getJTextArea().getLineCount(); n += 1)
				{
					if (lineNumber == n) {
						freeTTS.play(lines.get(n));
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
}
