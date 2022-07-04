import DAO.CidadeDAO;
import connection.ConnectionFactory;
import model.Cidades;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class app {
    public static void main(String[] args) throws JSONException, IOException {
        String arq = "baseDados";

        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] items = linha.split(",");
                try (Connection connection = new ConnectionFactory().initConexao()) {
                    CidadeDAO cidadeDAO = new CidadeDAO(connection);
                    cidadeDAO.salvar(new Cidades(items[0], items[1], items[2]));
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
                linha = br.readLine();

            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!" + e.getMessage());
        }
    }

}
