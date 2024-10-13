import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AplicacaoAcessoBd {
    public static void main(String[] args) {
        try {
            Connection conn; // criando um objeto do tipo connection chamado conn
            Statement st; // criando um objeto do tipo Statement chamado st para execução de comando SQL

            // Carrega o driver do MySQL (Certifique-se de que o JAR está na classpath)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "abcd1234");
            st = conn.createStatement();
            
            System.out.println("Conexão bem-sucedida!");

            // Fecha a conexão
            conn.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("driver não está disponível para acesso ou não existe: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando inválida: " + ex.getMessage());
        }
    }     
}

