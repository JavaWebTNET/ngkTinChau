package Controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DichVuDAO;
import lang.Lang;
import models.DichVu;

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/admin/dichvu/*")
@MultipartConfig
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			index(request, response);
		} else if(pathInfo.equals("/create")) {
			create(request, response);
		} else {
			String[] pathParts = pathInfo.split("/");
			int id;
			try {
				id = Integer.parseInt(pathParts[1]);
			} catch(Exception ex) {
				id = 0;
			}
			if(id <= 0 || pathParts.length > 3) {
				errorPage(request, response);
			} else if(pathParts.length == 2) {
				show(request, response, id);
			} else if(pathParts[2].equals("edit")) {
				edit(request, response, id);
			} else {
				errorPage(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			store(request, response);
		} else {
			String[] pathParts = pathInfo.split("/");
			int id;
			try {
				id = Integer.parseInt(pathParts[1]);
			} catch(Exception ex) {
				id = 0;
			}
			if(id <= 0 || pathParts.length > 3) {
				errorPage(request, response);
			} else if(pathParts.length == 3) {
				if(pathParts[2].equals("update")) {
					update(request, response, id);
				} else if(pathParts[2].equals("delete")) {
					delete(request, response, id);
				} else {
					errorPage(request, response);
				}
			} else {
				errorPage(request, response);
			}
		}
	}

	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DichVuDAO dichvuDao = new DichVuDAO();
		int offsets = dichvuDao.offsets();
		int totalPage = offsets/DichVuDAO.limit;
		if(offsets%DichVuDAO.limit>0) totalPage++;
		request.setAttribute("totalPage", totalPage);
		int pageno = 1;
		try {
			pageno = Integer.parseInt(request.getParameter("page"));
			if(pageno<1) pageno=1;
			if(pageno>totalPage) pageno=totalPage;
		} catch (Exception ex) {
			
		}
		request.setAttribute("pageno", pageno);
		Vector<DichVu> allDV = dichvuDao.pageDichVu(pageno);
		request.setAttribute("dichvu", allDV);
		request.setAttribute("center", "QLdichvu");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Themdichvu");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("show " +id);
	}
	
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Lang lang = new Lang();
		DichVuDAO dichvuDao = new DichVuDAO();
		DichVu dichvu = dichvuDao.validAdd(request);
		if(dichvu!=null) {
			if(dichvuDao.addDichVu(dichvu))
				request.getSession().setAttribute("flash_success", lang.getMessage("create_service_success"));
			else
				request.getSession().setAttribute("flash_error", lang.getMessage("create_service_fail"));
		}
		response.sendRedirect(request.getContextPath() + "/admin/dichvu");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DichVuDAO dichvuDao = new DichVuDAO();
		DichVu dichvu = dichvuDao.findDV(id);
		if(dichvu!=null) {
			request.setAttribute("dichvu", dichvu);
			request.setAttribute("center", "Suadichvu");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else errorPage(request, response);		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Lang lang = new Lang();
		DichVuDAO dichvuDao = new DichVuDAO();
		DichVu dichvu = dichvuDao.validUdt(request, id);
		if(dichvu!=null) {
			if(dichvuDao.udtDichVu(dichvu))
				request.getSession().setAttribute("flash_success", lang.getMessage("update_service_success"));
			else
				request.getSession().setAttribute("flash_error", lang.getMessage("update_service_fail"));
		}
		response.sendRedirect(request.getContextPath() + "/admin/dichvu");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		DichVuDAO dichvuDao = new DichVuDAO();
		if(dichvuDao.delDichVu(id))
			request.getSession().setAttribute("flash_success", lang.getMessage("delete_service_success"));
		else
			request.getSession().setAttribute("flash_success", lang.getMessage("delete_service_success"));
		response.sendRedirect(request.getContextPath() + "/admin/dichvu");
	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request, response);
	}
}
