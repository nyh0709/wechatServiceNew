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
import com.nyh.app.util.StringUtil;

/**
 * 功能：
 * 取得数据库表接口IDHelper，mysql的实现
 *
 */
public class MySqlHelper implements IDbHelper {
	
	String sqlColumns="select * from information_schema.columns where table_schema=DATABASE() and table_name='%s' ";
	
	String sqlComment ="select table_name,table_comment  from information_schema.tables t where t.table_schema=DATABASE() and table_name='%s' ";
	
	String sqlAllTable="select table_name,table_comment from information_schema.tables t where t.table_schema=DATABASE()";
	
	private String url="";
	private String username="";
	private String password="";
	
	public MySqlHelper() throws CodegenException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new CodegenException("找不到mysql驱动!", e);
		}
	}

	
	public void setUrl(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		
	}

	/**
	 * 根据表名取得表对象数据
	 */
	
	public TableModel getByTable(String tableName) throws CodegenException {
		TableModel tableModel= getTableModel(tableName);
		List<ColumnModel> colList=getColumnsByTable(tableName);
		tableModel.setColumnList(colList);
		return tableModel;
	}
	
	/**
	 * 根据表名取得表的列数据
	 * @param tableName
	 * @return
	 * @throws CodegenException
	 */
	private List<ColumnModel> getColumnsByTable(String tableName) throws CodegenException
	{
		DaoHelper<ColumnModel> dao=new DaoHelper<ColumnModel>(this.url, this.username, this.password);
		String sql=String.format(sqlColumns,tableName);
		List<ColumnModel> list=dao.queryForList(sql, new MySqlMapCmd());
		return list;
	}
	
	/**
	 * 根据表名取得tablemodel对象
	 * @param tableName
	 * @return
	 * @throws CodegenException
	 */
	private TableModel getTableModel(final String tableName) throws CodegenException
	{
		TableModel tablemodel=new TableModel();
		DaoHelper<String> dao=new DaoHelper<String>(this.url, this.username, this.password);
		String sql=String.format(sqlComment, tableName);
		String comment= dao.queryForObject(sql, new MapCmd<String>() {
			
			public String getObjecFromRs(ResultSet rs) throws SQLException {
				String comment=rs.getString("table_comment");
				return comment;
			}
		});
		
		tablemodel.setTableName(tableName);
		
		if(StringUtil.isEmpty(comment))
			comment=tableName;
		if(comment.startsWith("InnoDB free")){
			comment=tableName;
			tablemodel.setTabComment(comment);
		}
		else{
			if(comment.indexOf(";")!=-1)
			{
				int pos=comment.indexOf(";");
				comment=comment.substring(0,pos);
			}
			String[] aryComment=comment.split("\n");
			tablemodel.setTabComment(aryComment[0]);
		}
		
		
		
		return tablemodel;
	}
	
	
	
	
	/**
	 * 取得当前数据库的所有表
	 */
	
	public List<String> getAllTable() throws CodegenException {
		
		DaoHelper<String> dao=new DaoHelper<String>(this.url, this.username, this.password);
		List<String> list= dao.queryForList(sqlAllTable, new MapCmd<String>() {
			
			public String getObjecFromRs(ResultSet rs) throws SQLException {
				return rs.getString("table_name");
			}
		});
		return list;
	}
	
	public static void main(String[] args) throws CodegenException
	{
		
		MySqlHelper helper=new MySqlHelper();
		helper.setUrl("jdbc:mysql://192.168.1.8:3306/bpm?useUnicode=true&amp;characterEncoding=utf-8", "root", "root");
		TableModel table= helper.getByTable("act_ru_task");
		System.out.println("ok");
	}
	
	
	

}
