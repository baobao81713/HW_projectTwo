package com.netease;
//导入相关log4j的jar包
import org.apache.log4j.Logger;  
import org.apache.log4j.PropertyConfigurator; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoodlesServlet extends HttpServlet {
	
	private static Logger mylog=Logger.getLogger(NoodlesServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter writer = response.getWriter();
        String vegetable = request.getParameter("vegetable");
        if (vegetable == null) {
            vegetable = "Tomato";
        }

        writer.println("<html><body>");
        writer.println("<h1> Noodles with " + vegetable + "</h1>"); 
        writer.println("</body></html>");
		//用ClassLoader.getSystemResource获取log4j.properties绝对路径
//		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        PropertyConfigurator.configure("config/log4j.properties"); 
        mylog.debug( vegetable );
    }
	
}
