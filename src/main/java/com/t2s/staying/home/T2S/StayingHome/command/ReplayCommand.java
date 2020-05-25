package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.manager.ReplayManager;

public class ReplayCommand implements ActionListener {

	private ReplayManager replayManager;

	public ReplayCommand(ReplayManager replayManager){
		this.replayManager=replayManager;
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		replayManager.replay();

	}
}
