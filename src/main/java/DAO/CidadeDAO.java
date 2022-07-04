package DAO;

import model.Cidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDAO {

    private Connection connection;

    public CidadeDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Cidades cidades) throws SQLException {
        String query = "INSERT INTO CIDADE(NOME,LATITUDE,LONGITUDE) VALUE (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, cidades.getNome());
            ps.setString(2, cidades.getLatitude());
            ps.setString(3, cidades.getLongitude());
            ps.execute();
        }
    };

    public Cidades buscar(String nome) throws SQLException {
        String query = "SELECT NOME,LATITUDE,LONGITUDE FROM CIDADE WHERE NOME = ?";
        Cidades cidades;
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,nome);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                if(rs.next()){
                    cidades = new Cidades(rs.getString(1),rs.getString(2),rs.getString(3));
                }else{
                    cidades = null;
                }
            }
        }
        return cidades;
    }


}
