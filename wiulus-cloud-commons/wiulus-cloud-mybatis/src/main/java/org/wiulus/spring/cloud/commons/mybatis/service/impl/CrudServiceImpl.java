/**
 *
 * <p>
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import org.wiulus.spring.cloud.commons.mybatis.service.CrudService;
import org.wiulus.spring.cloud.commons.tools.constant.Contants;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务类
 *
 * @author : WiuLuS
 */
public abstract class CrudServiceImpl<M extends BaseMapper<T>, T, D> extends BaseServiceImpl<M, T> implements CrudService<T, D> {

    protected Class<D> currentDtoClass() {
        return (Class<D>)ReflectionKit.getSuperClassGenericType(getClass(), 2);
    }

    @Override
    public PageData<D> page(Map<String, Object> params) {
        IPage<T> page = baseDao.selectPage(
            getPage(params, Contants.CREATE_DATE, false),
            getWrapper(params)
        );

        return getPageData(page, currentDtoClass());
    }

    @Override
    public List<D> list(Map<String, Object> params) {
        List<T> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public D get(Long id) {
        T entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public void save(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(entity);
    }

    @Override
    public void update(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        updateById(entity);
    }

    @Override
    public void delete(Long[] ids) {
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}
