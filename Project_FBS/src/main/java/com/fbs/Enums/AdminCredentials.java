package com.fbs.Enums;

public enum AdminCredentials {
	USERNAME("admin"), PASSWORD("admin");

	private final String value;

	AdminCredentials(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
