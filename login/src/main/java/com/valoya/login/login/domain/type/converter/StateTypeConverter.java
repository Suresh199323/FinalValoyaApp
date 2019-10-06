package com.valoya.login.login.domain.type.converter;

import com.valoya.login.login.domain.type.State;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public final class StateTypeConverter implements AttributeConverter<State, String> {
	@Override
	public String convertToDatabaseColumn(final State attribute) {
		return attribute == null ? State.ACTIVE.name() : attribute.name();
	}

	@Override
	public State convertToEntityAttribute(final String dbData) {
		return dbData == null ? State.ACTIVE : State.valueOf(dbData);
	}
}