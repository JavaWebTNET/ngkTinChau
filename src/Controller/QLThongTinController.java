package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThongTinDAO;
import models.ThongTin;

/**
 * Servlet implementation class QLThongTinController
 */
@WebServlet("/admin/quanlythongtin")
public class QLThongTinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLThongTinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		ThongTin thongtin=thongtinDAO.AllThongTin();
		request.setAttribute("thongtin", thongtin);
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/QLthongtin.jsp");
		rq.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
	}

}
