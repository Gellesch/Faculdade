import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/empresa",
                    "app",
                    "app");
            return conexao;
        } catch (SQLException ex) {
            System.out.println(" Falha na conexão com o BD! ");
        }
        return null;
    }
}
