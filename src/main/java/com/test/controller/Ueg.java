package com.test.controller;

import com.test.dao.DBOper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ueg", urlPatterns = "/test/ueg")

public class Ueg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "text/html" );
        PrintWriter out = resp.getWriter();
     //   Uegs uegs = new Uegs();
        String username = req.getParameter( "username" );
        String password = req.getParameter( "password" );
        /*uegs.setUsername( req.getParameter( "username" ) );
        uegs.setPassword(req.getParameter( "password" )  );*/
        /*List<Uegs> list = new ArrayList<Uegs>(  );
        list.add( uegs );*/
        boolean b = false;
         b = new DBOper().addUser( username,password );
        if(b) {
            out.println( "注册成功" );

            out.print("<script language='javascript'>alert('注册成功')</script>");
            out.print("<script>window.location.href='/login.html'</script>");

        }
        else
            out.println( "注册失败" );
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req, resp );
    }
}
