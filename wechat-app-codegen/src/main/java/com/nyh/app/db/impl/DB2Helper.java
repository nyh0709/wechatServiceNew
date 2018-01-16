package com.nyh.app.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.nyh.app.db.DaoHelper;
import com.nyh.app.db.IDbHelper;
import com.nyh.app.db.MapCmd;
import com.nyh.app.exception.CodegenException;
import com.nyh.app.model.ColumnModel;
import com.nyh.app.model.TableModel;

/**
 * 取得数据库表接口IDHelper，DB2的实现	
 *
 */
public class DB2Helper implements IDbHelper {

	// 取得主键
	private String sqlPk = 
			"SELECT "+ 
					"TABNAME TAB_NAME, "+
					"COLNAME COL_NAME, "+
					"KEYSEQ  "+
				"FROM  "+
					"SYSCAT.COLUMNS "+ 
				"WHERE  "+
					"TABSCHEMA='BPMX380' AND KEYSEQ>0 AND UPPER(TABNAME) = UPPER('%s')";
	// 取得注释
	private String sqlTableComment = 
		"SELECT  "+
			"TABNAME, "+
			"REMARKS "+
		"FROM  "+
			"SYSCAT.TABLES "+
		"WHERE "+
			"TABSCHEMA IN (SELECT CURRENT SCHEMA FROM SYSIBM.DUAL) "+
			"AND UPPER(TABNAME) = UPPER('%s') ";
	// 取得列表
	private String sqlColumn = 
			"SELECT "+ 
					"TABNAME, "+
					"COLNAME, "+
					"TYPENAME, "+
					"REMARKS, "+
					"NULLS, "+
					"LENGTH, "+
					"SCALE, "+
					"KEYSEQ  "+
				"FROM  "+
					"SYSCAT.COLUMNS "+ 
				"WHERE  "+
					"TABSCHEMA IN (SELECT CURRENT SQLID FROM SYSIBM.DUAL) "+
					"AND UPPER(TABNAME) = UPPER('%s') ";
				
	// 取得数据库所有表
	private String sqlAllTables =
				"SELECT  "+
					"TABNAME, "+
					"REMARKS "+
				"FROM  "+
					"SYSCAT.TABLES "+
				"WHERE  "+
					"TABSCHEMA IN (SELECT CURRENT SQLID FROM SYSIBM.DUAL) ";

	private String url;
	private String username;
	private String password;
	
	public DB2Helper() throws CodegenException {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			throw new CodegenException("找不到DB2驱动!", e);
		}
	}
	
	public void setUrl(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * 取得表注释
	 * @param tableName
	 * @return
	 * @throws CodegenException
	 */
	private String getTableComment(String tableName) throws CodegenException {
		tableName=tableName.toUpperCase();
		
		String sql = String.format(sqlTableComment, tableName);
		DaoHelper<String> dao=new DaoHelper<String>(url, username, password);
		String comment= dao.queryForObject(sql,new MapCmd<String>() {
			public String getObjecFromRs(ResultSet rs) throws SQLException {
				return rs.getString("REMARKS");
			}
		});
		return comment==null?tableName:comment;

	}
	
	/**
	 * 取得表名取得列列表
	 * @param tableName
	 * @return
	 * @throws CodegenException
	 */
	private List<ColumnModel> getColumnsByTable(String tableName) throws CodegenException
	{
		tableName=tableName.toUpperCase();
		DaoHelper<ColumnModel> dao=new DaoHelper<ColumnModel>(this.url, this.username, this.password);
		String sql=String.format(sqlColumn,tableName);
		List<ColumnModel> list=dao.queryForList(sql, new DB2MapCmd());
		return list;
	}
	/**
	 * 根据表名取得表对象
	 */
	public TableModel getByTable(String tableName) throws CodegenException {
		tableName=tableName.toUpperCase();
		//取得注释
		String tabComment=getTableComment(tableName);
//		String pk=getPk(tableName);
		
		TableModel tableModel = new TableModel();
		tableModel.setTableName(tableName);
		tableModel.setTabComment(tabComment);
		//取得表的列表数据
		List<ColumnModel> list=getColumnsByTable(tableName);
		tableModel.setColumnList(list);
 
		return tableModel;
	}

	
	public List<String> getAllTable() throws CodegenException {
		DaoHelper<String> dao=new DaoHelper<String>(url, username, password);
		return dao.queryForList(sqlAllTables,new  MapCmd<String>() {
			public String getObjecFromRs(ResultSet rs) throws SQLException {
				return rs.getString("TABNAME");
			}
		});
	}

}
