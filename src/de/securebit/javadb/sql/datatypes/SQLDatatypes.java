package de.securebit.javadb.sql.datatypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLDatatypes {
	
	public static final String BLOB = "BLOB";
	
	public static final String INTEGER = "INT";
	
	public static final String BIG_INTEGER = "BIGINT";
	
	public static final String SMALL_INTEGER = "SMALLINT";
	
	public static final String FLOAT = "FLOAT";
	
	public static final String DOUBLE = "DOUBLE";
	
	public static final String REAL = "REAL";
	
	public static final String VARCHAR = "VARCHAR";
	
	
	public static class SQLDatatype {
		
		private String name;
		
		private int[] parameters;
		
		private List<SQLDatatypeAttributes> attributes;
		
		public SQLDatatype(String name, int... parameters) {
			this.name = name;
			this.parameters = parameters;
			this.attributes = new ArrayList<>();
		}
		
		public String getName() {
			return this.name;
		}
		
		public int[] getParameters() {
			return this.parameters;
		}
		
		public List<SQLDatatypeAttributes> getAttributes() {
			return Collections.unmodifiableList(this.attributes);
		}
		
		public void addAttribute(SQLDatatypeAttributes attr) {
			this.attributes.add(attr);
		}
		
		public void removeAttribute(SQLDatatypeAttributes attr){
			this.attributes.remove(attr);
		}
		
		public String asString() {
			return this.asString(false, false);
		}
		
		public String asString(boolean withParams) {
			return this.asString(withParams, false);
		}
		
		public String asString(boolean withParams, boolean withAttributes) {
			String result = this.name;
			
			if (withParams && this.parameters.length != 0) {
				result = result + "(";
				
				for (int i = 0; i < this.parameters.length; i++) {
					result = result + i + ",";
				}
				
				result = result.substring(0, result.length() - 1) + ")";
			}
			
			if (withAttributes && this.attributes.size() > 0) {
				for (int i = 0; i < this.attributes.size(); i++) {
					result += " " + this.attributes.get(i).getName();
				}
			}
			
			return result;
		}
		
	}
	
	public static enum SQLDatatypeAttributes {
		
		AUTO_INCREMENT("auto_increment");
		
		private String name;
		
		private SQLDatatypeAttributes(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
	}
	
}
