package com.test.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet(name = "TestHttpURLConnrction", urlPatterns = "/test/TestHttpURLConnrction")
public class TestHttpURLConnrction extends HttpServlet {
    public static void main(String[] args) {

    }
    public StringBuffer methodGet(String urlString) {
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL( urlString );
            //获取connection对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();//
            connection.setConnectTimeout( 5000 );//连接超时
            connection.setReadTimeout( 5000 );//读取内容超时
            //设置请求方式
            connection.setRequestMethod( "GET" );
            //连接
            connection.connect();
            //获取响应码
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                //获取相应流
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream, "UTF-8" ) );
                String line;
                while((line = bufferedReader.readLine())!=null){
                    sb.append( line ).append( "\n" );
                }
                inputStream.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  String url="";
        String url="https://www.sojson.com/open/api/weather/json.shtml?city=%E9%A9%AC%E9%9E%8D%E5%B1%B1";
        //String url="https://www.bilibili.com/";
        // String url="http://192.168.1.110:8080/servlet/json";
        TestHttpURLConnrction httpURLConnrction = new TestHttpURLConnrction();
        StringBuffer sb = httpURLConnrction.methodGet( url );
        System.out.println(sb);
        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "utf-8" );

        resp.setContentType( "application/json" );
        //允许跨域请求
        resp.setHeader( "Access-Control-Allow-Origin","*" );
        resp.setHeader( "Access-Control-Allow-Methods","*" );
        resp.setHeader( "Access-Control-Max-Age","3600" );
        resp.setHeader( "Access-Control-Allow-Credentials","false" );
        PrintWriter out = resp.getWriter();
      //  System.out.println();
        out.println( sb );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost( req, resp );
    }
}
