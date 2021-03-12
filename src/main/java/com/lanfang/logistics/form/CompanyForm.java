package com.lanfang.logistics.form;

import org.springframework.web.multipart.MultipartFile;

public class CompanyForm {
    private long legalUserId;

    private String name;

    private String longitude;

    private String latitude;

    private String region;

    private String address;

    private MultipartFile licenseFile;

    private MultipartFile doorImageFile;

    private MultipartFile roadTransportFile;

}
