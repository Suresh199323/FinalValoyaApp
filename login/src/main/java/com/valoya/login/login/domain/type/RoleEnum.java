package com.valoya.login.login.domain.type;

public enum RoleEnum {

	ROLE_ADMIN("ROLE_ADMIN"), //Reseller admin which can CRUD agents
    ROLE_USER("ROLE_USER"), //Reseller agent who does the calclations
    ROLE_SUPER_ADMIN("ROLE_SUPER_ADMIN"); //Valoya admin who acts as a site admin

	private String code;
	private RoleEnum(final String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return code;
	}
}
