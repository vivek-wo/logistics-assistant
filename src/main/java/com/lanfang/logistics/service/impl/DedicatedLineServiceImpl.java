package com.lanfang.logistics.service.impl;

import com.lanfang.logistics.entity.DedicatedLine;
import com.lanfang.logistics.mapper.DedicatedLineMapper;
import com.lanfang.logistics.service.IDedicatedLineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Service
public class DedicatedLineServiceImpl extends ServiceImpl<DedicatedLineMapper, DedicatedLine> implements IDedicatedLineService {

    private final DedicatedLineMapper dedicatedLineMapper;

    public DedicatedLineServiceImpl(DedicatedLineMapper dedicatedLineMapper) {
        this.dedicatedLineMapper = dedicatedLineMapper;
    }

    @Override
    public List<DedicatedLine> queryByCompanyId(long companyId) {
        return this.dedicatedLineMapper.queryByCompanyId(companyId);
    }
}
