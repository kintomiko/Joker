package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;
import org.joda.time.DateTime;

public class DateTimeConverter extends MetaSetter {
    public DateTimeConverter(MappingMeta meta) {
        super(meta);
    }

    @Override
    protected Object parse(Object date) {
        if(date!= null) {
            if(date instanceof String){
                return DateTime.parse((String) date);
            }
        }
        return null;
    }
}
