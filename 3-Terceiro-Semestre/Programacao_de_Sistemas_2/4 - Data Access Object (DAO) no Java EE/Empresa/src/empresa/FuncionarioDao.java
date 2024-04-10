import .sql.*;
import java.util.ArrayList;

public class FuncionarioDao {
    private Connection connection;
    public FuncionarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void addFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionario VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setLong(1, funcionario.getNumat());
            stmt.setString(2, funcionario.getNome());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setString(4, funcionario.getSexo()+"");
            stmt.setInt(5, funcionario.getNdepto());
            stmt.setLong(6, funcionario.getNsuper());
            
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList <Funcionario> getLista(){
        String sql = "SELECT * FROM funcionario";
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setNumat(rs.getInt("numat"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSexo(rs.getString("sexo").charAt(0));
                funcionario.setNdepto(rs.getInt("ndepto"));
                funcionario.setNsuper(rs.getInt("nsuper"));
               
                funcionarios.add(funcionario);             
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }
}
