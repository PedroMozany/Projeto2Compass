package Controller;

import DAO.CidadeDAO;
import connection.ConnectionFactory;
import model.Cidades;
import model.Data;
import model.Temperatura;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "receberDados", value = "/previsao")
public class VerificarPrevisão extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        List<Data> listData = new LinkedList<>();
        Data data = new Data();
        Cidades cidade;
        Temperatura previsao;

        try (Connection connection = new ConnectionFactory().initConexao()) {
            CidadeDAO cidadeDAO = new CidadeDAO(connection);
            cidade = cidadeDAO.buscar(nome);
            previsao = new PrevisaoTempo().previsao(cidade.getLatitude(), cidade.getLongitude(), data.getUnix());
            data.setPrevisao(previsao);
            listData.add(data);

            for (int i = 0; i < 5; i++) {
                Date date = data.periodo();
                String unix = data.unixPorPeriodo(date);
                previsao = new PrevisaoTempo().previsao(cidade.getLatitude(), cidade.getLongitude(), unix);
                listData.add(new Data(date, unix, previsao));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        request.setAttribute("cidade", cidade);
        request.setAttribute("periodo", listData);
        request.getRequestDispatcher("WEB-INF/views/MostrarPrevisao.jsp").forward(request, response);
    }


}
