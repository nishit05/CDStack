package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Query;

@Repository
public interface QueryDAO {
void addQuery(Query q);
List<Query>viewQueries();
void deleteQuery(String id);
}
