package Controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.SanPham;
import dao.SanPhamDAO;
import dao.ThongTinDAO;
import dao.UserDao;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({
	"/login",
	"/logout",
	"/gioithieu",
	"/lienhe"
})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String path = request.getServletPath();
		if(path.equals("")) {
			index(request, response);
		} else if(path.equals("/login")) {
			login(request, response);
		} else if(path.equals("/logout")) {
			logout(request, response);
		} else if(path.equals("/gioithieu")) {
			aboutUs(request, response);
		} else if(path.equals("/lienhe")) {
			contact(request, response);
		} else {					
			errorPage(request, response);
		} 
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.equals("")) {
			index(request, response);
		} else if(path.equals("/login")) {
			loginPost(request, response);
		} else {
			errorPage(request, response);
		}	
	}
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		SanPhamDAO sanphamDao = new SanPhamDAO();
		Vector<SanPham> sanphammoi = sanphamDao.pageSanPham(1);
		request.setAttribute("sanphammoi", sanphammoi);
		request.setAttribute("center", "index");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "login");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
	
	protected void loginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		int id = UserDao.login(user, pass);
		if(id>0) {
			request.getSession().setAttribute("user_id", id);
			String redirect = "/admin";
			String prevURL = (String)request.getSession().getAttribute("prevURL");
			if(prevURL!=null) redirect = prevURL;
			response.sendRedirect(request.getContextPath() + redirect);
		}
		else {
			request.getSession().setAttribute("flash_error", "Sai Tên Đăng Nhập hoặc Mật Khẩu");
			response.sendRedirect(request.getContextPath() + "/login");
		}	
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getSession().removeAttribute("user_id");
		response.sendRedirect(request.getContextPath() + "/login");
	}
	
	protected void aboutUs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDao = new ThongTinDAO();
		String detail = thongtinDao.allThongTin("aboutus");
		request.setAttribute("detail", detail);
		request.setAttribute("center", "aboutus");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}

	protected void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDao = new ThongTinDAO();
		String detail = thongtinDao.allThongTin("contact");
		request.setAttribute("detail", detail);
		request.setAttribute("center", "contact");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
		
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
}
