package pmh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmh.dao.TypeDAO;
import pmh.model.Type;
import pmh.repository.TypeRepostory;
import pmh.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService{
	
    @Autowired
	private TypeRepostory typeRepostory;

	public List<Type> get(Type obj) {
		return typeRepostory.findAll();
	}

	public void save(Type obj) {
	    typeRepostory.save(obj);
	}

	public boolean delete(int id) {
	    Type type = typeRepostory.findOne(id);
	    if(type != null){
	        typeRepostory.delete(id);
	        return true;
	    }
		return false;
	}

}
