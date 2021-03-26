package com.lanfang.logistics.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanfang.logistics.entity.Departure;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
public interface IDepartureService extends IService<Departure> {

    IPage<Departure> queryByCompanyId(IPage<Departure> page);
}
