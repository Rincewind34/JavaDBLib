package de.securebit.javadb.db;


public interface SQLiteDatabase extends SQLDatabase {
	
	@Override
	public default String getConnectionPrefix() {
		return "jdbc:sqlite:";
	}
	
	@Override
	public default boolean isSupportPresent(DBSupport feature) {
		switch (feature) {
			case TRANSACTIONS:
				return false;
		}
		
		return false;
	}
}
