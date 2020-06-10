/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.tools.utils.DateUtils;
import java.util.Date;

/**
 * 日期转换
 *
 * @author : WiuLuS
 */
@Component
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        return DateUtils.convertBy(source);
    }

}
