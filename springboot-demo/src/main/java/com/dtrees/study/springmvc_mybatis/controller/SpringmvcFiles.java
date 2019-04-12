package com.dtrees.study.springmvc_mybatis.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * project:java-code
 * file:SpringmvcFiles
 * package:com.dtrees.springmvc_mybatis.controller
 * date:2019/4/4 6:03 PM
 * author:keithl
 */
public class SpringmvcFiles {

    // SpringMVC文件上传下载以及拦截器
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("desc") String desc,
                         @RequestParam("file")MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()){
            String path = request.getServletContext().getRealPath("/images/");
            String fileName = file.getOriginalFilename();
            File filePath = new File(path, fileName);
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            // 将上传的文件保存到一个指定的文件中
            file.transferTo(new File(path + File.separator + fileName));
            return "upload file success";
        }
        return "upload file fail";
    }


    // 封装成对象上传文件
    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String uploadModel(HttpServletRequest request,
                              @ModelAttribute UserFile userFile, Model model) throws IOException{
        if (userFile.getFile() != null && !userFile.getFile().isEmpty()){
            String path = request.getServletContext().getRealPath("/images/");
            String fileName = userFile.getFile().getOriginalFilename();
            File filePath = new File(path, fileName);
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            // 将上传的文件保存到一个指定的文件中
            userFile.getFile().transferTo(new File(path + File.separator + fileName));
            model.addAttribute("user", userFile);
            return "upload file success";
        }
        return "upload file fail";
    }

    // 文件下载
    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request,
                                               @RequestParam("filename") String fileName,
                                               Model model)throws IOException{
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + fileName);
        // 下载显示的文件名称，解决中文乱码问题
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        // 通知浏览器以attachment方式打开图片
        HttpHeaders headers = new HttpHeaders();
        headers.add("attachment", downloadFileName);
        // 以二进制流的方式进行下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 返回响应的201状态
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}

class UserFile implements Serializable {
    private String desc;
    private MultipartFile file;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}