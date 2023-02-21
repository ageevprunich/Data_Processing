package Servlets;

import Entity.Services;
import com.google.gson.Gson;
import crud.Lab2CrudI;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    ServletConfigI servletConfig;
    Lab2CrudI lab2Crud;

    public Servlet (){
        super();
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Services documents = new Services("ID Card", 14, "assets/doc.png");

        ArrayList<Services> data =new ArrayList<Services>();
        data.add(documents);

        String answer = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("aplication/json");
        response.setCharacterEncoding("UTF-8");
        out.println(answer);
        out.flush();
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int timeToWait = Integer.parseInt(request.getParameter("timeToWait"));
        String imag= request.getParameter("imag");
        lab2Crud.update(new Services(name,timeToWait,imag));
    }
}
