package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectionFactory.ConnectionDataBase;
import model.Cliente;

public class ClienteDAO {
	
	public void create(Cliente cliente) {
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO Cliente values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getDataNasc());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getEndereco());
			stmt.setString(6, cliente.getEmail());
			
			stmt.execute();
			System.out.println("Cliente cadastro !");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Cadastrar !", e);
		}finally {
			ConnectionDataBase.closeConnection(con,stmt);
		}
	}

}
