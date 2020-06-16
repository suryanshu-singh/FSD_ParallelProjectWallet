package com.ibm.walletSpringCore.Wallet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("multipleDao")
public class NamedParameterSupportDemo extends NamedParameterJdbcDaoSupport {
	
	public String getUserName(int id) {
		return getNamedParameterJdbcTemplate().queryForObject("select name from customerdetails where accountnumber= :acc", new MapSqlParameterSource("acc",id) , String.class);
	}
	

}
