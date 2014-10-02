package com.pesquisaeleitoral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pesquisaeleitoral.model.Candidato;

public class CandidatoDao {
	private Connection connection;

	public CandidatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Candidato candidato) {
		String sql = "insert into candidato (nome, foto, partido, cargo, numero) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setString(1, candidato.getNome());
			stm.setString(2, candidato.getFoto());
			stm.setString(3, candidato.getPartido());
			stm.setString(4, candidato.getCargo());
			stm.setString(5, candidato.getNumero());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
}
