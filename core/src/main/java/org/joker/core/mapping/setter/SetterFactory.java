package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;

import java.lang.reflect.InvocationTargetException;

public class SetterFactory {
    public static Setter getInstance(MappingMeta setterMeta) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Setter) setterMeta.getSetterClass().getConstructor(MappingMeta.class).newInstance(setterMeta);
    }
}
