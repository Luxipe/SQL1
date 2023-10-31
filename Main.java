package com.produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    // Informações de conexão
    private static final String host = "localhost";
    private static final String database = "cadastro_produto";
    private static final String usuario = "root";
    private static final String senha = "";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"+host + ":3306/" + database, usuario, senha)) {
            String nome = "Produto de Teste";
            String descricao = "Descrição do Produto de Teste";
            double preco = 10.0;
            int quantidade = 100;
            String dataCadastro = "2023-10-27";

            String sql = "INSERT INTO produtos (nome, descricao, preco, quantidade, data_cadastro) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setDouble(3, preco);
            stmt.setInt(4, quantidade);
            stmt.setString(5, dataCadastro);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Produto inserido com sucesso!");
            } else {
                System.out.println("Não foi possível inserir o produto.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " +
            e.getMessage());
        }
    }
}