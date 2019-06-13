package per.sun.util;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import per.sun.modal.Legend;

public class Pack {
	public static Legend packForRequst(HttpServletRequest request) {
		Legend legend=new Legend();
		legend.setName(request.getParameter("lname"));
		legend.setNeck(request.getParameter("lneck"));
		legend.setType(request.getParameter("ltype"));
		//System.out.println("type:"+request.getParameter("ltype"));
		legend.setCamp(request.getParameter("lhome"));
		legend.setContext(request.getParameter("lcontext"));
		legend.setPassive(request.getParameter("lpsiv"));
		legend.setSkillq(request.getParameter("lq"));
		legend.setSkillw(request.getParameter("lw"));
		legend.setSkille(request.getParameter("le"));
		legend.setSkillr(request.getParameter("lr"));
		//差- 图
		return legend;
	}
	
	public static JSONObject toJson(Legend legend) {
		// JSONArray array = new JSONArray();// [{},{},{}]
		// JSONObject json=null;//{"":"","":"",}
		JSONObject json = new JSONObject();
		json.put("id", legend.getId());
		json.put("name", legend.getName());
		json.put("neck", legend.getNeck());
		// json.put("imgUrl", leg.getImgUrl());
		/*
		 * json.put("type", leg.getType()); json.put("camp", leg.getCamp());
		 * json.put("context", leg.getContext()); json.put("passive", leg.getPassive());
		 * json.put("skillq", leg.getSkillq()); json.put("skillw", leg.getSkillw());
		 * json.put("skille", leg.getSkille()); json.put("skillr", leg.getSkillr());
		 */
		return json;
	}
}
