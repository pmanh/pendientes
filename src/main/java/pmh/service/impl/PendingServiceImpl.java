package pmh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmh.dao.PendingDAO;
import pmh.model.Pending;
import pmh.repository.PendingRepository;
import pmh.service.PendingService;

@Service("pendingService")
public class PendingServiceImpl implements PendingService{
	@Autowired
	private PendingRepository pendingRepository;
	
	public List<Pending> get(Pending obj){
		return pendingRepository.findAll();
	}
	
	public void save(Pending obj){
	    pendingRepository.save(obj);
	}
	
	public boolean delete(int id){
	    Pending pending = pendingRepository.findOne(id);
	    if(pending != null){
	        pendingRepository.delete(pending);
	        return true;
	    }
		return false;
	}
	
}
