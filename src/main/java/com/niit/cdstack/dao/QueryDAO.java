package com.niit.cdstack.dao;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Query;

@Repository
public interface QueryDAO {
void addQuery(Query q);
}
