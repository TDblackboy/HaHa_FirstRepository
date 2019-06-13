package per.sun.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import per.sun.dao.LegendDao;
import per.sun.dao.LegendDaoImp;
import per.sun.modal.Legend;
import per.sun.util.Pack;

/**
 * Servlet implementation class ManagerOprate
 */
@WebServlet("/ManagerOprate")
public class ManagerOprate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerOprate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		//CRUD
		if(request.getParameter("op")!=null) {
			String operate=request.getParameter("op");
			LegendDao dao=new LegendDaoImp();
			//==================增====================
			if(operate.equals("add")) {
				//检查数据库中是否有想同的数据
				if(dao.loadForName(request.getParameter("lname"))!=null) {
					System.out.print("已有数据，无法增加");
				}else {
					//接受jsp数据
					Legend legend=Pack.packForRequst(request);
					//上传数据库
					dao.add(legend);
				}
			}else {
				if(request.getParameter("id")!=null) {
					int id=Integer.parseInt(request.getParameter("id"));
					//=================改====================
					if(operate.equals("update")) {
						Legend legend=Pack.packForRequst(request);
						legend.setId(id);
						dao.updated(legend);
						//=================删====================
					}else if(operate.equals("delete")) {
						dao.deleted(id);
						//=================查====================
					}else if(operate.equals("look")) {
						//这个在jsp界面完成
					}
				}else {
					System.out.println("error:id is null");
				}
			}
		}else {
			System.out.println("warn: 不执行增，删，改 ，系列操作");
		}
		
		response.sendRedirect("./pages/roleManage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
