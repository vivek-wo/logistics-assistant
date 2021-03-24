package com.lanfang.logistics.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "lanfang")
public class PropertiesConfiguration {
    private String uploadFilePath;
    private String uploadIDPhotoPath;
}
