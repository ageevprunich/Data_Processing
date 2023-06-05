package Servlets;

import Entity.Refugees;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc1.SQLcrud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    LabCRUDInterface<Refugees> crud = new SQLcrud();

    List<Refugees> list = new ArrayList<>();

    public void init(ServletConfig config) throws ServletException {
        crud = new SQLcrud();

    }
    public void destroy() {
        try {
            ((SQLcrud) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        response.getWriter().println(crud.read());
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Refugees refugees = HelpJson.refugeesParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.update(id, refugees);
        doGet(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Refugees refugees = HelpJson.refugeesParse(request);
        crud.create(refugees);
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
        doGet(request, response);
    }

}