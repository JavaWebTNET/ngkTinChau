package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lang.Lang;
import models.Slider;
import dao.SliderDAO;

/**
 * Servlet implementation class SliderController
 */
@WebServlet("/admin/slider/*")
@MultipartConfig
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
		} else {			
			errorPage(request, response);
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
		request.setAttribute("slider",sliderDAO.allSlider());
		request.setAttribute("center","QLslider");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request,response);
	}
	
	protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		SliderDAO sliderDao=new SliderDAO();
		Slider slider= sliderDao.validAdd(request);

		if(slider!=null) {								
			 if(sliderDao.addSlider(slider)) {
				 request.getSession().setAttribute("flash_success", lang.getMessage("create_slider_success"));
			 }
			 else {
				 request.getSession().setAttribute("flash_error", lang.getMessage("create_slider_fail"));
			 }
		}
		response.sendRedirect(request.getContextPath() + "/admin/slider");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		SliderDAO sliderDao=new SliderDAO();
		Slider slider=sliderDao.validUdt(request, id);

		if(slider!=null) {								
			 if(sliderDao.udtSlider(slider)) {
				 request.getSession().setAttribute("flash_success", lang.getMessage("update_slider_success"));
			 }
			 else {
				 request.getSession().setAttribute("flash_error", lang.getMessage("update_slider_fail"));
			 }
		}
		response.sendRedirect(request.getContextPath() + "/admin/slider");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lang lang = new Lang();
		SliderDAO sliderDAO=new SliderDAO();
		if(sliderDAO.delSlider(id)) {
			 request.getSession().setAttribute("flash_success", lang.getMessage("delete_slider_success"));
		}
		else {
			 request.getSession().setAttribute("flash_error", lang.getMessage("delete_slider_fail"));			 		
		}
		response.sendRedirect(request.getContextPath()+"/admin/slider");
	}

	protected void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("center", "Error");
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/template.jsp");
		rq.forward(request, response);
	}
}
