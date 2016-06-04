package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({
	"/login",
	"/logout",
	"/gioithieu",
	"/lienhe",
	"/tuyendung",
	"/danhmuc/*",
	"/sanpham/*",
	"/dichvu/*"
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
		String pathInfo = request.getPathInfo();
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
		} else if(path.equals("/tuyendung")) {
			recruit(request, response);
		} else {
			pathInfo = pathInfo.substring(1);
			int id;
			try {
				id = Integer.parseInt(pathInfo);
			} catch(Exception ex) {
				id = 0;
			}
			if(id>0) {
				if(path.equals("/danhmuc")) {
					category(request, response, id);
				} else if(path.equals("/sanpham")) {
					product(request, response, id);
				} else if(path.equals("/dichvu")) {
					service(request, response, id);
				} else {
					errorPage(request, response);
				}
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
		RequestDispatcher rq=request.getRequestDispatcher("/View/index.jsp");
		rq.forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rq=request.getRequestDispatcher("/View/login.jsp");
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
	
	protected void category(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("danhmuc "+id);
	}
	
	protected void product(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void aboutUs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void recruit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("errorPage");
	}
}
