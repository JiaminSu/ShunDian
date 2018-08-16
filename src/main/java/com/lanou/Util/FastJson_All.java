package com.lanou.Util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lanou on 2017/12/5.
 */
public class FastJson_All {
    public static void toJson(Object obj,HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("utf-8");
        String jsonStr = JSON.toJSONString(obj);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.write(jsonStr);
        out.flush();
    }
}
