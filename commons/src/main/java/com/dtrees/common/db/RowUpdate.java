package com.dtrees.common.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowUpdate {
	
	public void reply(ResultSet rs) throws SQLException;

}
