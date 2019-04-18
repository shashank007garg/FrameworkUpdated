package com.test.automation.uiAutomation.constants;

public enum SignUpPageConstant {

	EMAIL_ADDERESS("shashank001garg@gmail.com"), FIRST_NAME("shashank"), lAST_NAME(
			"garg"), PASSWORD("shashank2123"), ADDERESS("A-53 new york"), CITY_NAME(
			"NEW YORK");

	private final String value;

	private SignUpPageConstant(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
