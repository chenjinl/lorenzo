package com.aitutech.lorenzo.common.shiro;

import com.aitutech.lorenzo.common.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {

    public static final String ALGORITHM = "SHA-1";

    public static final int HASHITERATIONS = 2;

    private static final int SALT_SIZE = 22;


    public static String encryptPassword(User user) {
        String newPassword = new SimpleHash(
                ALGORITHM,
                user.getPassword(),
                HASHITERATIONS).toHex();
        return  newPassword;
    }

}
