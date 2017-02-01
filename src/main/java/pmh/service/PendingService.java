package pmh.service;

import java.util.List;

import pmh.model.Pending;

public interface PendingService {
	public List<Pending> get(Pending obj);
	
	public void save(Pending obj);
	
	public boolean delete(int id);
}
