package teatroapp.infra;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexao {

	public void conectar() {

		try {
			
		    String dbUrl = "jdbc:postgresql://ec2-184-73-249-56.compute-1.amazonaws.com:5432/d6sgru75jnohou?user=gfmzjicbfwafoy&password=7cb3b12770674ff3546f5e60bce56fada3f6f376ef0e6d6e38bb332a6b8d2c02&ssl=true";
		    
		    Connection con;

		    con = DriverManager.getConnection(dbUrl, "gfmzjicbfwafoy", "7cb3b12770674ff3546f5e60bce56fada3f6f376ef0e6d6e38bb332a6b8d2c02");

			System.out.println("Conexão realizada com sucesso.");

			Statement stm = con.createStatement();

			// stm.executeQuery("INSERT INTO teste VALUES (1,'Cynthia')");

			//stm.executeUpdate("INSERT INTO teste VALUES (1,'Cynthia')");
			// Editado 21/09/2011 para correção: executeQuery é usado para pesquisa,
			// executeUpdate deve ser usado para inserir
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
