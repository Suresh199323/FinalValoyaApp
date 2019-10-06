package com.valoya.login.login.domain.type.converter;

import com.valoya.login.login.domain.type.RoleEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleTypeConverter implements AttributeConverter<RoleEnum, String> {

	@Override
	public String convertToDatabaseColumn(RoleEnum attribute) {
		return attribute == null ? RoleEnum.ROLE_USER.name() : attribute.name();
	}

	@Override
	public RoleEnum convertToEntityAttribute(String dbData) {
		return dbData == null ? RoleEnum.ROLE_USER : RoleEnum.valueOf(dbData);
	}

}
