package com.test.controller;

import com.test.pojo.Uegs;
import com.test.dao.DBOper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name="login",urlPatterns = "/test/login")
public class Login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost( req,resp );
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType( "text/html;charset=utf-8" );
        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "UTF-8" );
        String username = req.getParameter( "username" );
        String password = req.getParameter( "password" );
        PrintWriter out = resp.getWriter();
        Uegs uegs = new Uegs();

        try {
            uegs = new DBOper().login( uegs );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.print("<script language='javascript'>alert('登录成功')</script>");
        out.print("<script>window.location.href='/dep/logintowea.jsp'</script>");
    }
}


