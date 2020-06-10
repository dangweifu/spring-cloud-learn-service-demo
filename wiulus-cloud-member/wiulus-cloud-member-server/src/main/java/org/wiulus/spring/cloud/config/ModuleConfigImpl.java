/**
 *
 *
 * https://www.wiulus.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.config;

import org.wiulus.spring.cloud.commons.tools.config.ModuleConfig;
import org.springframework.stereotype.Service;

/**
 * @author : WiuLuS
 * @version 1.0
 * @date 2020-06-10 13:57 PM
 */
@Service
public class ModuleConfigImpl implements ModuleConfig {
    @Override
    public String getName() {
        return "member";
    }
}