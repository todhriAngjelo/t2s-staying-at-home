package com.t2s.staying.home.T2S.StayingHome.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;

public class NewDocumentView {

	private CommandsFactory commandsFactory = new CommandsFactory();
	private final Logger log = LoggerFactory.getLogger(NewDocumentView.class);

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				NewDocumentView window = new NewDocumentView();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public NewDocumentView() {
		initialize();
		this.frame.setVisible(true);

	}

	private void initialize() {

	}
}
