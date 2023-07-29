package com.pet.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Controller
public class FileController {

    @Value("${download}")
    private String path;

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename, HttpServletRequest request) throws IOException {
        // 指定从哪个目录下下载文件
//        String path = request.getSession().getServletContext().getRealPath("/img/");
        System.out.println(path);
        // 创建需要下载的文件对象
        File file = new File(path + File.separator + filename);
        // 对文件名进行编码
        filename = this.getFilename(filename, request);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的方式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    /**
     * 根据浏览器的不同进行编码设置，返回编码后的文件名
     */
    public String getFilename(String filename, HttpServletRequest request) throws UnsupportedEncodingException {
        // 若为IE浏览器，则使用UTF-8编码
        String[] IEKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEKeyWords) {
            if (userAgent.contains(keyWord)) {
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        // 非IE浏览器，返回ISO-8859-1编码
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }
}
