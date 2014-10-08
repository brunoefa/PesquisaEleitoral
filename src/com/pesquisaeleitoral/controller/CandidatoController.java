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

/**
 * Servlet implementation class CandidatoController
 */
@WebServlet("/candidato")
public class CandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CandidatoDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		}else {
			listar(request, response);	
		}
	}

	private void deletar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Candidato candidato = obterCandidato(request); 
		dao.deletar(candidato.getId());
		listar(request, response);
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Candidato candidato = obterCandidato(request); 
		dao.salvar(candidato);
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Candidato> listaCandidatos = dao.buscarTodos();
		request.setAttribute("listaCandidatos", listaCandidatos);
		encaminharRequisicao("/listagem.jsp", request, response);
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao("/cadastro.jsp", request, response);
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
		return new Candidato(id, nome, foto, partido, numero, cargo);
	}
	
	private void encaminharRequisicao(String recurso, HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(recurso);
		rd.forward(request, response);
	}
}
