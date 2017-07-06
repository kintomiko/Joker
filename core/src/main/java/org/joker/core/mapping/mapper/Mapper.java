package org.joker.core.mapping.mapper;

import org.joker.core.mapping.MappingMeta;
import org.joker.core.mapping.annotation.ObjectMapper;
import org.joker.core.mapping.setter.Setter;
import org.joker.core.mapping.setter.SetterFactory;
import org.joker.core.mapping.utils.MetaUtils;

public class Mapper {

    private final Class metaClass;

    public Mapper(Class metaClass) {
        this.metaClass = metaClass;
    }

    public Object map(Object source){
        ObjectMapper annotation = (ObjectMapper) metaClass.getDeclaredAnnotation(ObjectMapper.class);
        if(annotation == null)
            throw new IllegalStateException("Metas should define the ObjectMapper annotation");

        Object target;
        try {
            target = annotation.target().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        map(source, target);
        return target;
    }

    private void map(Object source, Object target){
        _travel(source, target);
    }

    private void _travel(Object source, Object target) {
        for(MappingMeta fieldMap: MetaUtils.values(metaClass)){

            Setter setter = null;
            try {
                setter = SetterFactory.getInstance(fieldMap);
                setter.set(target, source);
            } catch (Throwable  e) {
                throw new RuntimeException(e);
            }

        }
    }
}
