package com.oycbest.springbootredis.constants;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/22 11:33 下午
 */

public final class RedisConstants {

    static final String _PREFIX = "ars:";

    //缓存组
    public static final class EntityCacheKey {
        public static final String QUERY = _PREFIX + "query";
        public static final String MANAGE = _PREFIX + "manage";
        public static final String OPINION = _PREFIX + "opinion";
        public static final String POINT = _PREFIX + "point";
        public static final String REPORTBIZ = _PREFIX + "reportbiz";
        public static final String REPORTDATA = _PREFIX + "reportdata";
        public static final String RESOURCE = _PREFIX + "resource";
        public static final String TASK = _PREFIX + "task";
    }

    //临时缓存 key
    //public static final String TEMP_REGION_IMPORT_KEY = _PREFIX+"temp:region:import";

}
