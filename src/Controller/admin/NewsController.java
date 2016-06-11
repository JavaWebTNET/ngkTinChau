package Controller.admin;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lang.Lang;
import models.TinTuc;
import dao.TinTucDAO;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/admin/tintuc/*")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
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
		TinTucDAO tintucDao = new TinTucDAO();
		int offsets = tintucDao.offsets();
		int totalPage = offsets/TinTucDAO.limit;
		if(offsets%TinTucDAO.limit>0) totalPage++;
		request.setAttribute("totalPage", totalPage);
		int pageno = 1;
		try {
			pageno = Integer.parseInt(request.getParameter("page"));
			if(pageno<1) pageno=1;
			if(pageno>totalPage) pageno=totalPage;
		} catch (Exception ex) {
			
		}
		request.setAttribute("pageno", pageno);
		Vector<TinTuc> allTT = tintucDao.pageTinTuc(pageno);
		request.setAttribute("tintuc", allTT);
		request.setAttribute("center", "QLtintuc");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Themtintuc");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		errorPage(request, response);
	}
	
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Lang lang = new Lang();
		TinTucDAO tintucDao = new TinTucDAO();
		TinTuc tintuc = tintucDao.validAdd(request);
		if(tintuc!=null) {
			if(tintucDao.addTinTuc(tintuc))
				request.getSession().setAttribute("flash_success", lang.getMessage("create_news_success"));
			else
				request.getSession().setAttribute("flash_error", lang.getMessage("create_news_fail"));
			response.sendRedirect(request.getContextPath() + "/admin/tintuc");
		}
		else
			response.sendRedirect(request.getContextPath() + "/admin/tintuc/create");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TinTucDAO tintucDao = new TinTucDAO();
		TinTuc tintuc = tintucDao.findTT(id);
		if(tintuc!=null) {
			request.setAttribute("tintuc", tintuc);
			request.setAttribute("center", "Suatintuc");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else errorPage(request, response);		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Lang lang = new Lang();
		TinTucDAO tintucDao = new TinTucDAO();
		TinTuc tintuc = tintucDao.validUdt(request, id);
		if(tintuc!=null) {
			if(tintucDao.udtTinTuc(tintuc))
				request.getSession().setAttribute("flash_success", lang.getMessage("update_news_success"));
			else
				request.getSession().setAttribute("flash_error", lang.getMessage("update_news_fail"));
			response.sendRedirect(request.getContextPath() + "/admin/tintuc");
		}
		else
			response.sendRedirect(request.getContextPath() + "/admin/tintuc/" + id + "/edit");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		TinTucDAO tintucDao = new TinTucDAO();
		if(tintucDao.delTinTuc(id))
			request.getSession().setAttribute("flash_success", lang.getMessage("delete_news_success"));
		else
			request.getSession().setAttribute("flash_success", lang.getMessage("delete_news_success"));
		response.sendRedirect(request.getContextPath() + "/admin/tintuc");
	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request, response);
	}
}
