package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.service.GoodsTypeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/13.
 */
@Controller
@RequestMapping("/")
public class UploadController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @RequestMapping("/upload.do")
    public void upload(HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
       List url = goodsTypeService.findLun();
        List lubotus = new ArrayList();
       for (int i=0;i<url.size();i++){
           List lubotu = new ArrayList();
           String urls =(String) url.get(i);
           String[] ss = urls.split("\\/");
           String[] ss1 = ss[1].split("\\.");
           System.out.println("iiii:"+ss1[0]);
           Integer id = Integer.parseInt(ss1[0]);
           lubotu.add(id);
           lubotu.add(urls);
           lubotus.add(lubotu);
           System.out.println(lubotus);
       }
        map.put("lunbotu",lubotus);
        FastJson_All.toJson(map,response);
    }
    @RequestMapping("/insertupload.do")
    public void upload(@RequestParam("myFile") MultipartFile file,HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String url = goodsTypeService.upload();
        String[] ss = url.split("\\/");
        String[] ss1 = ss[1].split("\\.");
        Integer i = Integer.parseInt(ss1[0]);
        System.out.println(i);
        i=i+1;
        System.out.println(i);
        File files = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/"+i+".jpg");
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),files);
            String url2 = "lunbotu/"+i+".jpg";
            goodsTypeService.insertLun(url2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
    @RequestMapping("/updateupload.do")
    public void updateupload(@RequestParam("myFile") MultipartFile file,HttpServletResponse response,int name) {
        Map<String, Object> map = new HashMap<String, Object>();
        File files = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/"+name+".jpg");
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),files);

        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
    @RequestMapping("/deleteupload.do")
    public void deleteupload(HttpServletResponse response,int name) {
        Map<String, Object> map = new HashMap<String, Object>();
        File files = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/"+name+".jpg");
        files.delete();
        String  url = "lunbotu/"+name+".jpg";
        goodsTypeService.deleteLun(url);
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
}


