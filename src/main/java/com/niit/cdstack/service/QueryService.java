package com.niit.cdstack.service;

import java.util.List;

import com.niit.cdstack.model.Query;

public interface QueryService {

	void addQuery(Query q);
	List<Query>viewQuries();
	void deleteQuery(String id);
}
