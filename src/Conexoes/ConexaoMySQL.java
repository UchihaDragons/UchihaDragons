
package Conexoes;

import com.sun.jdi.connect.spi.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Logger;


public class ConexaoMySQL {

    
        private Connection conn = null; //variável de conexão com o banco
        private Statement statement; //variável de manipulação do SQL
        private ResultSet resultSet;
        
        private String servidor = "localhost:3306";
        private String nomeDoBanco = "Loja";
        private String usuario = "root";
        private String senha = "Afgksda998305186";
        
        
        
        public ConexaoMySQL(){
            
        }
        public ConexaoMySQL(String servidor, String nomeDoBanco, String usuario, String senha){
            this.servidor = servidor;
            this.nomeDoBanco = nomeDoBanco;
            this.usuario = usuario;
            this.senha = senha;
            
        }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
        
        
        
        
        public void ConectaBanco(){
            
        try { 
            
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + nomeDoBanco, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);
        }
            
            
        }
        
            public boolean fechaBanco(){
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao " + e.getMessage());
            return false;
        }
    }
            public int insertSQL(String SQL){                       
                
            int status = 0;
        try {

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(SQL);            
        
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }

            }

        
}
