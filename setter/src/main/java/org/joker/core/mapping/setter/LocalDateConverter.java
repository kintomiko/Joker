package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateConverter extends MetaSetter{
    public LocalDateConverter(MappingMeta meta) {
        super(meta);
    }

    @Override
    protected Object parse(Object date) {
        if(date!= null) {
            if(date instanceof Date) {
                //TODO:need to confirm whether hibernate is using the same timezone
                return ((Date)date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }else if(date instanceof String){
                return LocalDate.parse((CharSequence) date);
            }
        }
        return null;
    }
}
