package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DanhMucDAO;
import dao.ThongTinDAO;
import models.DanhMuc;
import models.ThongTin;

/**
 * Servlet implementation class HomeController
 */
//@WebServlet("/HomeController")
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
		
		/*lay danh muc*/
		DanhMucDAO dmDAO=new DanhMucDAO();
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
		
		request.setAttribute("danhmuc", hmAllDM);
		request.setAttribute("thongtin", thongtin);
		RequestDispatcher rq=request.getRequestDispatcher("/View/index.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		DanhMucDAO dmDAO=new DanhMucDAO();
		DanhMuc dm = dmDAO.KiemTra(request);
		dm.getId();
	}

}
