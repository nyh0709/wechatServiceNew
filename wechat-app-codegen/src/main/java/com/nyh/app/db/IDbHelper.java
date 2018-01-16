package com.nyh.app.db;

import java.util.List;

import com.nyh.app.exception.CodegenException;
import com.nyh.app.model.TableModel;

public interface IDbHelper {
	void setUrl(String url, String username, String password);
	TableModel getByTable(String tableName) throws CodegenException;
	List<String> getAllTable() throws CodegenException;
}
