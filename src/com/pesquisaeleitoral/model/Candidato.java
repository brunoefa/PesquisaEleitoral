package com.pesquisaeleitoral.model;

public class Candidato {
	private Integer id;
	private String nome;
	private String foto;
	private String partido;
	private String numero;
	private String cargo;
	private Integer votos;

	public Candidato(Integer id, String nome, String foto, String partido, String numero, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.partido = partido;
		this.numero = numero;
		this.cargo = cargo;
	}
	
	public Candidato() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getVotos() {
		return votos;
	}

	public void setVotos(Integer votos) {
		this.votos = votos;
	}
}
