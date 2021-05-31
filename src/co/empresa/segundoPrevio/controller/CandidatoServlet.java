package co.empresa.segundoPrevio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.segundoPrevio.modelo.Candidato;
import co.empresa.segundoPrevio.dao.CandidatoDao;

/**
 * Servlet implementation class CandidatoServlet
 */
@WebServlet("/")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CandidatoDao candidatoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.candidatoDao = new CandidatoDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try{
			switch(action){
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarCandidato(request, response);
				break;
			case "/delete":
				eliminarCandidato(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "update":
				actualizarCandidato(request, response);
				break;
			default:
				listCandidatos(request, response);
				break;
			}
		}catch(SQLException e){
			throw new ServletException(e); 
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));
		int numero = Integer.parseInt(request.getParameter("numero"));
		Candidato candidato = new Candidato(documento, nombre, apellido, eleccion, numero);
		candidatoDao.insert(candidato);	
		response.sendRedirect("list");
	}
	
	private void actualizarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));
		int numero = Integer.parseInt(request.getParameter("numero"));
		Candidato candidato = new Candidato(id, documento, nombre, apellido, eleccion, numero);
		candidatoDao.update(candidato);	
		response.sendRedirect("list");
	}
	
	private void eliminarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		candidatoDao.delete(id);	
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Candidato candidato = candidatoDao.select(id);
		request.setAttribute("candidato", candidato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listCandidatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Candidato> listCandidatos = candidatoDao.selectAll();
		request.setAttribute("listCandidatos", listCandidatos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listCandidatos.jsp");
		dispatcher.forward(request, response);
	}

}
