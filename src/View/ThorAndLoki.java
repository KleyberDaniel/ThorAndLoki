/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package View;

import Connection.Conexao;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Guilherme Freire
 */
public class ThorAndLoki{

    public static void main(String[] args) throws SQLException {
    
        Home home = new Home();
        
        home.setVisible(true);

    }
    
    
    public void addIcon(JFrame frm){
        
        try{
            
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagens/tl.png"));
        
        }catch(Exception e){
            
            System.out.println("Imagem não encontrada: " + e);
            
        }
        
    }
    
    
    
}