package com.hnatourism.club.golf.api;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IApiDao {
	@SuppressWarnings("unchecked")
	public  Object  handler(String [] methods,HashMap<String, List<Map>> hm) throws SQLException, Exception;
}
