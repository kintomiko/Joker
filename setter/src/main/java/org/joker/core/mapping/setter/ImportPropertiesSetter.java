package org.joker.core.mapping.setter;

import org.joker.core.mapping.MappingMeta;
import org.joker.core.mapping.mapper.MapperFactory;
import org.joker.core.mapping.mapper.Mapper;

public class ImportPropertiesSetter extends MetaSetter{

    public ImportPropertiesSetter(MappingMeta meta) {
        super(meta);
    }

    @Override
    protected Object parse(Object sourceValue) {
        Mapper mapper = MapperFactory.getInstance(meta.getPropertyMeta());
        return mapper.map(sourceValue);
    }
}
