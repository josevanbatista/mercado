package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	
	public ArrayList<Cliente> read(){
		Connection con = ConnectionDataBase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = new ArrayList<>();
	
		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNomeCliente(rs.getString("idCliente"));
				cliente.setNomeCliente(rs.getString("nomeCliente"));
				cliente.setCpfCliente(rs.getString("cpfCliente"));
				cliente.setDataNasc(rs.getString("dataNasc"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(" Erro ao ler os dados", e);
		}finally {
			ConnectionDataBase.closeConnection(con, stmt, rs);
		}
		return clientes;
	}

}
