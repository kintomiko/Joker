package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;
import org.joker.core.mapping.utils.MetaUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public abstract class MetaSetter implements Setter {

    public static final String DOT = "\\.";
    protected final MappingMeta meta;

    protected MetaSetter(MappingMeta meta) {
        this.meta = meta;
    }

    @Override
    public void set(Object target, Object source) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Object sourceValue = source;
        if(meta.getSourcePropertyName() != null) {
            if(source.getClass().isEnum() && meta.getSourcePropertyName().equals("name")){
                sourceValue = source.toString();
            }else{
                //split by dot
                String[] fields = meta.getSourcePropertyName().split(DOT);
                Class clazz = source.getClass();
                for(int i=0;i<fields.length;i++){
                    Field sourceField = MetaUtils.getDeclaredFieldIncludingParent(clazz, fields[i]);
                    sourceField.setAccessible(true);
                    sourceValue = sourceField.get(sourceValue);
                    if(sourceValue == null) {
                        break;
                    }
                    clazz = sourceValue.getClass();
                }
            }
        }

        Object value = parse(sourceValue);

        Field targetField = MetaUtils.getDeclaredFieldIncludingParent(target.getClass(), meta.getTargetPropertyName());
        targetField.setAccessible(true);
        targetField.set(target, value);

    }

    protected abstract Object parse(Object sourceValue);
}
