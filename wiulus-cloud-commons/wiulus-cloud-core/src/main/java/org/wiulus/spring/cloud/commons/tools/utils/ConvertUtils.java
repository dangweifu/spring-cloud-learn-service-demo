/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.List;

/**
 * 转换工具类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
public class ConvertUtils {
    private ConvertUtils() {
    }

    private static Logger logger = LoggerFactory.getLogger(ConvertUtils.class);

    public static <T> T sourceToTarget(Object source, Class<T> target) {
        return BeanCopierUtils.copy(source,target);
    }

    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        return BeanCopierUtils.copyList(sourceList,target);
    }
}