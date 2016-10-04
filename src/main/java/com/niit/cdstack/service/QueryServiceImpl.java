package com.niit.cdstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cdstack.dao.QueryDAO;
import com.niit.cdstack.model.Query;

@Service
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryDAO querydao;

	@Override
	public void addQuery(Query q) {
		// TODO Auto-generated method stub
		querydao.addQuery(q);
	}

}
