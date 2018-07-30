package com.philips.chatbot.preference;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class PreferenceServiceDAO {

	  @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    
	  public List<User> GetUserDetails(String UserId) {
		  
		  String sQuery="SELECT userid, username from tbluser WHERE userid='" + UserId +"'" ;
			return this.jdbcTemplate.query(sQuery, new RowMapper<User>() {

					public User mapRow(ResultSet myrs2, int rowNum) throws SQLException {
						User myuser = new User();
						myuser.setUserid(myrs2.getString("userid"));
						myuser.setUsername(myrs2.getString("username"));
						return myuser;
						}
					});
		    		
		  
		  
	  }
	  
	  public List<UserPreference> GetUserPreferenceResponse(String UserId) {
		String sQuery="SELECT userid, prfkey,prefvalue FROM tbluserpref WHERE userid='" + UserId +"'" ;
		return this.jdbcTemplate.query(sQuery, new RowMapper<UserPreference>() {

				public UserPreference mapRow(ResultSet myrs2, int rowNum) throws SQLException {
					UserPreference myuserPreferenceres = new UserPreference();
					
					myuserPreferenceres.setUserid(myrs2.getString("userid"));
					myuserPreferenceres.setPrefkey(myrs2.getString("prefkey"));
					myuserPreferenceres.setPrefvalue(myrs2.getString("prefvalue"));
					
					return myuserPreferenceres;
					}
				});
	    		
	    }
	  
	  
	  public void AddUserPreferenceResponse(String UserId, String Pref_Key, String Pref_Value) {
		String sQuery="Insert into  tbluserpref (userid, prefkey,prefvalue) values ('" + UserId + "','" + Pref_Key +"','" + Pref_Value +"')" ;
		this.jdbcTemplate.update(sQuery);	    		
	    }

	 /* public void AddUtterence(String Message, String Intent, String Entity) {
			String sQuery="Insert into  TBL_USER_PREF (USER_ID, USER_PREF_KEY,USER_PREF_VALUE) values (?,?,?),'" + UserId + "','" + Pref_Key +"','" + Pref_Value +"'" ;
			this.jdbcTemplate.update(sQuery);	    		
		    }
	  */
	  
	  
}
