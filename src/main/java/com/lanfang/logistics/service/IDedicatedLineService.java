package com.lanfang.logistics.service;

import com.lanfang.logistics.entity.DedicatedLine;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
public interface IDedicatedLineService extends IService<DedicatedLine> {

    List<DedicatedLine> queryByCompanyId(long companyId);
}
