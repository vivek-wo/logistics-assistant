package com.lanfang.logistics.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFileUtils {

    /**
     * 保存图片文件
     *
     * @param path
     * @param file
     * @return
     * @throws IOException
     */
    public static String saveImageFile(String path, MultipartFile file) throws IOException {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : "";
        String saveFileName = UUID.randomUUID().toString() + "." + type;
        File licenseFile = new File(path + saveFileName);
        file.transferTo(licenseFile);
        return saveFileName;
    }
}
