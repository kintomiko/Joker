package org.joker.core.mapping.mapper;

import java.util.HashMap;
import java.util.Map;

public class MapperFactory {

    //global mapper cache for the mappers
    private static Map<Class, Mapper> mappers = new HashMap<>();

    /***
     * factory method for the Mapper, using double check to improve performance and race condition.
     *
     * @param propertyMeta
     * @return
     */
    public static Mapper getInstance(Class propertyMeta) {
        //double check synchronized
        if(mappers.get(propertyMeta) == null) {
            synchronized (MapperFactory.class) {
                if (mappers.get(propertyMeta) == null) {
                    mappers.put(propertyMeta, new Mapper(propertyMeta));
                }
            }
        }
        return mappers.get(propertyMeta);
    }
}
