package com.nyh.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigModel {
	private String charset;
	private Database database;
	private Map<String, String> variables = new HashMap<String, String>();
	private Templates templates;
	private List<Table> tables = new ArrayList<Table>();
	private Files files = new Files();

	private GenAll genAll;


	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}


	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	
	public Map<String, String> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}

	public Templates getTemplates() {
		return templates;
	}

	public void setTemplates(Templates templates) {
		this.templates = templates;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public GenAll getGenAll() {
		return genAll;
	}

	public void setGenAll(GenAll genAll) {
		this.genAll = genAll;
	}

	public class Database {
		private String dbHelperClass;
		private String url;
		private String username;
		private String password;

		public Database(String dbHelperClass, String url, String username,
				String password) {
			this.dbHelperClass = dbHelperClass;
			this.url = url;
			this.username = username;
			this.password = password;
		}

		
		public String getDbHelperClass() {
			return dbHelperClass;
		}

		public void setDbHelperClass(String dbHelperClass) {
			this.dbHelperClass = dbHelperClass;
		}

		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

	public class Templates {
		private String basepath;
		private Map<String, String> template = new HashMap<String, String>();

		public Templates(String basepath) {
			this.basepath = basepath;
		}

		
		public String getBasepath() {
			return basepath;
		}

		public void setBasepath(String basepath) {
			this.basepath = basepath;
		}

		
		public Map<String, String> getTemplate() {
			return template;
		}

		public void setTemplate(Map<String, String> template) {
			this.template = template;
		}

	}

	
	public class Files {
		private String baseDir = "";
		private List<File> files = new ArrayList<File>();

		
		public String getBaseDir() {
			return baseDir;
		}

		public void setBaseDir(String baseDir) {
			this.baseDir = baseDir;
		}

		public void addFile(String template, String fileName, String dir,
				boolean sub, boolean override, boolean append,
				String insertTag, String startTag, String endTag) {
			File file = new File(template, fileName, dir, sub, override,
					append, insertTag, startTag, endTag);
			this.files.add(file);
		}

		
		public List<File> getFiles() {
			return files;
		}

		public void setFiles(List<File> file) {
			this.files = file;
		}

		public class File {
			private String template;
			private String filename;
			private String dir;
			private boolean sub = false;
			private boolean override = false;
			private boolean append = false;
			private String insertTag = "";
			private String startTag = "start{tabname}";
			private String endTag = "end{tabname}";

			public File(String template, String filename, String dir,
					boolean sub, boolean override, boolean append,
					String insertTag, String startTag, String endTag) {
				this.template = template;
				this.filename = filename;
				this.dir = dir;
				this.sub = sub;
				this.append = append;
				this.insertTag = insertTag;
				this.startTag = startTag;
				this.endTag = endTag;
				this.override = override;
			}

			
			public String getTemplate() {
				return template;
			}

			public void setTemplate(String template) {
				this.template = template;
			}

			public boolean isSub() {
				return sub;
			}

			public void setSub(boolean sub) {
				this.sub = sub;
			}

			public boolean isOverride() {
				return override;
			}

			public void setOverride(boolean sub) {
				this.override = override;
			}

			
			public String getFilename() {
				return filename;
			}

			public void setFilename(String filename) {
				this.filename = filename;
			}

			
			public String getDir() {
				return dir;
			}

			public void setDir(String dir) {
				this.dir = dir;
			}

			public boolean getAppend() {
				return append;
			}

			public void setAppend(boolean append) {
				this.append = append;
			}

			public String getInsertTag() {
				return insertTag;
			}

			public void setInsertTag(String insertTag) {
				this.insertTag = insertTag;
			}

			public String getStartTag() {
				return startTag;
			}

			public void setStartTag(String startTag) {
				this.startTag = startTag;
			}

			public String getEndTag() {
				return endTag;
			}

			public void setEndTag(String endTag) {
				this.endTag = endTag;
			}

		}
	}

	public class Table {

		private String tableName;
		private Map<String, String> variable = new HashMap<String, String>();
		
		private List<SubTable> subtable = new ArrayList<SubTable>();

		public Table(String tableName) {
			this.tableName = tableName;
		}

		
		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public void addSubTable(String tableName, String foreignKey,
				Map<String, String> vars) {
			SubTable sb = new SubTable(tableName, foreignKey, vars);
			this.subtable.add(sb);
		}

		
		public Map<String, String> getVariable() {
			return variable;
		}

		public void setVariable(Map<String, String> variable) {
			this.variable = variable;
		}

		
		public List<SubTable> getSubtable() {
			return subtable;
		}

		public void setSubtable(List<SubTable> subtable) {
			this.subtable = subtable;
		}

		public class SubTable {
			private String tableName;
			private String foreignKey;
			private Map<String, String> vars = new HashMap<String, String>();

			public SubTable(String tableName, String foreignKey,
					Map<String, String> vars) {
				this.tableName = tableName;
				this.foreignKey = foreignKey;
				this.vars = vars;
			}

			public String getTableName() {
				return tableName;
			}

			public void setTableName(String tableName) {
				this.tableName = tableName;
			}

			public String getForeignKey() {
				return foreignKey;
			}

			public void setForeignKey(String foreignKey) {
				this.foreignKey = foreignKey;
			}

			public Map<String, String> getVars() {
				return vars;
			}

			public void setVars(Map<String, String> vars) {
				this.vars = vars;
			}

		}
	}

	public class GenAll {
		private String tableNames;
		private List<File> file = new ArrayList<File>();

		public GenAll(String tableNames) {
			this.tableNames = tableNames;
		}

		public String getTableNames() {
			return tableNames;
		}

		public void setTableNames(String tableNames) {
			this.tableNames = tableNames;
		}

		public List<File> getFile() {
			return file;
		}

		public void setFile(List<File> file) {
			this.file = file;
		}

		public class File {
			private String template;
			private String filename;
			private String extName;
			private String dir;
			private String genMode;
			private String sub;
			private Map<String, String> variable = new HashMap<String, String>();

			public File(String template, String filename, String extName,
					String dir, String genMode) {
				this.template = template;
				this.filename = filename;
				this.extName = extName;
				this.dir = dir;
				this.genMode = genMode;
			}

			public String getSub() {
				return sub;
			}

			public void setSub(String sub) {
				this.sub = sub;
			}

			
			public String getTemplate() {
				return template;
			}

			public void setTemplate(String template) {
				this.template = template;
			}

			
			public String getFilename() {
				return filename;
			}

			public void setFilename(String filename) {
				this.filename = filename;
			}

			
			public String getExtName() {
				return extName;
			}

			public void setExtName(String extName) {
				this.extName = extName;
			}

			
			public String getDir() {
				return dir;
			}

			public void setDir(String dir) {
				this.dir = dir;
			}

			
			public String getGenMode() {
				return genMode;
			}

			public void setGenMode(String genMode) {
				this.genMode = genMode;
			}

			
			public Map<String, String> getVariable() {
				return variable;
			}

			public void setVariable(Map<String, String> variable) {
				this.variable = variable;
			}

		}
	}
}
