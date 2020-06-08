/**
 * https://www.leimingtech.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.mybatis.entity.BaseEntity;
import org.wiulus.spring.cloud.commons.mybatis.enums.DelFlagEnum;
import org.wiulus.spring.cloud.commons.tools.security.user.SecurityUser;

import java.util.Date;

/**
 * 公共字段，自动填充值
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@Component
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATE_DATE = "createDate";
    private static final String CREATOR = "creator";
    private static final String UPDATE_DATE = "updateDate";
    private static final String UPDATER = "updater";
    private static final String DEL_FLAG = "delFlag";
    private static final String DEPT_ID = "deptId";


    @Override
    public void insertFill(MetaObject metaObject) {

        Date date = new Date();
        //创建时间
        setFieldValByName(CREATE_DATE, date, metaObject);
        //更新时间
        setFieldValByName(UPDATE_DATE, date, metaObject);

        //删除标识
        setFieldValByName(DEL_FLAG, DelFlagEnum.NORMAL.value(), metaObject);

//        UserDetail user = SecurityUser.getUser();
        String userName = SecurityUser.getUserName();

//        if(user == null){
//            return;
//        }
        if (metaObject.getOriginalObject() instanceof BaseEntity){
            //创建者
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
            if (null != baseEntity && StringUtils.isBlank(baseEntity.getCreator())) {
                setFieldValByName(CREATOR, userName, metaObject);
            }
            //更新者
            if (null != baseEntity && StringUtils.isBlank(baseEntity.getUpdater())) {
                setFieldValByName(UPDATER, userName, metaObject);
            }
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新时间
        setFieldValByName(UPDATE_DATE, new Date(), metaObject);

//        UserDetail user = SecurityUser.getUser();
        String userName = SecurityUser.getUserName();
//        if (user == null) {
//            return;
//        }
        //更新者
        setFieldValByName(UPDATER, userName, metaObject);

    }
}