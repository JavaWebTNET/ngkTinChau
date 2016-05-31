package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SliderDAO;
import dao.isNumberDAO;

/**
 * Servlet implementation class SliderController
 */
@WebServlet("/admin/slider/*")
public class SliderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SliderController() {
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
		} else if(pathInfo.equals("/create")) {
			create(request, response);
		} 
		else if(pathInfo.equals("/delete")){
			System.out.println("dsds"+request.getQueryString());
			String[] pathParts = request.getQueryString().split("=");
			System.out.println("dsdddds"+pathParts[1]);
			if(pathParts.length==2 && pathParts[0].equals("id") && isNumberDAO.isNumber(pathParts[1]))
			{
				delete(request, response,Integer.parseInt(pathParts[1]));			
			}
			else{
				
				errorPage(request, response, "Đường dẫn không chính xác..!");
			}
			
		}
		
		else {
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
				show(request, response, id);
			} else if(pathParts[2].equals("edit")) {
				edit(request, response, id);
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
			store(request, response);
		}
		else if(pathInfo.equals("/create")) {
			create(request, response);
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
			} else if(pathParts.length == 3) {
				if(pathParts[2].equals("update")) {
					update(request, response, id);
				} else if(pathParts[2].equals("delete")) {
					delete(request, response, id);
				} else {
					errorPage(request, response);
				}
			} else {
				errorPage(request, response);
			}
		}
	}
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SliderDAO sliderDAO=new SliderDAO();
		request.setAttribute("slider",sliderDAO.AllSlider());
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/QLslider.jsp");
		rq.forward(request,response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("da vao create");
		
	}
	
	protected void show(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("show " +id);
	}
	
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("store");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("edit " +id);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("update " +id);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SliderDAO sliderDAO=new SliderDAO();
		boolean result=sliderDAO.DelSlider(id);
		if(result==true){
			 request.getSession().setAttribute("flash_success", "Xóa thành công..!");
			 response.sendRedirect(request.getContextPath()+"/admin/slider");
		}
		else{
			 request.getSession().setAttribute("flash_error", "Xử lý thất bại..!");
			 response.sendRedirect(request.getContextPath()+"/admin/slider");
		
		}
		
	}

	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("errorPage");
	}
	protected void errorPage(HttpServletRequest request, HttpServletResponse response,String error) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("errorPage");
	}
	
	public  void show(String hh){
		System.out.println("in ra duong dan "+hh);
	}
}
