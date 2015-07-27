package de.securebit.javadb.sql;

import de.securebit.javadb.sql.Table.TableColumn;

public class WhereClausel {
	
	private String result;
	
	public WhereClausel(WhereCondition condition) {
		this.result = condition.asString();
	}
	
	public WhereClausel add(WhereCondition condition, WhereLogicOperator operator) {
		this.result = operator.getRawText() + " " + condition.asString();
		return this;
	}
	
	public String build() {
		return "WHERE " + this.result;
	}
	
	
	public static class WhereCondition {
		
		private TableColumn column;
		private String value;
		private WhereComperator comperator;
		
		public WhereCondition(TableColumn column, String value, WhereComperator comperator) {
			this.column = column;
			this.value = value;
			this.comperator = comperator;
		}
		
		public TableColumn getColumn() {
			return this.column;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public WhereComperator getComperator() {
			return this.comperator;
		}
		
		public String asString() {
			return this.column.getName() + " " + this.comperator.getRawText() + " " + this.value;
		}
		
	}
	
	public static enum WhereComperator {
		
		EQUALS("="),
		BIGGER(">"),
		SMALLER("<"),
		NOT_EQUALS("!=");
		
		private String rawText;
		
		private WhereComperator(String rawText) {
			this.rawText = rawText;
		}
		
		public String getRawText() {
			return this.rawText;
		}
		
	}
	
	public static enum WhereLogicOperator {
		
		NOT("NOT"),
		AND("AND"),
		OR("OR");
		
		private String rawText;
		
		private WhereLogicOperator(String rawText) {
			this.rawText = rawText;
		}
		
		public String getRawText() {
			return this.rawText;
		}
		
	}
	
}
