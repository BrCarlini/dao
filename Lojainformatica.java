/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author bruno
 */
public class Lojainformatica {

    static final String URL = "jdbc:mysql://localhost:3306/lojainformatica";
    static final String USUARIO = "root";
    static final String SENHA = "";

    public static void main(String[] args) {
        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            statement = conexao.createStatement();

            String consultaSQL = "SELECT marca FROM computador";
            resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {
                String dado = resultSet.getString("marca");
                System.out.println("Dado: " + dado);
            }

            // Faça aqui o que precisar com a conexão
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

}
