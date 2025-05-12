package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kenzo
 */
public class Conexao {

    /**
     *
     * @return
     */
    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cenaflix", "root", "123456");
            System.out.println("Conectou com o banco de dados!");
        } catch (SQLException ex) {
            System.out.println("Erro: Não foi possivel se conectar no banco de dados!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Driver JDBC nao encontrado!.");
        }
        return conn;
    }

    /**
     *
     * @param conn
     */
    public void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Voce se desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel desconectar do banco dados.");
        }
    }
}
