package com.vimasolusi.vmelection.etities;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserResult {

	@SerializedName("success")
	private int success;

	@SerializedName("users")
	private List<Users> users;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setUsers(List<Users> users){
		this.users = users;
	}

	public List<Users> getUsers(){
		return users;
	}

	@Override
 	public String toString(){
		return 
			"UserResult{" +
			"success = '" + success + '\'' + 
			",users = '" + users + '\'' + 
			"}";
		}
}