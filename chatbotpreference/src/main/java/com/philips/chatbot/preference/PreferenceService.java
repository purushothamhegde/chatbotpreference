package com.philips.chatbot.preference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PreferenceService {

	
	@Autowired
	PreferenceServiceDAO prefdao;
	
	public List<UserPreference> GetUserPreference(String UserId)
	{
		
		return prefdao.GetUserPreferenceResponse(UserId);	
	}
	

	public List<User> GetUserDetails(String UserId)
	{
		
		return prefdao.GetUserDetails(UserId);	
	}
	
	
	public void AddUserPreferenceResponse(String UserId, String Pref_Key, String Pref_Value) {
		
		prefdao.AddUserPreferenceResponse(UserId, Pref_Key, Pref_Value);
		
	}
}
