package Servlets;

import Entity.Entity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Entity entity = new Entity("ID Card", 14, "You will get your ID Card after 14 days");

        ArrayList<Entity> data =new ArrayList<Entity>();
        data.add(entity);

        String answer = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("aplication/json");
        response.setCharacterEncoding("UTF-8");
        out.println(answer);
        out.flush();
    }
}
