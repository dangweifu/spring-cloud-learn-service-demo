/**
 *
 *
 * https://www.leimingtech.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.mybatis.aspect;


import cn.hutool.core.collection.CollUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.mybatis.annotation.DataFilter;
import org.wiulus.spring.cloud.commons.mybatis.entity.DataScope;
import org.wiulus.spring.cloud.commons.tools.constant.Contants;
import org.wiulus.spring.cloud.commons.tools.enums.SuperAdminEnum;
import org.wiulus.spring.cloud.commons.tools.exception.CustomException;
import org.wiulus.spring.cloud.commons.tools.exception.ErrorCode;
import org.wiulus.spring.cloud.commons.tools.security.user.SecurityUser;
import org.wiulus.spring.cloud.commons.tools.security.user.UserDetail;

import java.util.List;
import java.util.Map;

/**
 * 数据过滤，切面处理类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Aspect
@Component
public class DataFilterAspect {
    @Pointcut("@annotation(com.leimingtech.commons.mybatis.annotation.DataFilter)")
    public void dataFilterCut() {

    }

    @Before("dataFilterCut()")
    public void dataFilter(JoinPoint point) {
        Object params = point.getArgs()[0];
        if(params != null && params instanceof Map){
            UserDetail user = SecurityUser.getUser();

            //如果不是超级管理员，则进行数据过滤
            if(user.getSuperAdmin() == SuperAdminEnum.NO.value()){
                Map map = (Map)params;
                String sqlFilter = getSqlFilter(user, point);
                map.put(Contants.SQL_FILTER, new DataScope(sqlFilter));
            }

            return ;
        }

        throw new CustomException(ErrorCode.DATA_SCOPE_PARAMS_ERROR);
    }

    /**
     * 获取数据过滤的SQL
     */
    private String getSqlFilter(UserDetail user, JoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);
        //获取表的别名
        String tableAlias = dataFilter.tableAlias();
        if(StringUtils.isNotBlank(tableAlias)){
            tableAlias +=  ".";
        }

        StringBuilder sqlFilter = new StringBuilder();

        //查询条件前缀
        String prefix = dataFilter.prefix();
        if(StringUtils.isNotBlank(prefix)){
            sqlFilter.append(" ").append(prefix);
        }

        sqlFilter.append(" (");

        //部门ID列表
        List<Long> deptIdList = user.getDeptIdList();
        if(CollUtil.isNotEmpty(deptIdList)){
            sqlFilter.append(tableAlias).append(dataFilter.deptId());

            sqlFilter.append(" in(").append(StringUtils.join(deptIdList, ",")).append(")");
        }

        //查询本人数据
        if(CollUtil.isNotEmpty(deptIdList)){
            sqlFilter.append(" or ");
        }
        sqlFilter.append(tableAlias).append(dataFilter.userName()).append("=").append(user.getUsername());

        sqlFilter.append(")");

        return sqlFilter.toString();
    }
}