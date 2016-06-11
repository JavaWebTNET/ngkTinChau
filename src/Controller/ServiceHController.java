package Controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DichVu;
import models.SanPham;
import dao.DichVuDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class ServiceHController
 */
@WebServlet("/dichvu/*")
public class ServiceHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceHController() {
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
		} else {
			int id;
			try {
				pathInfo = pathInfo.substring(1);
				id = Integer.parseInt(pathInfo);
			} catch(Exception ex) {
				id = 0;
			}
			if(id>0) {
				show(request, response, id);
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
		errorPage(request, response);
	}

	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SanPhamDAO sanphamDao = new SanPhamDAO();
		Vector<SanPham> sanphammoi = sanphamDao.pageSanPham(1);
		request.setAttribute("sanphammoi", sanphammoi);
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
		Vector<DichVu> vtdv = dichvuDao.pageDichVu(pageno);
		request.setAttribute("dichvu", vtdv);
		request.setAttribute("center", "Dichvu");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DichVuDAO dichvuDao = new DichVuDAO();
		DichVu dichvu = dichvuDao.findDV(id);
		if(dichvu!=null) {
			request.setAttribute("dichvu", dichvu);
			request.setAttribute("center", "Dichvuct");
			RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
			rq.forward(request, response);
		}
		else errorPage(request, response);
	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
}
