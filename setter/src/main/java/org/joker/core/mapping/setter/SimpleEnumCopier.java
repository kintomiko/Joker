package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;

public class SimpleEnumCopier extends MetaSetter{
    public SimpleEnumCopier(MappingMeta meta) {
        super(meta);
    }

    @Override
    protected Object parse(Object sourceValue) {
        return Enum.valueOf(meta.getPropertyMeta(), sourceValue.toString());
    }
}
