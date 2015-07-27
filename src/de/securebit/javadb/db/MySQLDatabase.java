package de.securebit.javadb.db;

public interface MySQLDatabase extends SQLDatabase {
	
	@Override
	public default String getConnectionPrefix() {
		return "jdbc:mysql:";
	}
	
	@Override
	public default boolean isSupportPresent(DBSupport feature) {
		switch (feature) {
			case TRANSACTIONS:
				return true;
			}
		
		return false;
	}
	
	public abstract String getUsername();
	
	public abstract String getPassword();
	
	
	public static class MySqlIP {
		
		private String host;
		private int port;
		
		public MySqlIP() {
			this("localhost");
		}
		
		public MySqlIP(String host) {
			this(host, 3306);
		}
		
		public MySqlIP(String ip, int port) {
			this.host = ip;
			this.port = port;
		}
		
		public String getIP() {
			return this.host;
		}
		
		public int getPort() {
			return this.port;
		}
		
		public String asString() {
			return "//" + this.host + ":" + Integer.toString(this.port);
		}
		
		@Override
		public String toString() {
			return this.getClass().getName() + "(Connection:" + this.asString() + ")";
		}
		
	}
	
}
