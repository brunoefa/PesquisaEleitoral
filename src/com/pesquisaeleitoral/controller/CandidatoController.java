package com.pesquisaeleitoral.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pesquisaeleitoral.model.Candidato;

/**
 * Servlet implementation class CandidatoController
 */
@WebServlet("/candidato")
public class CandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("listar".equals(acao)) {
			listar(request, response);	
		} else if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else if ("salvar".equals(acao)) {
			salvar(request, response);
		}
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String foto = request.getParameter("foto");
		String partido = request.getParameter("partido");
		String numero = request.getParameter("numero");
		String cargo = request.getParameter("cargo");
		
		Candidato candidato = new Candidato(nome, foto, partido, numero, cargo);
		request.setAttribute("candidato", candidato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
		rd.forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
		rd.forward(request, response);
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/cadastro.jsp");
		rd.forward(request, response);
	}
}
