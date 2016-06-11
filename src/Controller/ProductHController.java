package Controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DanhMuc;
import models.SanPham;
import dao.DanhMucDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class ProductHController
 */
@WebServlet("/sanpham/*")
public class ProductHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductHController() {
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
		show(request, response, 0);
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.findDM(id);
		if(danhmuc!=null || id==0) {
			request.setAttribute("dam", danhmuc);
			SanPhamDAO sanphamDao = new SanPhamDAO();
			int offsets = sanphamDao.offsetsAll(id);
			int totalPage = offsets/SanPhamDAO.limit;
			if(offsets%SanPhamDAO.limit>0) totalPage++;
			request.setAttribute("totalPage", totalPage);
			int pageno = 1;
			try {
				pageno = Integer.parseInt(request.getParameter("page"));
				if(pageno<1) pageno=1;
				if(pageno>totalPage) pageno=totalPage;
			} catch (Exception ex) {
				
			}
			request.setAttribute("pageno", pageno);
			Vector<SanPham> vtsp = sanphamDao.pageAllSanPham(pageno, id);
			request.setAttribute("sanpham", vtsp);
			
			request.setAttribute("center", "Sanpham");
			RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
			rq.forward(request,response);
		}
		else {
			errorPage(request, response);
		}
	}

	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
}
