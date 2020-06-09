//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.wiulus.spring.cloud.logs.tracing;

import java.util.UUID;

public class IdGenerator {
    public IdGenerator() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
