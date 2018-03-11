package io.toanyone.user.common;

import javax.persistence.AttributeConverter;

public class BoolAndYesNoConverter implements AttributeConverter<Boolean, String> {


    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null) {
            return null;
        }

        if(attribute.booleanValue()) {
            return "Y";
        }

        return "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        if (dbData.equals("Y") || dbData.equals("y")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
