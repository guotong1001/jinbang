package org.fm.util;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * @ProjectName：fm
 * @ClassName：UUIDUtil
 * @TODO：封装各种生成唯一性ID算法的工具类.
 * @Auth：Mr.Zhang @Time：2020/9/15 15:01
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
public class UUIDUtil {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    /**
     * 基于Base62编码的SecureRandom随机生成bytes.
     */
    public static String randomBase62(int length) {
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return EncodeUtil.encodeBase62(randomBytes);
    }

    public static void main(String[] args) {
        System.out.println("FM-"+randomBase62(29));
    }
}
