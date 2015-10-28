package com.allen.springmvc.angular.basic.dao;


import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.allen.springmvc.angular.utils.Pagination;





/**
 * 作用的CRUD,后期扩展
 * 
 * @author Admin
 * 
 */
public abstract class MongoDao<T, PK> {

	private MongoTemplate mongoTemplate;
	private String collectionName;
	private Class<T> tclass;

	public abstract void setInit();

	
	/**
	 * 分页
	 * @param pageNo 第几页
	 * @param pageSize  页面数据
	 * @param query  查询条件
	 * @return
	 */
	public Pagination<T> getPage(int pageNo, int pageSize, Query query) {
		long totalCount = mongoTemplate.count(query,collectionName );
		Pagination<T> page = new Pagination<T>(pageNo, pageSize, totalCount);
		query.skip(page.getFirstResult());// skip相当于从那条记录开始
		query.limit(pageSize);// 从skip开始,取多少条记录
		List<T> datas = mongoTemplate.find(query,tclass,collectionName);
		page.setDatas(datas);
		return page;
	}

	private Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @throws IllegalAccessException
	 */
	protected void deleteKey(PK id) {
		if (id == null) {
			throw new IllegalStateException(tclass.getName() + "id不能为空");
		}
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		mongoTemplate.remove(query, collectionName);
	}

	/**
	 * 根据ids批量删除
	 * 
	 * @param id
	 * @throws IllegalAccessException
	 */
	protected void deleteBatchKey(PK... ids) {
		if (ids == null) {
			throw new IllegalStateException(tclass.getName() + "ids不能为空");
		}
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").in(ids));
		mongoTemplate.remove(query, collectionName);
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	protected T getByKey(PK id) {
		if (id == null) {
			return null;
		}
		return mongoTemplate.findById(id, tclass, collectionName);
	}

	protected List<T> findAll() {
		return mongoTemplate.findAll(tclass, collectionName);
	}
	/**
	 * 插入多条数据
	 * 
	 * @param ts
	 * @param companyId
	 */
	protected void insertBatch(Collection<T> ts) {
		mongoTemplate.insert(ts, collectionName);
	}

	protected void update(T t) {
		mongoTemplate.save(t, collectionName);
	}

	protected void insert(T t) {
		mongoTemplate.insert(t, collectionName);
	}

	public void setTemplate(MongoTemplate template) {
		this.mongoTemplate = template;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setTclass(Class<T> tclass) {
		this.tclass = tclass;
	}
}
