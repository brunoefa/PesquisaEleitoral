package com.pesquisaeleitoral.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pesquisaeleitoral.dao.CandidatoDao;
import com.pesquisaeleitoral.model.Candidato;

@WebServlet("/candidato")
public class CandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CandidatoDao dao;
       
    public CandidatoController() {
        super();
        dao = new CandidatoDao();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else if ("salvar".equals(acao)) {
			salvar(request, response);
		} else if ("deletar".equals(acao)) {
			deletar(request, response);
		} else if ("votar".equals(acao)) {
			votar(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		}else {
			listar(request, response);
		}
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Candidato candidato = obterCandidato(request); 
		dao.deletar(candidato.getId());
		listar(request, response);
	}

	protected void salvar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Candidato candidato = obterCandidato(request);
		if (candidato.getId() == null) {
			dao.salvar(candidato);
		}else {
			dao.editar(candidato);
		}
		listar(request, response);
	}
	
	protected void votar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Candidato candidato = obterCandidato(request);
		dao.registrarVoto(candidato);
		listar(request, response);
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Candidato> listaCandidatos = dao.buscarTodos();
		Integer total = dao.obterTotalDeVotos();
		request.setAttribute("listaCandidatos", listaCandidatos);
		request.setAttribute("total", total);
		encaminharRequisicao("/listagem.jsp", request, response);
	}
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao("/formulario.jsp", request, response);
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato candidato = new Candidato();
		candidato = obterCandidato(request);
		candidato = dao.buscar(candidato.getId());
		request.setAttribute("candidato", candidato);
		encaminharRequisicao("/formulario.jsp", request, response);
	}
	
	private Candidato obterCandidato(HttpServletRequest request)  throws ServletException, IOException {
		Integer id = null;
		String stringId = request.getParameter("id");
		if (stringId != null && !stringId.isEmpty()) {
			id = Integer.parseInt(stringId);
		}
		String nome = request.getParameter("nome");
		
		String foto = request.getParameter("foto");
		String partido = request.getParameter("partido");
		String numero = request.getParameter("numero");
		String cargo = request.getParameter("cargo");
		
		Boolean status = Boolean.FALSE;
		String stringStatus = request.getParameter("status");
		if (stringStatus != null && !stringStatus.isEmpty()) {
			status = Boolean.parseBoolean(stringStatus);
		}
		return new Candidato(id, nome, foto, partido, numero, cargo, status);
	}
	
	private void encaminharRequisicao(String recurso, HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(recurso);
		rd.forward(request, response);
	}
}
