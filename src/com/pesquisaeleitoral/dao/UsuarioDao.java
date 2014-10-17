package com.pesquisaeleitoral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pesquisaeleitoral.model.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Usuario usuario) {
		String sql = "insert into usuario (nome, email, senha, status) values (?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setBoolean(4, usuario.getStatus());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	public Usuario buscar(String email) {
		Usuario usuario = new Usuario();
		String sql = "select * from usuario where LOWER(email) = LOWER(?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, email);
			
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				usuario = preencheUsuario(rs);
			}
			rs.close();
			stm.close();
			
			return usuario;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	public Usuario buscar(Integer id) {
		Usuario usuario = new Usuario();
		String sql = "select * from usuario where id = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				usuario = preencheUsuario(rs);
			}
			rs.close();
			stm.close();
			
			return usuario;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	private Usuario preencheUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("id"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEmail(rs.getString("email"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setStatus(rs.getBoolean("status"));
		
		return usuario;
	}
}
