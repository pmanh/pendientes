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

	@Override
	public List<Type> get(Type obj) {
		return typeDAO.get(obj);
	}

	@Override
	public void save(Type obj) {
		typeDAO.save(obj);
	}

	@Override
	public boolean delete(int id) {
		return typeDAO.delete(id);
	}

}
