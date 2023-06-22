package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contact = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contacts(request, response);
		} else if (action.equals("/insert")) {
			newContact(request, response);
		} else if (action.equals("/select")) {
			listarcontatos(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		}

		else {
			response.sendRedirect("index.html");
		}
	}

	// listar contatos
	protected void contacts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um obejto que ira receber os dados JavaBeans

		ArrayList<JavaBeans> lista = dao.listarContatos();
		// encaminhar a lista ao documento agenda.jsp

		request.setAttribute("contacts", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

		// teste de recebimento da lista
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getIdcon());
//			System.out.println(lista.get(i).getNome());
//			System.out.println(lista.get(i).getFone());
//			System.out.println(lista.get(i).getEmail());
//		}

	}

	protected void newContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// testing if the information is working
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));

		// set the variables JavaBeans
		contact.setNome(request.getParameter("name"));
		contact.setFone(request.getParameter("phone"));
		contact.setEmail(request.getParameter("email"));

		// invocar o metodo insertContact passando o objeto contato
		dao.insertContact(contact);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	// editarcontato
	protected void listarcontatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do contato que será editado
		String idcon = request.getParameter("idcon");
		// setando a variavel
		contact.setIdcon(idcon);
		dao.selecionarContato(contact);
		// setar os atributos no formualario
		request.setAttribute("idcon", contact.getIdcon());
		request.setAttribute("name", contact.getNome());
		request.setAttribute("phone", contact.getFone());
		request.setAttribute("email", contact.getEmail());
		// encaminhar para o documento edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		contact.setIdcon(request.getParameter("idcon"));
		contact.setNome(request.getParameter("name"));
		contact.setFone(request.getParameter("phone"));
		contact.setEmail(request.getParameter("email"));

		dao.alterarContato(contact);
		// redirecionar para o documento agenda.jsp

		response.sendRedirect("main");
	}

	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contact.setIdcon(idcon);
		dao.deletarContato(contact);
		response.sendRedirect("main");
	}
}
