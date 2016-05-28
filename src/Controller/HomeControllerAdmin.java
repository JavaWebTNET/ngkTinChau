package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DanhMucDAO;
import dao.DichVuDAO;
import dao.SliderDAO;
import dao.ThongTinDAO;
import models.DanhMuc;
import models.DichVu;
import models.Slider;
import models.ThongTin;

/**
 * Servlet implementation class HomeControllerAdmin
 */
@WebServlet("/admin")
public class HomeControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*DanhMucDAO dmDAO=new DanhMucDAO();
		
		HashMap<Integer,ArrayList<DanhMuc>> hmAllDM=new HashMap<Integer,ArrayList<DanhMuc>>();		
		
		Vector<DanhMuc> vtdm=dmDAO.AllDanhMuc();
		for(DanhMuc itemdm:vtdm){
			
			if(hmAllDM.containsKey(itemdm.getSuper_id())){
				 ArrayList<DanhMuc> arrDM =hmAllDM.get(itemdm.getSuper_id());
				 arrDM.add(itemdm);
				 hmAllDM.remove(itemdm.getSuper_id());
				 hmAllDM.put(itemdm.getSuper_id(), arrDM);				
			}
			else{	
				ArrayList<DanhMuc> arrDMNew=new ArrayList<DanhMuc>();
				arrDMNew.add(itemdm);
				hmAllDM.put(itemdm.getSuper_id(),arrDMNew);			
			}			
		}		
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		ThongTin    thongtin=thongtinDAO.AllThongTin();
		
		SliderDAO slider=new SliderDAO();
		Vector<Slider> vtsd=slider.AllSlider();
		
		DichVuDAO dvDAO=new DichVuDAO();
		Vector<DichVu> dichvu=dvDAO.AllDichVu();
		
		request.setAttribute("danhmuc", hmAllDM);
		request.setAttribute("dichvu", dichvu);
		request.setAttribute("slider", vtsd);
		request.setAttribute("thongtin", thongtin);*/
		
		RequestDispatcher rq=request.getRequestDispatcher("/View/admin/index.jsp");
		rq.forward(request,response);
		
		/*esponse.sendRedirect("/View/admin/index.jsp");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
