package net.came20.monopoly.common;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by cameronearle on 12/27/16.
 */
public final class Tokenizer {
    private static SecureRandom random = new SecureRandom();
    public static String nextToken() {
        return new BigInteger(130, random).toString(32);
    }
}
