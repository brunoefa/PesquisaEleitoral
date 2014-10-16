package com.pesquisaeleitoral.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pesquisaeleitoral.dao.UsuarioDao;
import com.pesquisaeleitoral.model.Usuario;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao dao;
       
    public UsuarioController() {
        super();
        dao = new UsuarioDao();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else if ("salvar".equals(acao)) {
			salvar(request, response);
		} else if ("deslogar".equals(acao)) {
			deslogar(request, response);
		} else if ("login".equals(acao)) {
			mostrarLogin(request, response);
		}
		logar(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao("/cadastro.jsp", request, response);
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Usuario usuario = obterUsuario(request);
		String confirmacao = request.getParameter("confirmacao");
		
		if (validarSenha(usuario.getSenha(), confirmacao)) {
			dao.salvar(usuario);
			CandidatoController c = new CandidatoController();
			c.listar(request, response);
		}else {
			request.setAttribute("erro", "Senha não confere com a confirmação de senha");
//			request.setAttribute("sucesso", "Senha não confere com a confirmação de senha");
			cadastrar(request, response);
		}
	}
	
	private Boolean validarSenha(String senha, String confirmacao) {
		if (senha.equals(confirmacao)) {
			return true;
		}
		return false;
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		encaminharRequisicao("/login.jsp", request, response);
	}

	private void logar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
	}

	private void deslogar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

	}

	private Usuario obterUsuario(HttpServletRequest request)  throws ServletException, IOException {
		Integer id = null;
		String stringId = request.getParameter("id");
		if (stringId != null && !stringId.isEmpty()) {
			id = Integer.parseInt(stringId);
		}
		String nome = request.getParameter("nome");
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Boolean status = Boolean.FALSE;
		String stringStatus = request.getParameter("status");
		if (stringStatus != null && !stringStatus.isEmpty()) {
			status = Boolean.parseBoolean(stringStatus);
		}
		return new Usuario(id, nome, email, senha, status);
	}
	
	private void encaminharRequisicao(String recurso, HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(recurso);
		rd.forward(request, response);
	}
}
