package com.pony.backend.controller;

import com.pony.backend.annotation.AuthCheck;
import com.pony.backend.common.BaseResponse;
import com.pony.backend.common.ResultUtils;
import com.pony.backend.manager.CosManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private CosManager cosManager;


    /**
     * 测试文件上传
     * @param multipartFile
     * @return
     */
    @AuthCheck(mustRole = "admin")
    @PostMapping("/test/upload")
    public BaseResponse<String> testUpload(@RequestPart("file")MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        String filePath = String.format("/xm-picture/%s", filename);
        File file = null;

        try {
            file = File.createTempFile(filePath, null);
            multipartFile.transferTo(file);
            cosManager.putObject(filePath, file);
            return ResultUtils.success(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null) {
                boolean res = file.delete();
                if (!res) {
                    log.error("file delete error, filepath = {}", filePath);
                }
            }
        }

    }
}
