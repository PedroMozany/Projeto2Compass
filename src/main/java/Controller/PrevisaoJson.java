package Controller;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PrevisaoJson", value = "/PrevisaoJson")
public class PrevisaoJson extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("json");
        String nome = request.getParameter("name");
        String tempo = request.getParameter("var");



        Gson gson = new Gson();
        String city = gson.toJson(nome);
        String json = gson.toJson(tempo);
        response.setContentType("application/json");
        response.getWriter().print(city);
        response.getWriter().print(json);


    }
}
