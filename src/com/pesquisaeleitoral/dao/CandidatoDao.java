package com.pesquisaeleitoral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pesquisaeleitoral.model.Candidato;

public class CandidatoDao {
	private Connection connection;

	public CandidatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void deletar(Integer id) {
		String sql = "delete from candidato where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void editar(Candidato candidato) {
		String sql = "update candidato set nome = ?, foto = ?, partido = ?, cargo = ?, numero = ?, status = ? where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setString(1, candidato.getNome());
			stm.setString(2, candidato.getFoto());
			stm.setString(3, candidato.getPartido());
			stm.setString(4, candidato.getCargo());
			stm.setString(5, candidato.getNumero());
			stm.setBoolean(6, candidato.getStatus());
			stm.setInt(7, candidato.getId());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void salvar(Candidato candidato) {
		String sql = "insert into candidato (nome, foto, partido, cargo, numero, status) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setString(1, candidato.getNome());
			stm.setString(2, candidato.getFoto());
			stm.setString(3, candidato.getPartido());
			stm.setString(4, candidato.getCargo());
			stm.setString(5, candidato.getNumero());
			stm.setBoolean(6, candidato.getStatus());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void registrarVoto(Candidato candidato) {
		String sql = "update candidato set votos = votos + 1 where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setInt(1, candidato.getId());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public Integer obterTotalDeVotos() {
		Integer total = 0;
		String sql = "select sum(votos) as total from candidato";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				total = rs.getInt("total");
			}
			rs.close();
			stm.close();
			
			return total;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public Candidato buscar(Integer id) {
		Candidato candidato = new Candidato();
		String sql = "select * from candidato where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				candidato = preencheCandidato(rs);
			}
			rs.close();
			stm.close();
			
			return candidato;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public List<Candidato> buscarTodos() {
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		String sql = "select * from candidato order by nome";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Candidato candidato = preencheCandidato(rs);
				listaCandidatos.add(candidato);
			}
			
			rs.close();
			stm.close();
			
			return listaCandidatos;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	private Candidato preencheCandidato(ResultSet rs) throws SQLException {
		Candidato candidato = new Candidato();
		
		candidato.setId(rs.getInt("id"));
		candidato.setNome(rs.getString("nome"));
		candidato.setFoto(rs.getString("foto"));
		candidato.setCargo(rs.getString("cargo"));
		candidato.setPartido(rs.getString("partido"));
		candidato.setNumero(rs.getString("numero"));
		candidato.setVotos(rs.getInt("votos"));
		
		return candidato;
	}
	
}
