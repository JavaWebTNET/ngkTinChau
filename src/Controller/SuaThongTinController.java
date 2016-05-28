package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThongTinDAO;
import models.ThongTin;

/**
 * Servlet implementation class SuaThongTinController
 */
@WebServlet("/admin/suathongtin")
public class SuaThongTinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaThongTinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	ThongTinDAO thongtinDAO=new ThongTinDAO();
	ThongTin thongtin=thongtinDAO.AllThongTin();
	
	request.setAttribute("thongtinsua",thongtin);
	RequestDispatcher rq=request.getRequestDispatcher("/View/admin/Suathongtin.jsp");
	rq.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String name_company=request.getParameter("name_company");
		String type_company=request.getParameter("type_company");
		String add_company=request.getParameter("add_company");
		String tell=request.getParameter("tell");
		String fax=request.getParameter("fax");
		String email=request.getParameter("email");
		String hotline=request.getParameter("hotline");
		String slogan=request.getParameter("slogan");
		String word_run=request.getParameter("word_run");
		String logo=request.getParameter("logo");
		int id_tt=Integer.parseInt(request.getParameter("id_tt"));
		
		ThongTin thongtin=new ThongTin();
		thongtin.setName_company(name_company);
		thongtin.setType_company(type_company);
		thongtin.setAdd_company(add_company);
		thongtin.setEmail(email);
		thongtin.setFax(fax);
		thongtin.setHotline(hotline);
		thongtin.setId_tt(id_tt);
		thongtin.setSlogan(slogan);
		thongtin.setWord_run(word_run);
		thongtin.setTel(tell);
		thongtin.setLogo(logo);
		
		ThongTinDAO thongtinDAO=new ThongTinDAO();
		boolean result=thongtinDAO.EditThongTin(thongtin);
		if(result){
			PrintWriter out = response.getWriter();  
			out.print("vao post"+result+"\n"+name_company); 
		}
		else{
			PrintWriter out = response.getWriter();  
			out.print("vao post"+result); 
		}
		
	}

}
