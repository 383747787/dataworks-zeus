package com.taobao.zeus.store.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.taobao.zeus.model.WorkerGroupCache;
import com.taobao.zeus.store.WorkerManager;
import com.taobao.zeus.store.mysql.persistence.WorkerGroupPersistence;
import com.taobao.zeus.store.mysql.persistence.WorkerRelationPersistence;
@SuppressWarnings("unchecked")
public class MysqlWokerManager extends HibernateDaoSupport implements WorkerManager{

	@Override
	public List<WorkerRelationPersistence> getAllWorkerRelations() {
		return (List<WorkerRelationPersistence>)getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from com.taobao.zeus.store.mysql.persistence.WorkerRelationPersistence");
				return query.list();
			}
			
		});		
	}

	@Override
	public List<WorkerGroupCache> getAllWorkerGroupInfomations() {
		List<WorkerGroupCache> informations = new ArrayList<WorkerGroupCache>();
		List<WorkerGroupPersistence> workergroups = getAllWorkerGroup();
		List<WorkerRelationPersistence> relations = getAllWorkerRelations();
		for(WorkerGroupPersistence wg : workergroups){
			WorkerGroupCache info = new WorkerGroupCache();
			info.setId(wg.getId());
			if (wg.getEffective() == 1) {
				info.setEffective(true);
			}else {
				info.setEffective(false);
			}
			info.setName(wg.getName());
			info.setDescription(wg.getDescription());
			List<String> hosts = new ArrayList<String>();
			for(WorkerRelationPersistence r : relations){
				if (wg.getId() == r.getWorkerGroupId()) {
					hosts.add(r.getHost());
				}
			}
			info.setHosts(hosts);
			informations.add(info);
		}
		return informations;
	}
	@Override
	public List<WorkerGroupPersistence> getAllWorkerGroup(){
		return (List<WorkerGroupPersistence>)getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from com.taobao.zeus.store.mysql.persistence.WorkerGroupPersistence");
				return query.list();
			}
			
		});	
	}

}
