package org.joker.core.mapping;

public interface MappingMeta {
    Class getSetterClass();

    String getSourcePropertyName();

    String getTargetPropertyName();

    Class getPropertyMeta();
}
