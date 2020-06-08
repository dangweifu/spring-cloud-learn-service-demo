package org.wiulus.spring.cloud.commons.tools.feign;

import lombok.Data;

@Data
public class FeignFaildResult {
    private int status;
    private String message;
}
