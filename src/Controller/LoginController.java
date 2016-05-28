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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rq=request.getRequestDispatcher("/View/login.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
