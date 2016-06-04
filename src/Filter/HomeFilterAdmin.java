package Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DanhMucDAO;
import dao.DichVuDAO;
import dao.SliderDAO;
import dao.ThongTinDAO;
import dao.UserDao;
import models.DanhMuc;
import models.DichVu;
import models.Slider;
import models.ThongTin;

/**
 * Servlet Filter implementation class HomeFilter
 */
@WebFilter({"/admin/*"})
public class HomeFilterAdmin implements Filter {

    /**
     * Default constructor. 
     */
    public HomeFilterAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest rq = (HttpServletRequest)request;
		Integer userID = (Integer)rq.getSession().getAttribute("user_id");
		if(userID==null || !UserDao.isUser(userID)) {
			rq.getSession().setAttribute("prevURL", rq.getServletPath());
			((HttpServletResponse) response).sendRedirect(rq.getContextPath() + "/login");
		}	
		else chain.doFilter(request, response);	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
