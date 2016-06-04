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

import dao.DanhMucDAO;
import dao.DichVuDAO;
import dao.SliderDAO;
import dao.ThongTinDAO;
import models.DanhMuc;
import models.DichVu;
import models.Slider;
import models.ThongTin;

/**
 * Servlet Filter implementation class HomeFilter
 */
@WebFilter("/*")
public class HomeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HomeFilter() {
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
		DanhMucDAO dmDAO=new DanhMucDAO();
		
		HashMap<Integer,ArrayList<DanhMuc>> hmAllDM=new HashMap<Integer,ArrayList<DanhMuc>>();		
		
		Vector<DanhMuc> vtdm=dmDAO.allDanhMuc();
		for(DanhMuc itemdm:vtdm){
			
			if(hmAllDM.containsKey(itemdm.getSuper_id())) {
				 ArrayList<DanhMuc> arrDM =hmAllDM.get(itemdm.getSuper_id());
				 arrDM.add(itemdm);
				 hmAllDM.remove(itemdm.getSuper_id());
				 hmAllDM.put(itemdm.getSuper_id(), arrDM);				
			}
			else {	
				ArrayList<DanhMuc> arrDMNew=new ArrayList<DanhMuc>();
				arrDMNew.add(itemdm);
				hmAllDM.put(itemdm.getSuper_id(),arrDMNew);
			
			}		
		}
		
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		ThongTin    thongtin=thongtinDAO.allThongTin();
		
		SliderDAO slider=new SliderDAO();
		Vector<Slider> vtsd=slider.allSlider();
		
		DichVuDAO dvDAO=new DichVuDAO();
		Vector<DichVu> dichvu=dvDAO.allDichVu();
		
		request.setAttribute("danhmuc", hmAllDM);
		request.setAttribute("dichvu", dichvu);
		request.setAttribute("slider", vtsd);
		request.setAttribute("thongtin", thongtin);
		
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
