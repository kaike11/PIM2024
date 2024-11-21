package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLServer {

	public static Connection conectar() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Fazenda_Maria;encrypt=true;trustServerCertificate=true";
		String usuario = "sa"; 
        String senha = "fazendamaria123";
        	
        try {
       
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados", e);
        	}
		}
	}

