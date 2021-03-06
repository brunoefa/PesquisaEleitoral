package com.pesquisaeleitoral.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		} else if ("logar".equals(acao)) {
			logar(request, response);
		}else {
			mostrarLogin(request, response);
		}
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
			request.setAttribute("sucesso", "Usu�rio cadastrado com sucesso!");
			c.listar(request, response);
		}else {
			request.setAttribute("erro", "Senha n�o confere com a confirma��o de senha");
			cadastrar(request, response);
		}
	}
	
	private Boolean validarSenha(String senha, String confirmacao) {
		return senha.equals(confirmacao);
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		encaminharRequisicao("/login.jsp", request, response);
	}

	private void logar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Usuario usuarioLogin = obterUsuario(request);
		Usuario usuarioBanco = dao.buscar(usuarioLogin.getEmail());
		
		if (usuarioLogin.getSenha().equals(usuarioBanco.getSenha())) {
			HttpSession session = request.getSession();

			session.setAttribute("usuario", usuarioBanco);
			session.setAttribute("logado", Boolean.TRUE);
			session.setAttribute("admin", usuarioBanco.getStatus() ? Boolean.TRUE : Boolean.FALSE);

			request.setAttribute("sucesso", "Login efetuado com sucesso!");
			CandidatoController c = new CandidatoController();
			c.listar(request, response);
		}else {
			request.setAttribute("erro", "Login ou senha inv�lidos!");
			mostrarLogin(request, response);
		}
	}

	private void deslogar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		CandidatoController c = new CandidatoController();
		c.listar(request, response);
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
