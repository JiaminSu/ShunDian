package com.lanou.service.impl;

import com.lanou.dao.DiZhiMapper;
import com.lanou.entity.DiZhi;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("diZhiService")
public class DiZhiServiceImpl  implements DiZhiService{
    @Autowired
    private DiZhiMapper diZhiMapper;

    public List<DiZhi> findDiZhi(DiZhi diZhi){
        return diZhiMapper.findDiZhi(diZhi);
    }
    public String findSXQ(Integer cityid){
        return diZhiMapper.findSXQ( cityid);
    }
//    //三级联动功能模块
//    public DiZhi findDiZhicityid(int cityid) {
//        return diZhiMapper.findDiZhicityid(cityid);
//    }
}
