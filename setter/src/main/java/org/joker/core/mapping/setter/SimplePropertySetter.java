package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;
import org.joda.time.DateTime;

public class SimplePropertySetter extends MetaSetter{

    public SimplePropertySetter(MappingMeta meta) {
        super(meta);
    }

    @Override
    protected Object parse(Object sourceValue) {
        if (sourceValue != null) {
            if (sourceValue.getClass().isEnum()
                    || sourceValue instanceof DateTime) {
                return sourceValue.toString();
            }
        }
        return sourceValue;
    }

}
