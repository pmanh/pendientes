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

import pmh.model.Pending;

//@Component
public class PendingDAO {

	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Pending> get(Pending obj){
		Session session = sessionFactory.openSession();	
		Transaction tx = session.beginTransaction();
		Criteria sqlCriteria = session.createCriteria(Pending.class);
		if(obj.getIdType() != null && obj.getIdType().getId() != 0){
			sqlCriteria.add(Restrictions.eq("idType", obj.getIdType()));
		}
		if(obj.getId() != 0){
			sqlCriteria.add(Restrictions.eq("id", obj.getId()));
		}		
		List<Pending> list = sqlCriteria.list();
		tx.commit();
		session.close();
		return list;
	}
	
	public void save(Pending obj){
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
			session.delete((Pending) session.load(Pending.class, id));
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
