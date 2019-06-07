package com.example.a3ainfo.mysql_livrob;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

     Connection conn = null;
     FabricaConexao() {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

         //BUROCRACIA: POR PADRÃO CONEXÕES COM INTERNET DEVEM SER FEITAS EM OUTRA THREAD(PROCESSO)
         //MAS PARA EVITAR A FADIGA, NÓS MUDAMOS ESSA POLÍTICA COM OS CÓDIGOS ABAIXO
         StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
         StrictMode.setThreadPolicy(policy);




     }

     public Connection conectar()
     {
         //Parametros getConn...(servidor/host/nome do db, usuario, senha)
         try {
             conn = DriverManager.getConnection("jdbc:mysql://db4free.net/jos_nic_livros","jos_nic", "12345678");
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return conn;
     }

     }



