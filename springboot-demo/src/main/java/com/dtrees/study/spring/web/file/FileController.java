package com.dtrees.study.spring.web.file;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by keithl on 2017/11/30.
 */
@Controller
public class FileController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){
        // 将文件写进磁盘
        String filePath = "/temp/"+file.getOriginalFilename();
        try {
            FileUtils.writeByteArrayToFile(new File(filePath),file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "wrong";
    }
}
