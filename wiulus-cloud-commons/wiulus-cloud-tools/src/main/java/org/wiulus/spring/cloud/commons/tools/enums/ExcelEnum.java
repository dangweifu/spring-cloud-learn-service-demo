package org.wiulus.spring.cloud.commons.tools.enums;

import lombok.Getter;

/**
 * 功能描述：
 * excel导出枚举
 *
 * @author 宋文豪
 * @email: songwenhao@wiulus.com
 * @Date : 2020/3/10
 **/

@Getter
public enum ExcelEnum {

    /**
     * 商品导出
     */
   GOODS_EXPORT("goods_export","商品导出"),;

   private String code;

   private String name;

   ExcelEnum(String code, String name) {
       this.code = code;
       this.name = name;
   }


}
