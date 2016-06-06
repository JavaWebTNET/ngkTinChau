package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThongTinDAO;
import lang.Lang;
import models.ThongTin;

/**
 * Servlet implementation class InfoController
 */
@WebServlet("/admin/thongtin/*")
@MultipartConfig
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoController() {
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
		} else if(pathInfo.equals("/edit")) {
			edit(request, response);
		} else if(pathInfo.equals("/aboutus")
				||pathInfo.equals("/recruit")
				||pathInfo.equals("/contact")) {
			editTT(request, response, pathInfo.substring(1));
		} else {
			errorPage(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		if(pathInfo.equals("/update")) {
			update(request, response);
		} else if(pathInfo.equals("/aboutus")
				||pathInfo.equals("/recruit")
				||pathInfo.equals("/contact")) {
			updateTT(request, response, pathInfo.substring(1));
		} else {		
			errorPage(request, response);
		}
	}
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		ThongTin thongtin=thongtinDAO.allThongTin();
		request.setAttribute("thongtin", thongtin);
		request.setAttribute("center", "QLthongtin");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		ThongTin thongtin=thongtinDAO.allThongTin();
		
		request.setAttribute("thongtinsua",thongtin);
		request.setAttribute("center", "Suathongtin");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Lang lang = new Lang();		
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		ThongTin thongtin= thongtinDAO.validUdt(request);
		if(thongtin != null) {				
			if(thongtinDAO.udtThongTin(thongtin)) {
				 request.getSession().setAttribute("flash_success", lang.getMessage("update_info_success"));
			}
			else {
				 request.getSession().setAttribute("flash_error", lang.getMessage("update_info_fail"));
			}
		}
		response.sendRedirect(request.getContextPath() + "/admin/thongtin");
	}
	
	protected void editTT(HttpServletRequest request, HttpServletResponse response, String key) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		String value = thongtinDAO.allThongTin(key);
		request.setAttribute("keytt", key);
		request.setAttribute("valuett", value);
		request.setAttribute("center", "Suatrangtt");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request, response);
	}
	
	protected void updateTT(HttpServletRequest request, HttpServletResponse response, String key) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Lang lang = new Lang();		
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		String value = request.getParameter("detail");
		if(thongtinDAO.udtThongTin(key, value)) {
			request.getSession().setAttribute("flash_success", lang.getMessage("update_"+key+"_success"));
		}
		else {
			 request.getSession().setAttribute("flash_error", lang.getMessage("update_"+key+"_fail"));
		}
		response.sendRedirect(request.getContextPath() + "/admin/thongtin");
	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request, response);
	}

}
