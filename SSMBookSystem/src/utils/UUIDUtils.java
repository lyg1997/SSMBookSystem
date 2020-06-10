package utils;

import java.util.UUID;

/**
 *
 * @description: uuid 工具类
 *
 */

public class UUIDUtils {
    public static String getUUID() {
        String uuidStr = UUID.randomUUID().toString();
        return uuidStr.replaceAll("-", "");
    }
}
