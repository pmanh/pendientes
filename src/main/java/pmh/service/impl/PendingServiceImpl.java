package pmh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmh.dao.PendingDAO;
import pmh.model.Pending;
import pmh.service.PendingService;

@Service("pendingService")
public class PendingServiceImpl implements PendingService{
	@Autowired
	private PendingDAO pendingDAO;
	
	public List<Pending> get(Pending obj){
		return pendingDAO.get(obj);
	}
	
	public void save(Pending obj){
		pendingDAO.save(obj);
	}
	
	public boolean delete(int id){
		return pendingDAO.delete(id);
	}
	
}
