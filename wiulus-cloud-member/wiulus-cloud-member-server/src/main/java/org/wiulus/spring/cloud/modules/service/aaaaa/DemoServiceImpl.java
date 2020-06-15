package org.wiulus.spring.cloud.modules.service.aaaaa;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wiulus.spring.cloud.commons.mybatis.service.impl.CrudServiceImpl;
import org.wiulus.spring.cloud.modules.dao.aaaaa.DemoDao;
import org.wiulus.spring.cloud.modules.dto.aaaaa.DemoDTO;
import org.wiulus.spring.cloud.modules.entity.aaaaa.DemoEntity;

import java.util.Map;

/**
 * @author : WiuLuS
 * @version : v1.0 06.15.2020
 * @discription :
 * @date : 2020-06-15 15:34:26
 * @email : m13886933623@163.com
 */
@RestController("demoServiceImpl")
@RequestMapping("demo/info")
public class DemoServiceImpl extends CrudServiceImpl<DemoDao, DemoEntity, DemoDTO> implements DemoService {


    @Override
    public QueryWrapper<DemoEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");
        QueryWrapper<DemoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        return wrapper;
    }

    @Override
    public void add(DemoDTO dto) {
        super.save(dto);
    }

    @Override
    public void modify(DemoDTO dto) {
        super.update(dto);
    }

    @Override
    public void del(Long[] ids) {
        super.delete(ids);
    }

    @Override
    public DemoDTO selectBy(Long id) {
        return super.get(id);
    }
}
