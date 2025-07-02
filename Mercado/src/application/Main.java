package application;
	
import java.sql.Connection;

import connectionFactory.ConnectionDataBase;
import dao.ClienteDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Cliente;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		 cliente.setNomeCliente("Pedro alvarez");
		 cliente.setCpfCliente("85295175236");
		 cliente.setDataNasc("1999-01-28");
		 cliente.setTelefone("63992000000");
		 cliente.setEndereco("Rua dos bobos,numero 0");
		 cliente.setEmail("pedroalvarez@gmail.com");
		 clienteDAO.create(cliente);
		launch(args);
	}
}
