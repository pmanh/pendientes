package pmh.service;

import java.util.List;

import pmh.model.Type;

public interface TypeService {
	public List<Type> get(Type obj);
	
	public void save(Type obj);
	
	public boolean delete (int id);
}
    