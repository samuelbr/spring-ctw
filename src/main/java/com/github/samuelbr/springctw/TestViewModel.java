package com.github.samuelbr.springctw;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Execution;

public class TestViewModel {

	@Autowired
	private SessionAccessor accessor;
	
	private int count = 1000;
	
	private String output;
	
	@Init
	public void init(@ContextParam(ContextType.EXECUTION)Execution execution) {
		HttpServletRequest nativeRequest = (HttpServletRequest) execution.getNativeRequest();
		
		WebApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(nativeRequest.getSession().getServletContext());
		
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setOutput(String output) {
		this.output = output;
	}
	
	public String getOutput() {
		return output;
	}

	@Command
	@NotifyChange("output")
	public void test() {
		long startTime = new Date().getTime();
		
		for (int a=0; a<count; a++) {
			accessor.setValue(a);
			accessor.getValue();
		}
		
		long endTime = new Date().getTime();
		
		output = (endTime-startTime) + " ms.";
	}
	
}
