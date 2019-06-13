package per.sun.dao;

import java.util.List;

import per.sun.modal.Legend;

public interface LegendDao {
	
	void add(Legend legend);
	
	void deleted(int id);
	
	void updated(Legend legend);
	
	//查
	Legend loadById(int id);
	List<Legend> load(String condition,String value);
	List<Legend> loadAll();
	Legend loadForName(String name);
	List<Legend> loadForType(String type);
}
