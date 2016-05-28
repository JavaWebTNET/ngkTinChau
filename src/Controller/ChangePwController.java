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
 * Servlet implementation class ChangePwController
 */
@WebServlet("/admin/changepw")
public class ChangePwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/changepw.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pass = request.getParameter("pass");
		String newPass = request.getParameter("new_pass");
		String cfPass = request.getParameter("cf_pass");
		Integer userId = (Integer)request.getSession().getAttribute("user_id");
		if(cfPass.equals(newPass)) {
			if(UserDao.changepw(userId, pass, newPass)) {
				request.getSession().setAttribute("flash_success", "Đã thay đổi mật khẩu");
			}
			else {
				request.getSession().setAttribute("flash_error", "Sai mật khẩu");
			}			
		}
		else {
			request.getSession().setAttribute("flash_error", "Mật khẩu nhập lại không trùng nhau");
		}
		response.sendRedirect(request.getContextPath() + "/admin/changepw");
	}

}
