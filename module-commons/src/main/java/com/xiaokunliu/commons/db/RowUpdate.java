package com.xiaokunliu.commons.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowUpdate {

    void reply(ResultSet rs) throws SQLException;

}
