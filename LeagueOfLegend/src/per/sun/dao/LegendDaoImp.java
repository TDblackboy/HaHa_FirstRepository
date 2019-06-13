package per.sun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import per.sun.modal.Legend;
import per.sun.util.DBUtil;

public class LegendDaoImp implements LegendDao {

	private static String table="legendtext";
	
	public void add(Legend legend) {
		
		String sql="insert into legendtext(name,neck,type,camp,context,passive,skillq,skillw,skille,skillr) values(?,?,?,?,?,?,?,?,?,?)";
		
		Connection con=DBUtil.getConnection();
		PreparedStatement state=null;
		try {
			state=con.prepareStatement(sql);
			state.setString(1,legend.getName());
			state.setString(2,legend.getNeck());
			state.setString(3,legend.getType());
			state.setString(4,legend.getCamp());
			state.setString(5,legend.getContext());
			state.setString(6,legend.getPassive());
			state.setString(7,legend.getSkillq());
			state.setString(8,legend.getSkillw());
			state.setString(9,legend.getSkille());
			state.setString(10,legend.getSkillr());
			state.executeUpdate();
			System.out.println("添加成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("添加失败");
		}
		DBUtil.close(state);
		DBUtil.close(con);
	}

	public void deleted(int id) {
		String sql="delete from "+table+" where id=?";
		Connection con=DBUtil.getConnection();
		PreparedStatement state=null;
		try {
			state=con.prepareStatement(sql);
			state.setInt(1, id);
			//System.out.println("删除：id="+id);
			state.executeUpdate();
			System.out.println("删除成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}
		DBUtil.close(state);
		DBUtil.close(con);
	}

	public void updated(Legend legend) {
		String sql="update legendtext set name=?,neck=?,type=?,camp=?,context=?,passive=?,skillq=?,skillw=?,skille=?,skillr=? where id=?";
		Connection con=DBUtil.getConnection();
		PreparedStatement pre=null;
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1, legend.getName());
			pre.setString(2, legend.getNeck());
			pre.setString(3, legend.getType());
			pre.setString(4, legend.getCamp());
			pre.setString(5, legend.getContext());
			pre.setString(6, legend.getPassive());
			pre.setString(7, legend.getSkillq());
			pre.setString(8, legend.getSkillw());
			pre.setString(9, legend.getSkille());
			pre.setString(10, legend.getSkillr());
			pre.setInt(11, legend.getId());
			pre.executeUpdate();
			System.out.println("更新完成");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("更新失败");
		}
		DBUtil.close(pre);
		DBUtil.close(con);
	}
	
	public Legend loadById(int id) {
		String sql="select * from legendtext where id=?";
		Connection con=DBUtil.getConnection();
		PreparedStatement state=null;
		ResultSet result=null;
		Legend legend=null;
		try {
			state=con.prepareStatement(sql);
			state.setInt(1,id);
			result=state.executeQuery();
			while(result.next()) {
				legend=new Legend();
				legend.setId(result.getInt("id"));
				legend.setName(result.getString("name"));
				legend.setNeck(result.getString("neck"));
				legend.setType(result.getString("type"));
				legend.setCamp(result.getString("camp"));
				legend.setContext(result.getString("context"));
				legend.setPassive(result.getString("passive"));
				legend.setSkillq(result.getString("skillq"));
				legend.setSkillw(result.getString("skillw"));
				legend.setSkille(result.getString("skille"));
				legend.setSkillr(result.getString("skillr"));
			}
			System.out.println("调出数据");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("调出数据错误");
		}
		DBUtil.close(result);
		DBUtil.close(state);
		DBUtil.close(con);
		return legend;
	}
	
	@Override
 	public Legend loadForName(String name) {
		String sql="select * from legendtext where name like '%"+name+"%'";
		Connection con=DBUtil.getConnection();
		PreparedStatement state=null;
		ResultSet result=null;
		Legend legend=null;
		try {
			state=con.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				legend=new Legend();
				legend.setId(result.getInt("id"));
				legend.setName(result.getString("name"));
				legend.setNeck(result.getString("neck"));
				legend.setType(result.getString("type"));
				legend.setCamp(result.getString("camp"));
				legend.setContext(result.getString("context"));
				legend.setPassive(result.getString("passive"));
				legend.setSkillq(result.getString("skillq"));
				legend.setSkillw(result.getString("skillw"));
				legend.setSkille(result.getString("skille"));
				legend.setSkillr(result.getString("skillr"));
			}
			System.out.println("调出数据");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("调出数据错误");
		}
		DBUtil.close(result);
		DBUtil.close(state);
		DBUtil.close(con);
		
		return legend;
	}

	@Override
	public List<Legend> loadForType(String type) {
		String sql="select * from legendtext where type=?";
		Connection con=DBUtil.getConnection();
		PreparedStatement state=null;
		ResultSet result=null;
		List<Legend> list=new ArrayList<Legend>();
		try {
			state=con.prepareStatement(sql);
			state.setString(1,type);
			result=state.executeQuery();
			while(result.next()) {
				Legend legend=new Legend();
				legend.setId(result.getInt("id"));
				legend.setName(result.getString("name"));
				legend.setNeck(result.getString("neck"));
				legend.setType(result.getString("type"));
				legend.setCamp(result.getString("camp"));
				legend.setContext(result.getString("context"));
				legend.setPassive(result.getString("passive"));
				legend.setSkillq(result.getString("skillq"));
				legend.setSkillw(result.getString("skillw"));
				legend.setSkille(result.getString("skille"));
				legend.setSkillr(result.getString("skillr"));
				list.add(legend);
			}
			System.out.println("调出想同类型数据");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("调出数据错误");
		}
		DBUtil.close(result);
		DBUtil.close(state);
		DBUtil.close(con);
		return list;
	}
	
	public List<Legend> loadAll(){
		String sql="select * from legendtext";
		Connection con=DBUtil.getConnection();
		PreparedStatement state=null;
		ResultSet result=null;
		List<Legend> list=new ArrayList<Legend>();
		try {
			state=con.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				Legend legend=new Legend();
				legend.setId(result.getInt("id"));
				legend.setName(result.getString("name"));
				legend.setNeck(result.getString("neck"));
				legend.setType(result.getString("type"));
				legend.setCamp(result.getString("camp"));
				legend.setContext(result.getString("context"));
				legend.setPassive(result.getString("passive"));
				legend.setSkillq(result.getString("skillq"));
				legend.setSkillw(result.getString("skillw"));
				legend.setSkille(result.getString("skille"));
				legend.setSkillr(result.getString("skillr"));
				list.add(legend);
			}
			System.out.println("调出全部数据");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("调出全部数据错误");
		}
		DBUtil.close(result);
		DBUtil.close(state);
		DBUtil.close(con);
		return list;
	}
	
	@Override
	public List<Legend> load(String condition, String value) {
		Legend legend=null;
		List<Legend>list=new ArrayList<Legend>();
		if(condition.equals("name")) {
			legend=loadForName(value);
			list.add(legend);
		}else{
			 if(value.equals("all")) {
				 list=loadAll();
			 }
			 else {
				 list=loadForType(value);
			 }
		}
		return list;
	}

}
