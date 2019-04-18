package com.test.automation.uiAutomation.constants;

public enum IPMPageConstant {
	
	
	USER_NAME("Shashank Garg");
	
	private final String value;
	
	private IPMPageConstant(String value){
		this.value = value;
	}
	
	public String value(){
		return value;
	}
}
