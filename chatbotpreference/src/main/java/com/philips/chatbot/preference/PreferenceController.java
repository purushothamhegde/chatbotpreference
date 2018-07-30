package com.philips.chatbot.preference;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class PreferenceController {

	@Autowired
	PreferenceService prefservice;
	
	
	@RequestMapping("/UserPreference/{userId}")
	public List<UserPreference> GetUserPreference(@PathVariable("userId") String UserId) throws IOException {
		return prefservice.GetUserPreference(UserId);
		
	}
	
	@RequestMapping("/User/{userId}")
	public List<User> GetUser(@PathVariable("userId") String UserId) throws IOException {
		return prefservice.GetUserDetails(UserId);
		
	}
	
	
	
	@RequestMapping(value="/PersistUserPreference", method = RequestMethod.POST)
	public String PersistUserPreference(@RequestBody String  input) throws IOException {
				
		System.out.println(input);
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		
	    UserPreference userpref = mapper.readValue(input, UserPreference.class);
	    
	    System.out.println("getUSER_ID()" + userpref.getUserid());
	    
	    System.out.println("getUSER_PREF_KEY()" + userpref.getPrefkey());
	    System.out.println("getUSER_PREF_VALUE" + userpref.getPrefvalue());
		
		prefservice.AddUserPreferenceResponse(userpref.getUserid(),userpref.getPrefkey(), userpref.getPrefvalue());
		return "User Preference Added!!";

		
	}
	
}
