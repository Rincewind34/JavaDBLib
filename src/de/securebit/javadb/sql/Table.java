package de.securebit.javadb.sql;

import de.securebit.javadb.exceptions.TableException;
import de.securebit.javadb.sql.datatypes.SQLDatatypes.SQLDatatype;

public interface Table {
	
	/*
	 * SELECT * FROM <table> ORDER BY score DESC
	 * SELECT * FROM <table> ORDER BY score ASC
	 */
	
	public abstract void rename(String newName);
	
	/* INSERT INTO accounts (username, password) VALUES (Rincewind, secret) */
	public abstract boolean insert(TableInsertation<?>... inserts); // INSERT INTO <table> <structure -> (id, username)> 
	
	/* UPDATE <table> SET score = score + 50 WHERE username = Rincewind */
	public abstract boolean update();
	
	public abstract boolean delete();
	
	/* SELECT * FROM accounts */
	public abstract boolean select(WhereClausel whereClausel, Sorter sorter, Limit limit, TableColumn... columns);
	
	public abstract String getName();
	
	public abstract TableStructure getStructure();
	
	public abstract TableColumn getColumn(String name);
	
	public abstract TableColumn getColumn(int index);
	
	public default void test() {
		this.insert(new TableInsertation<String>(this.getColumn("username"), "Rincewind"));
	}
	
	
	public static class TableStructure {
		
		private TableColumn[] columns;
		
		public TableStructure(TableColumn... types) {
			if (types.length == 0) {
				throw new TableException("You need at least one column!");
			}
		}
		
		public TableColumn[] getTypes() {
			return this.columns;
		}
		
		public int getColumnCount() {
			return this.columns.length;
		}
		
		public SQLDatatype[] asTypeArray() {
			SQLDatatype[] types = new SQLDatatype[this.getColumnCount()];
			
			for (int i = 0; i < this.getColumnCount(); i++) {
				types[i] = this.columns[i].getType();
			}
			
			return types;
		}
		
		public String asString() {
			String result = "(";
			
			for (int i = 0; i < this.getColumnCount(); i++) {
				result = result + this.columns[i].asString(true, true) + ", ";
			}
			
			return result.substring(0, result.length() - 2) + ")";
		}
		
	}
	
	public static class TableColumn {
		
		private String name;
		
		private SQLDatatype type;
		
		public TableColumn(String name, SQLDatatype type) {
			this.type = type;
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public SQLDatatype getType() {
			return this.type;
		}
		
		public String asString() {
			return this.name + " " + this.type.asString();
		}
		
		public String asString(boolean withParams) {
			return this.name + " " + this.type.asString(withParams);
		}
		
		public String asString(boolean withParams, boolean withAttr) {
			return this.name + " " + this.type.asString(withParams, withAttr);
		}
		
	}
	
	public static class TableInsertation<T> {
		
		private T value;
		private TableColumn column;
		
		public TableInsertation(TableColumn column, T value) {
			this.value = value;
			this.column = column;
		}
		
		public T getValue() {
			return this.value;
		}
		
		public TableColumn getColumn() {
			return this.column;
		}
		
	}
}
