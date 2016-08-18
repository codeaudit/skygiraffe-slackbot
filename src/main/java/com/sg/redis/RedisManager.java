package com.sg.redis;

import com.sg.model.sgdsRs.repdet.ReportDetail;
import com.sg.utils.Config;
import com.sg.utils.SGSlackConstants;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.*;

/**
 * Created by ayush on 7/7/16.
 */
public class RedisManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisManager.class);

    private static final Jedis jedis = new Jedis(Config.getPropertyValue("REDIS_HOST_DEV"),Integer.valueOf(Config.getPropertyValue("REDIS_PORT_DEV")));

    public static void store(String key, String value, int expiryInSeconds) {
        if (key == null || key.isEmpty() || value == null || value.isEmpty())
            throw new IllegalArgumentException("Key and value cannot be null or empty");
        //store data in redis list
        jedis.set(key, value);
        if (expiryInSeconds != -1) {
            jedis.expire(key, expiryInSeconds);
        }
    }

    public static String get(String key){

        logger.debug("Key="+key);
        String val = jedis.get(key);
        logger.debug("val="+val);
        return val;
    }


    /**
     *
     * @param searchText
     * @param keypattern
     * @return Each string
     */
    public static Set<String> getReportIds(String searchText, String keypattern) throws IOException {
        Set<String> names=jedis.keys(keypattern+"*");
        Set<String> repIdList = new HashSet<String>();
        for (String key: names){
            String repJson = jedis.get(key);
            if (repJson != null && StringUtils.containsIgnoreCase(repJson, searchText)){
                ReportDetail rd = new ReportDetail();
                ObjectMapper m = new ObjectMapper();
                rd = m.readValue(repJson,rd.getClass());
                /**if (!rd.getReportMetaData().getIsHidden()  &&
                        !"Parametrized".equals(rd.getReportMetaData().getReportType())) {
                    repIdList.add(rd.getReportMetaData().getReportID());
                }**/
                repIdList.add(rd.getReportMetaData().getReportID());

            }

        }
        return repIdList;
    }

    public static Map<String, String> getAllFavs(String keyPattern){
        Set<String> names=jedis.keys(keyPattern+"*");
        Map<String, String> favs = new HashMap<String, String>();
        for (String key: names){
            String fav = jedis.get(key);
            if (fav != null){
                logger.debug("Key"+StringUtils.substringAfterLast(key, SGSlackConstants.DELIMITER)+" Val"+fav);
                favs.put(StringUtils.substringAfterLast(key, SGSlackConstants.DELIMITER), fav);
            }
        }
        return favs;
    }

    public static void delete(String key){
        jedis.del(key);
    }

}
