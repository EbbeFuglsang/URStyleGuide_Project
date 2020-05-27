package com.ur.style.components;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.ur.director.MessageDirector;
import com.ur.ekstra.MessageType;

public class URErrorMessage {
	
	private MessageDirector messageDirector = new MessageDirector();
	
	public URErrorMessage() {
	}
	
	public JLabel getLargeErrorMessage(String messageText, int width) {
		
		JLabel label = messageDirector.buildMessage(width, MessageType.ERROR, false);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(messageText);
		
		return label;
	}
	
	public JLabel getSmallErrorMessage(String messageText, int width) {
		
		JLabel label = messageDirector.buildMessage(width, MessageType.ERROR, true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(messageText);
		
		return label;
	}
	
}