package com.github.samuelbr.springctw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionAccessor {

	@Autowired
	private SessionItem sessionItem;
	
	public int getValue() {
		return sessionItem.getValue();
	}
	
	public void setValue(int value) {
		sessionItem.setValue(value);
	}
	
}
