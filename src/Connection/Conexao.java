/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Freire
 */
public class Conexao {

    private Connection conn = null;

    public void myData() {

        this.getConnection();

    }

    public Connection getConnection() {

        //Inicia a conexão no banco 
        try {

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/thorandloki", "root", "");

            System.out.println("Conexão Muito bem sucedida!");

            return conn;

        } catch (SQLException e) {

            System.out.println("Conexão mal sucedida!" + e.getMessage());
            JOptionPane.showMessageDialog(null, e, "Banco de dados não está online! " + e.getMessage(), 0);

        }

        return null;

    }

    public void closeConnection() {

        if (conn != null) {
            
            
            try {

                conn.close();

            } catch (SQLException e) {

                System.out.println("Erro no fechamento da conexão: " + e.getMessage());

            }

        }

    }

    public ResultSet select(String rawQuery) {

        this.getConnection();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(rawQuery);
            System.out.println("Query verify:" + rawQuery);
            return rs;

        } catch (SQLException e) {

            System.out.println("Erro na seleção das informações:" + e.getMessage());
            System.out.println("Query verify:" + rawQuery);

        }

        return null;

    }

    public void query(String rawQuery) {

        this.getConnection();

        try {

            Statement stmt = conn.createStatement();
            stmt.execute(rawQuery);
            System.out.println("Query verify:" + rawQuery);
            
        } catch (SQLException e) {

            System.out.println("Erro na query das informações: " + e.getMessage());
            System.out.println("Query verify:" + rawQuery);

        }

    }

    public void delete(String tabela, int id) {

        this.getConnection();

        String sub = tabela.substring(0, 4);
        String rawQuery = " UPDATE " + tabela + " SET " + sub + "_status = 'off' WHERE " + sub + "_id = " + id;

        try {

            Statement stmt = conn.createStatement();
            stmt.execute(rawQuery);
            System.out.println("Query verify:" + rawQuery);
        } catch (SQLException e) {

            System.out.println("Erro na exclusão das informações:" + e.getMessage());
            System.out.println("Query verify:" + rawQuery);

        }

    }

    public ResultSet dataLoad(String tabela, int id) {

        this.getConnection();

        String sub = tabela.substring(0, 4);
        String rawQuery = " SELECT * FROM " + tabela + " WHERE " + sub + "_id = " + id;

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(rawQuery);
            System.out.println("Query verify:" + rawQuery);
            return rs;

        } catch (SQLException e) {

            System.out.println("Erro ao carregar das informações:" + e.getMessage());
            System.out.println("Query verify:" + rawQuery);

        }

        return null;

    }

    public int numRows(String rawQuery) {

        this.getConnection();

        int i = 0;

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(rawQuery);
            System.out.println("Query verify:" + rawQuery);
            while (rs.next()) {

                i++;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta das informações:" + e.getMessage());
            System.out.println("Query verify:" + rawQuery);

        }

        return i;

    }

}
