package com.portal.automation;

public enum FramesDasTelas{
	FrameDaTelaAtiva("//div[@class='tab-pane active']//iframe");
	private String frame;

	FramesDasTelas(String frame) {
		this.frame = frame;
	}

	public String getFrame() {
		return frame;
	}
}
