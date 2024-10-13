/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oluca
 */
public class FuncionarioDAO {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() throws ClassNotFoundException {
        try {
            // Verifica se o driver do MySQL está presente no classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Tentando conectar...");

            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo");
            System.out.println("Conexão realizada com sucesso!");
            return true;
        } catch (SQLException ex) {
            // Mensagem caso o driver JDBC não esteja disponível ou ocorra erro de conexão
            System.out.println("Falha na conexao " + ex.getMessage());
            return false;
        }
    }

    public int salvar(Funcionario func) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO funcionarios VALUES(?,?,?,?,?)");
            st.setString(1, func.getMatricula());
            st.setString(2, func.getNome());
            st.setString(3, func.getCargo());
            st.setDouble(4, func.getSalario());
            st.setDate(5, func.getDatanasc());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar" + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public boolean excluir(String matricula) {
        try {
            st = conn.prepareStatement("DELETE INTO funcionarios VALUES(?,?,?,?,?)");
            st.setString(1, matricula);
            st.executeUpdate();
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public int atualizar(Funcionario func) {
        int status;
        try {
            st = conn.prepareStatement("UPDATE funcionarios SET nome = ?, cargo = ?, salario = ?, datanasc = ? WHERE matricula ");
            st.setString(1, func.getNome());
            st.setString(2, func.getCargo());
            st.setDouble(3, func.getSalario());
            st.setDate(4, func.getDatanasc());
            st.setString(5, func.getMatricula());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar" + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public Funcionario consultar(String matricula){
        try{
            Funcionario funcionario = new Funcionario();
            st = conn.prepareStatement("SELECT * from funcionarios WHERE matricula = ? ");
            st.setString(1, matricula);
            rs = st.executeQuery();
            
            // Verificar se consulta retornou resultado
            if(rs.next()){
                funcionario.setMatricula(matricula);
                funcionario.setNome("nome");
                funcionario.setCargo("cargo");
                funcionario.setSalario(0);
                return funcionario;                
            }else {
                return null;
            }
        } catch(SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Funcionario> listagem(String filtro){
        
        String sql = "select * from funcionarios";
        
        if (!filtro.isEmpty()){
            sql = sql + "where nome like ?";
        } 
        
        try {
            st = conn.prepareStatement(sql);
            
            if(!filtro.isEmpty()){
                st.setString(1, "%" + filtro + "%");
            }
            
            rs = st.executeQuery();
            List<Funcionario> lista = new ArrayList<>();
        }
    }

    public void desconectar() {
        try {
            // Verifica se a conexão está aberta antes de fechar
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão encerrada com sucesso.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar: " + ex.getMessage());
        }
    }

}
