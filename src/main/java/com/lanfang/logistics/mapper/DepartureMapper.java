package com.lanfang.logistics.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lanfang.logistics.entity.DedicatedLine;
import com.lanfang.logistics.entity.Departure;
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
public interface DepartureMapper extends BaseMapper<Departure> {

    @Select("SELECT * FROM t_departure")
    IPage<Departure> queryByCompanyId(IPage<Departure> page);

}
