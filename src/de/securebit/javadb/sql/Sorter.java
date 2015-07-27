package de.securebit.javadb.sql;

import de.securebit.javadb.sql.Table.TableColumn;

public class Sorter {
	
	private OrderType type;
	
	private TableColumn column;
	
	public Sorter(OrderType type, TableColumn column) {
		this.type = type;
		this.column = column;
	}
	
	public TableColumn getColumn() {
		return this.column;
	}
	
	public OrderType getType() {
		return this.type;
	}
	
	public String asString() {
		return "ORDER BY " + this.column.getName() + " " + this.type.getRawText();
	}
	
	
	public static enum OrderType {
		
		ASCENDING("ASC"),
		DESCENDING("DESC");
		
		private String rawText;
		
		private OrderType(String rawText) {
			this.rawText = rawText;
		}
		
		public String getRawText() {
			return this.rawText;
		}
		
	}
	
}
