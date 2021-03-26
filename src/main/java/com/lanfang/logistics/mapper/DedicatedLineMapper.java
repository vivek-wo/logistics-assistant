package com.lanfang.logistics.mapper;

import com.lanfang.logistics.entity.DedicatedLine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Repository
public interface DedicatedLineMapper extends BaseMapper<DedicatedLine> {

    @Select("SELECT * FROM t_dedicated_line WHERE startSiteId IN (SELECT id FROM t_site WHERE companyId = #{companyId})")
    List<DedicatedLine> queryByCompanyId(long companyId);
}
