package com.lvshijie.servlet;

import com.lvshijie.util.CheckUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WechatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(111);
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        CheckUtil.checkSignature(signature,timestamp, nonce);
        // if (CheckUtil.checkSignature(signature,timestamp, nonce)) {
        PrintWriter out=resp.getWriter();
        out.print(echostr);
        //}

    }
}
