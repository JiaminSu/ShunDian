package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Floor;
import com.lanou.entity.FloorImage;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/13.
 */
@Controller
@RequestMapping("/")
public class FloorController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @RequestMapping("/insertfloor.do")
    public void upload(@RequestParam("myFile1") MultipartFile file1,@RequestParam("myFile2") MultipartFile file2,@RequestParam("myFile3") MultipartFile file3,@RequestParam("myFile4") MultipartFile file4,@RequestParam("myFile5") MultipartFile file5,@RequestParam("myFile6") MultipartFile file6,@RequestParam("myFile7") MultipartFile file7,@RequestParam("myFile8") MultipartFile file8,@RequestParam("myFile9") MultipartFile file9,HttpServletResponse response,String fName) {
        goodsTypeService.insertFloor(fName);
        Integer fId = goodsTypeService.findFloorFid(fName);
        Map<String, Object> map = new HashMap<String, Object>();
        File files1 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"1.jpg");
        File files2 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"2.jpg");
        File files3 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"3.jpg");
        File files4 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"4.jpg");
        File files5 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"5.jpg");
        File files6 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"6.jpg");
        File files7 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"7.jpg");
        File files8 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"8.jpg");
        File files9 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"9.jpg");
        for (int i=1;i<10;i++){
            String url = "lunbotu/floor"+fName+""+i+".jpg";
            goodsTypeService.insertFloorImage(url,fId);
        }
        try {
            FileUtils.copyInputStreamToFile(file1.getInputStream(),files1);
            FileUtils.copyInputStreamToFile(file2.getInputStream(),files2);
            FileUtils.copyInputStreamToFile(file3.getInputStream(),files3);
            FileUtils.copyInputStreamToFile(file4.getInputStream(),files4);
            FileUtils.copyInputStreamToFile(file5.getInputStream(),files5);
            FileUtils.copyInputStreamToFile(file6.getInputStream(),files6);
            FileUtils.copyInputStreamToFile(file7.getInputStream(),files7);
            FileUtils.copyInputStreamToFile(file8.getInputStream(),files8);
            FileUtils.copyInputStreamToFile(file9.getInputStream(),files9);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
    @RequestMapping("/updatefloor.do")
    public void updateupload(@RequestParam("myFile1") MultipartFile file1,@RequestParam("myFile2") MultipartFile file2,@RequestParam("myFile3") MultipartFile file3,@RequestParam("myFile4") MultipartFile file4,@RequestParam("myFile5") MultipartFile file5,@RequestParam("myFile6") MultipartFile file6,@RequestParam("myFile7") MultipartFile file7,@RequestParam("myFile8") MultipartFile file8,@RequestParam("myFile9") MultipartFile file9,HttpServletResponse response,int fId,String fName1) {
        Map<String, Object> map = new HashMap<String, Object>();
        String fName = goodsTypeService.findFloorfName(fId);
        goodsTypeService.updatefloor(fName1,fId);
        File files1 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"1.jpg");
        File files2 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"2.jpg");
        File files3 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"3.jpg");
        File files4 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"4.jpg");
        File files5 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"5.jpg");
        File files6 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"6.jpg");
        File files7 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"7.jpg");
        File files8 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"8.jpg");
        File files9 = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/floor"+fName+"9.jpg");
        try {
            FileUtils.copyInputStreamToFile(file1.getInputStream(),files1);
            FileUtils.copyInputStreamToFile(file2.getInputStream(),files2);
            FileUtils.copyInputStreamToFile(file3.getInputStream(),files3);
            FileUtils.copyInputStreamToFile(file4.getInputStream(),files4);
            FileUtils.copyInputStreamToFile(file5.getInputStream(),files5);
            FileUtils.copyInputStreamToFile(file6.getInputStream(),files6);
            FileUtils.copyInputStreamToFile(file7.getInputStream(),files7);
            FileUtils.copyInputStreamToFile(file8.getInputStream(),files8);
            FileUtils.copyInputStreamToFile(file9.getInputStream(),files9);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
@RequestMapping("/selectfloor.do")
public void selectfloor(HttpServletResponse response) {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Floor> floorList = this.goodsTypeService.findFloorX();
    map.put("floor",floorList);
    FastJson_All.toJson(map,response);
}
@RequestMapping("/selectfloorImage.do")
public void selectfloorImage(HttpServletResponse response,Integer floor_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String fName = goodsTypeService.findFloorfName(floor_id);
        List<FloorImage> floorImages = goodsTypeService.findFloorImageForfId(floor_id);
        map.put("fName",fName);
        map.put("floorImages",floorImages);
        FastJson_All.toJson(map,response);
    }
    @RequestMapping("/deletefloor.do")
    public void updatefloor(HttpServletResponse response,Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        goodsTypeService.deletefloor(id);
        map.put("result",true);
        FastJson_All.toJson(map,response);
    }
}


