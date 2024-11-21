package teste;

import conexao.ConexaoSQLServer;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) {
		try {
			
			Connection conn = ConexaoSQLServer.conectar();
			System.out.println("Conexao com o banco foi um sucesso");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar conectar no banco de dados: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
