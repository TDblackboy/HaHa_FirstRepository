package per.sun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import per.sun.dao.LegendDao;
import per.sun.dao.LegendDaoImp;
import per.sun.modal.Legend;
import per.sun.util.Pack;

@WebServlet("/LoadServlet") // 这是servlet注解，注serlvet访问路径，不需要再web.xml中写servlet的映射
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoadServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		//=============================================
		System.out.println("跳转成功");
		// request设置
		request.setCharacterEncoding("utf-8");
		// response设置
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 获取请求
		String op = request.getParameter("operator");
		System.out.println("operator:" + op);// 测试
		// 获取返回输出流
		PrintWriter out = response.getWriter();
		// 查询工具
		LegendDao dao = new LegendDaoImp();
		List<Legend> lists = null;
		//json
		JSONArray array = new JSONArray();
		//=============================================
		//判断
		if (op != null && !op.equals("")) {
			if (op.equals("all")) {// 初始化页面请求数据
				lists = dao.loadAll();
				if (lists != null) {
					for (Legend leg : lists) {
						JSONObject json = Pack.toJson(leg);
						array.add(json);
					}
				}
			} else if(op.equals("name")) {//按名子搜索
				String name=request.getParameter("name");
				System.out.println("name:"+name);
				JSONObject jb=new JSONObject();
				Legend leg=dao.loadForName(name);
				//测试
				System.out.println("search:"+leg.getName());
				System.out.println("search:"+leg.getNeck());
				System.out.println("search:"+leg.getCamp());
				//
				jb=Pack.toJson(leg);
				array.add(jb);
			} else if (op.equals("type")) {//分类搜索
				String typeVal=request.getParameter("value");
				if(typeVal!=null&&!typeVal.equals("")) {
					String input=null;
					if(typeVal.equals("1")) {
						lists = dao.loadAll();
						if (lists != null) {
							for (Legend leg : lists) {
								JSONObject json = Pack.toJson(leg);
								array.add(json);
							}
						}
					}else if(typeVal.equals("2")) {
						input="战士";
					}else if(typeVal.equals("3")) {
						input="法师";
					}else if(typeVal.equals("4")) {
						input="刺客";
					}else if(typeVal.equals("5")) {
						input="坦克";
					}else if(typeVal.equals("6")) {
						input="射手";
					}else if(typeVal.equals("7")) {
						input="辅助";
					}else {
						System.out.println("typeValue:"+typeVal);
					}
					//
					if (input != null) {
						lists = dao.loadForType(input);
						if (lists != null) {
							for (Legend leg : lists) {
								JSONObject json = Pack.toJson(leg);
								array.add(json);
							}
						}
					}
				}
			} else {
				System.out.println("failure");
			}
		}
		out.print(array);// 数据返回ajax
		out.flush(); 
		out.close();
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
