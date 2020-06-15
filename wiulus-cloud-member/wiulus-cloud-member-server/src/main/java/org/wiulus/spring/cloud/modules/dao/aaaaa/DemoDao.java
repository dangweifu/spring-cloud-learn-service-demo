package org.wiulus.spring.cloud.modules.dao.aaaaa;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.annotations.Mapper;
import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
import org.wiulus.spring.cloud.modules.entity.aaaaa.DemoEntity;

/**
 * @author : WiuLuS
 * @version : v1.0 06.15.2020
 * @discription :
 * @date : 2020-06-15 15:35:14
 * @email : m13886933623@163.com
 */
@Mapper
public interface DemoDao  extends BaseDao<DemoEntity> {
}
