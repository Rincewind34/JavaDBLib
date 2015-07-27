package de.securebit.javadb;

import de.securebit.javadb.db.DBSupport;
import de.securebit.javadb.exceptions.DatabaseException;

public interface Database {
	
	/**
	 * Open a new database connection to this database.
	 * If there is already a connection, this method will do nothing.
	 * @throws DatabaseException Is thrown if it was not possible to connect (denied access for example)
	 */
	public abstract void connect() throws DatabaseException;
	
	/**
	 * Close the connection to this database, if valid.
	 * If there is no open connection, an exception will be thrown.
	 * @throws DatabaseException Is thrown when no open connection exists
	 */
	public abstract void disconnect() throws DatabaseException;
	
	/**
	 * Check the connection.
	 * Return <b>true</b> if the connection is open, else <b>false</b>. 
	 * @return true if there is an open connection, else false
	 */
	public abstract boolean isConnected();
	
	/**
	 * Check if the given feature is available in this database.
	 * @param feature The feature to check
	 * @return true if the feature is available, else false
	 */
	public abstract boolean isSupportPresent(DBSupport feature);
	
	/**
	 * Get the name of this database.
	 * @return The name of this database or the file-name if you're using a flat-file database (e.g. SQLite)
	 */
	public abstract String getName();
	
}
