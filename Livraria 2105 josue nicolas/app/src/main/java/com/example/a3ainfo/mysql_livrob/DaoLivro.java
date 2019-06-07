//Data access object

package com.example.a3ainfo.mysql_livrob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLivro {
    Connection connection;

    DaoLivro(){
        FabricaConexao fabricaConexao = new FabricaConexao();
        connection = fabricaConexao.conectar();
    }

    public String inserir(DtoLIvro dtolivro){
        String comando = "insert into tb_livro values(null, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(comando);
            ps.setString(1, dtolivro.nome);
            ps.setString(2, dtolivro.autor);
            ps.setString(3, dtolivro.genero);
            ps.execute();

            return "inserido";

        } catch (SQLException e) {
            e.printStackTrace();

            return "Deu xabu. Erro: "+e.toString();
        }


    }

    public ArrayList<DtoLIvro> consultar(){
        String comando = "select * from tb_livro";
        PreparedStatement ps;
        ArrayList<DtoLIvro> listLivro = new ArrayList<>();
        try {
            ps = connection.prepareStatement(comando);
            ResultSet resultado  = ps.executeQuery();
            while (resultado.next()){
                DtoLIvro dtoLIvro = new DtoLIvro();
                dtoLIvro.nome = resultado.getString("nome");
                dtoLIvro.autor = resultado.getString("autor");
                dtoLIvro.genero = resultado.getString("genero");

                listLivro.add(dtoLIvro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listLivro;
    }

}
