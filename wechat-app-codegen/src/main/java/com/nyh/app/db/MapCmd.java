package com.nyh.app.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MapCmd<T> {
	public T getObjecFromRs(ResultSet rs) throws SQLException;
}
