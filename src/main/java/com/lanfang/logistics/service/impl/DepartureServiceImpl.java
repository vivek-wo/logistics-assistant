package com.lanfang.logistics.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanfang.logistics.entity.Departure;
import com.lanfang.logistics.mapper.DepartureMapper;
import com.lanfang.logistics.service.IDepartureService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Service
public class DepartureServiceImpl extends ServiceImpl<DepartureMapper, Departure> implements IDepartureService {

    private final DepartureMapper departureMapper;

    public DepartureServiceImpl(DepartureMapper departureMapper) {
        this.departureMapper = departureMapper;
    }

    @Override
    public IPage<Departure> queryByCompanyId(IPage<Departure> page) {
        return this.departureMapper.queryByCompanyId(page);
    }
}
