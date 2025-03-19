package lab04;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Facilitador{
	 private PreparedStatement obterContasStm = null;
	 private PreparedStatement adicionarStm = null;
	 private PreparedStatement apagarStm = null;
	 private PreparedStatement atualizarStm = null;
	 
	 public Facilitador(String url) throws SQLException{
		 Connection conexao  = DriverManager.getConnection(url);
	     obterContasStm = conexao.prepareStatement("SELECT * FROM contas");
	     adicionarStm = conexao.prepareStatement("INSERT INTO contas VALUES (?,?)"); 
	     apagarStm = conexao.prepareStatement("DELETE FROM contas WHERE nro_conta = ?");
	     atualizarStm = conexao.prepareStatement("UPDATE contas SET saldo=? WHERE nro_conta=?");	 
	 }
	 
	 
	 
	 
	public List<Conta> receberContas() throws SQLException{
		List<Conta> contas = new ArrayList<>();
        ResultSet rs = obterContasStm.executeQuery(); 
        while (rs.next()) {
            long numero = rs.getLong("nro_conta");
            double saldo = rs.getDouble("saldo");
            Conta c = new Conta(numero, saldo);
            contas.add(c);
        }
        return contas;
	}
	
	public boolean adicionarConta(Conta c) throws SQLException {
			adicionarStm.setLong(1, c.getNmr());
	        adicionarStm.setDouble(2, c.getSaldo());
	        int ret = 0;
	        try {
	            ret = adicionarStm.executeUpdate();
	        } catch(SQLException ex) {}
	        return ret == 1;
	}
	
	public boolean apagarConta(long n) throws SQLException {
		apagarStm.setLong(1, n);
        int ret = 0;
        try {
            ret = apagarStm.executeUpdate();
        } catch(SQLException ex) {}
        return ret == 1; 
	}
	
	public boolean alterarConta(Conta c) throws SQLException {
			atualizarStm.setDouble(1, c.getSaldo());
	        atualizarStm.setLong(2, c.getNmr());
	        int ret = 0;
	        try {
	            ret = atualizarStm.executeUpdate();
	        } catch(SQLException ex) {}
	        return ret == 1;
	}
	
	
	
	
}
