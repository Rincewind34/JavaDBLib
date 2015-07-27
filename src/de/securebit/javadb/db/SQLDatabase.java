package de.securebit.javadb.db;

import java.sql.Connection;

import de.securebit.javadb.Database;
import de.securebit.javadb.sql.Table;

public interface SQLDatabase extends Database {
	
	public abstract void deleteTable(String name);
	
	public abstract void createTable(String name);
	
	public abstract String getConnectionPrefix();
	
	public abstract Table getTable(String name);
	
	public abstract Connection getConnection();
	
}
