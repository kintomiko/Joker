package org.joker.core.mapping.setter;

import java.lang.reflect.InvocationTargetException;

public interface Setter {

    void set(Object target, Object source) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;

}
