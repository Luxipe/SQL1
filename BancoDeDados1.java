    package com.messi;

import java.sql.*;

public class BancoDeDados1 {
    public static void main(String[] args) {
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
            // Insere a primeira moeda
            String moeda = "Dolar";
            Double valor = 5.00;
            String sql = "INSERT INTO cotacao_moeda (moeda, valor) VALUES (?,?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, moeda);
            statement.setDouble(2, valor);
            statement.executeUpdate();

            // Insere a segunda moeda
            moeda = "Euro";
            valor = 5.26;
            statement.setString(1, moeda);
            statement.setDouble(2, valor);
            statement.executeUpdate();

            // Insere o cadastro do usuário
            String nome = "Gustavo De Oliveira";
            String email = "nomegamer24@gmail.com";
            String telefone = "(11) 99999-9999";
            sql = "INSERT INTO cadastro_usuario (nome, email, telefone) VALUES (?, ?, ?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, telefone);
            statement.executeUpdate();

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Moeda e usuário adicionados com sucesso!");
            } else {
                System.out.println("Erro ao inserir moeda ou usuário.");
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao exercicios2: " + e.getMessage());
        }
    }
}
