module Mercado {
	requires javafx.controls;
	requires jdk.jdi;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
