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
import models.DichVu;
import models.SanPham;
import dao.DanhMucDAO;
import dao.DichVuDAO;
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
	"/lienhe",
	"/tuyendung",
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
			getcate(request, response);
		} 
	}
	
	protected void getcate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")) {
			getcateIndex(request, response);
		} else {
			getcateDetail(request, response);
		}
	}
	
	protected void getcateIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.equals("/sanpham")) {
			product(request, response, 0);
		} else if(path.equals("/dichvu")) {
			serviceIndex(request, response);
		} else {
			errorPage(request, response);
		}	
	}
	
	protected void getcateDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		String pathInfo = request.getPathInfo();
		int id;
		try {
			pathInfo = pathInfo.substring(1);
			id = Integer.parseInt(pathInfo);
		} catch(Exception ex) {
			id = 0;
		}
		if(id>0) {
			if(path.equals("/sanpham")) {
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
	
	protected void product(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
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
	
	protected void serviceIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SanPhamDAO sanphamDao = new SanPhamDAO();
		Vector<SanPham> sanphammoi = sanphamDao.pageSanPham(1);
		request.setAttribute("sanphammoi", sanphammoi);
		DichVuDAO dichvuDao = new DichVuDAO();
		int offsets = dichvuDao.offsets();
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
		Vector<DichVu> vtdv = dichvuDao.pageDichVu(pageno);
		request.setAttribute("dichvu", vtdv);
		request.setAttribute("center", "Dichvu");
		RequestDispatcher rq=request.getRequestDispatcher("/View/template.jsp");
		rq.forward(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
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
	
	protected void recruit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThongTinDAO thongtinDao = new ThongTinDAO();
		String detail = thongtinDao.allThongTin("recruit");
		request.setAttribute("detail", detail);
		request.setAttribute("center", "recruit");
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
