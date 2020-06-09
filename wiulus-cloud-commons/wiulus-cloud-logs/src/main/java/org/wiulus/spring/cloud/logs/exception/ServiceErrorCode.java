//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.wiulus.spring.cloud.logs.exception;

import java.io.Serializable;

public interface ServiceErrorCode extends Serializable {
    String getCode();

    String getMessage();

    boolean isClientError();

    boolean isServerError();

    int getHttpStatus();
}
