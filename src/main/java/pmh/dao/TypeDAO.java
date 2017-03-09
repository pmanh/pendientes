package pmh.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pmh.model.Type;

//@Component
public class TypeDAO {
	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Type> get(Type obj){
		Session session = sessionFactory.openSession();	
		Transaction tx = session.beginTransaction();
		Criteria sqlCriteria = session.createCriteria(Type.class);
		if(obj.getType() != null && !obj.getType().isEmpty()){
			sqlCriteria.add(Restrictions.eq("type", obj.getType()));
		}
		if(obj.getId() != 0){
			sqlCriteria.add(Restrictions.eq("id", obj.getId()));
		}		
		List<Type> list = sqlCriteria.list();
		tx.commit();
		session.close();
		return list;
	}
	
	public void save(Type obj){
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.saveOrUpdate(obj);
			transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}		
	}
	
	public boolean delete(int id){
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.delete((Type) session.load(Type.class, id));
			transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}finally {
			session.close();
		}
		return true;
	}
}
