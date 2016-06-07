package Controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DanhMucDAO;
import dao.SanPhamDAO;
import lang.Lang;
import models.DanhMuc;
import models.SanPham;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/admin/danhmuc/*")
@MultipartConfig
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
			index(request, response, 0);
		} else if(pathInfo.equals("/create")) {
			create(request, response, 0);
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
				index(request, response, id);
			} else if(pathParts[2].equals("create")) {
				create(request, response, id);
			} else if(pathParts[2].equals("createsp")) {
				createSP(request, response, id);
			} else if(pathParts[2].equals("edit")) {
				edit(request, response, id);
			} else if(pathParts[2].equals("editsp")) {
				editSP(request, response, id);
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
			store(request, response, 0);
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
				store(request, response, id);
			} else if(pathParts.length == 3) {
				if(pathParts[2].equals("store")) {
					storeSP(request, response, id);
				} else if(pathParts[2].equals("update")) {
					update(request, response, id);
				} else if(pathParts[2].equals("updatesp")) {
					updateSP(request, response, id);
				} else if(pathParts[2].equals("delete")) {
					delete(request, response, id);
				} else if(pathParts[2].equals("deletesp")) {
					deleteSP(request, response, id);
				} else if(pathParts[2].equals("prosp")) {
					proSP(request, response, id);
				} else {
					errorPage(request, response);
				}
			} else {
				errorPage(request, response);
			}
		}
	}
	
	protected void index(HttpServletRequest request, HttpServletResponse response, int supId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.findDM(supId);
		if(danhmuc!=null || supId==0) {
			request.setAttribute("canAddDM", danhmucDao.canAddDM(supId));
			request.setAttribute("dam", danhmuc);
			Vector<DanhMuc> vtdm = danhmucDao.allDanhMuc(supId);
			request.setAttribute("danhmuc", vtdm);
			SanPhamDAO sanphamDao = new SanPhamDAO();
			int offsets = sanphamDao.offsets(supId);
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
			Vector<SanPham> vtsp = sanphamDao.pageSanPham(pageno, supId);
			request.setAttribute("sanpham", vtsp);
			
			request.setAttribute("center", "QLdanhmuc");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else {
			errorPage(request, response);
		}
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response, int supId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.findDM(supId);
		if(danhmuc != null && danhmucDao.canAddDM(supId) || supId == 0) {
			request.setAttribute("dam", danhmuc);
			request.setAttribute("center", "Themdanhmuc");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else
			errorPage(request, response);
	}
	
	protected void createSP(HttpServletRequest request, HttpServletResponse response, int supId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.findDM(supId);
		if(danhmuc != null) {
			request.setAttribute("dam", danhmuc);
			request.setAttribute("center", "Themsanpham");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else
			errorPage(request, response);
	}
	
	protected void store(HttpServletRequest request, HttpServletResponse response, int supId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		request.setCharacterEncoding("utf-8");
		DanhMucDAO danhmucDao = new DanhMucDAO();
		if(danhmucDao.canAddDM(supId)) {
			DanhMuc danhmuc = danhmucDao.validAdd(request, supId);
			if(danhmuc!=null) {
				if(danhmucDao.addDanhMuc(danhmuc)) 
					request.getSession().setAttribute("flash_success", lang.getMessage("create_category_success"));
				else
					request.getSession().setAttribute("flash_error", lang.getMessage("create_category_fail"));
				response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (supId>0?supId:""));
			}
			else
				response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (supId>0?supId+"/":"") + "create");
		}
		else {
			request.getSession().setAttribute("flash_error", lang.getMessage("create_category_fail"));
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (supId>0?supId:""));
		}
	}
	
	protected void storeSP(HttpServletRequest request, HttpServletResponse response, int supId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		request.setCharacterEncoding("utf-8");
		DanhMucDAO danhmucDao = new DanhMucDAO();
		SanPhamDAO sanphamDao = new SanPhamDAO();
		DanhMuc danhmuc = danhmucDao.findDM(supId);
		if(danhmuc!=null) {
			SanPham sanpham = sanphamDao.validAdd(request, supId);
			if(sanpham!=null) {
				if(sanphamDao.addSanPham(sanpham)) 
					request.getSession().setAttribute("flash_success", lang.getMessage("create_product_success"));
				else
					request.getSession().setAttribute("flash_error", lang.getMessage("create_product_fail"));			
				response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + supId);
			}
			else
				response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (supId>0?supId+"/":"") + "createsp");
		}
		else {
			request.getSession().setAttribute("flash_error", lang.getMessage("create_product_fail"));
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + supId);
		}
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.findDM(id);
		if(danhmuc != null) {
			request.setAttribute("dm", danhmuc);
			request.setAttribute("center", "Suadanhmuc");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else
			errorPage(request, response);
	}
	
	protected void editSP(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SanPhamDAO sanphamDao = new SanPhamDAO();
		SanPham sanpham = sanphamDao.findSP(id);
		if(sanpham != null) {
			request.setAttribute("sp", sanpham);
			request.setAttribute("center", "Suasanpham");
			RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
			rq.forward(request,response);
		}
		else
			errorPage(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		request.setCharacterEncoding("utf-8");
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.validUdt(request, id);
		if(danhmuc!=null) {
			if(danhmucDao.udtDanhMuc(danhmuc))
				request.getSession().setAttribute("flash_success", lang.getMessage("update_category_success"));
			else
				request.getSession().setAttribute("flash_error", lang.getMessage("update_category_fail"));
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (danhmuc!=null && danhmuc.getSuper_id()>0?danhmuc.getSuper_id():""));
		}
		else
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + id + "/edit");
	}
	
	protected void updateSP(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		request.setCharacterEncoding("utf-8");
		SanPhamDAO sanphamDao = new SanPhamDAO();
		SanPham sanpham = sanphamDao.validUdt(request, id);
		if(sanpham!=null) {
			if(sanphamDao.udtSanPham(sanpham))
				request.getSession().setAttribute("flash_success", lang.getMessage("update_product_success"));
			else
				request.getSession().setAttribute("flash_error", lang.getMessage("update_product_fail"));
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (sanpham!=null?sanpham.getSuper_id():""));
		}
		else
			response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + id + "/editsp");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		DanhMucDAO danhmucDao = new DanhMucDAO();
		DanhMuc danhmuc = danhmucDao.findDM(id);
		if(danhmucDao.delDanhMuc(id))
			request.getSession().setAttribute("flash_success", lang.getMessage("delete_category_success"));
		else
			request.getSession().setAttribute("flash_error", lang.getMessage("delete_category_fail"));
		response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (danhmuc!=null && danhmuc.getSuper_id()>0?danhmuc.getSuper_id():""));
	}
	
	protected void deleteSP(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		SanPhamDAO sanphamDao = new SanPhamDAO();
		SanPham sanpham = sanphamDao.findSP(id);
		if(sanphamDao.delSanPham(id))
			request.getSession().setAttribute("flash_success", lang.getMessage("delete_product_success"));
		else
			request.getSession().setAttribute("flash_error", lang.getMessage("delete_product_fail"));
		response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (sanpham!=null?sanpham.getSuper_id():""));
	}
	
	protected void proSP(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		SanPhamDAO sanphamDao = new SanPhamDAO();
		SanPham sanpham = sanphamDao.findSP(id);
		if(sanphamDao.proSanPham(id))
			request.getSession().setAttribute("flash_success", 
					lang.getMessage("pro_"+(sanpham.isProminent()?"off":"on")+"_product_success"));
		else
			request.getSession().setAttribute("flash_error", 
					lang.getMessage("pro_"+(sanpham!=null && sanpham.isProminent()?"off":"on")+"_product_fail"));
		response.sendRedirect(request.getContextPath() + "/admin/danhmuc/" + (sanpham!=null?sanpham.getSuper_id():""));
	}
	
	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request, response);
	}
	
}
