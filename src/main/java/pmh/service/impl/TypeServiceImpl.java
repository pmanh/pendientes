package pmh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmh.dao.TypeDAO;
import pmh.model.Type;
import pmh.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService{
	@Autowired
	private TypeDAO typeDAO;

	public List<Type> get(Type obj) {
		return typeDAO.get(obj);
	}

	public void save(Type obj) {
		typeDAO.save(obj);
	}

	public boolean delete(int id) {
		return typeDAO.delete(id);
	}

}
