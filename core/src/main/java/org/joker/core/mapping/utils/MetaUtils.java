package org.joker.core.mapping.utils;

import org.joker.core.mapping.MappingMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class MetaUtils {

    public static MappingMeta[] values(Class enumClass) {

        if (enumClass == null || !enumClass.isEnum())
            return null;

        ArrayList<MappingMeta> rtn = new ArrayList<>();
        EnumSet values = EnumSet.allOf(enumClass);
        Iterator<Enum> iterator = values.iterator();
        while(iterator.hasNext()) {
            Enum one = iterator.next();
            rtn.add((MappingMeta)one);
        }

        return rtn.toArray(new MappingMeta[rtn.size()]);

    }

    public static Field getDeclaredFieldIncludingParent(Class targetClass, String fieldName){
        Class clazz = targetClass;
        Field rst = null;
        while(clazz != null && rst == null){
            rst = getField(clazz, fieldName);
            clazz = clazz.getSuperclass();
        }
        return rst;
    }

    public static  Field getField(Class targetClass, String fieldName) {
        for(Field field:targetClass.getDeclaredFields()){
            if(field.getName().equals(fieldName)){
                return field;
            }
        }
        return null;
    }
}
