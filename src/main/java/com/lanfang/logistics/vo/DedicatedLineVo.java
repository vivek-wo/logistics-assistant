package com.lanfang.logistics.vo;

import lombok.Data;

import java.util.List;

@Data
public class DedicatedLineVo {
    private CompanySiteVo startSite;
    private List<CompanySiteVo> middleSites;
    private CompanySiteVo endSite;
}
