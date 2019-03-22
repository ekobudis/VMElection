package com.vimasolusi.vmelection.etities;

import com.google.gson.annotations.SerializedName;

public class Users {

	@SerializedName("user_address")
	private Object userAddress;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private String emailVerifiedAt;

	@SerializedName("user_kesatuan")
	private Object userKesatuan;

	@SerializedName("nrp")
	private int nrp;

	@SerializedName("user_pangkat")
	private Object userPangkat;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("user_phone")
	private Object userPhone;

	@SerializedName("id")
	private int id;

	@SerializedName("user_photo")
	private Object userPhoto;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setUserAddress(Object userAddress){
		this.userAddress = userAddress;
	}

	public Object getUserAddress(){
		return userAddress;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setEmailVerifiedAt(String emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public String getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setUserKesatuan(Object userKesatuan){
		this.userKesatuan = userKesatuan;
	}

	public Object getUserKesatuan(){
		return userKesatuan;
	}

	public void setNrp(int nrp){
		this.nrp = nrp;
	}

	public int getNrp(){
		return nrp;
	}

	public void setUserPangkat(Object userPangkat){
		this.userPangkat = userPangkat;
	}

	public Object getUserPangkat(){
		return userPangkat;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUserPhone(Object userPhone){
		this.userPhone = userPhone;
	}

	public Object getUserPhone(){
		return userPhone;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUserPhoto(Object userPhoto){
		this.userPhoto = userPhoto;
	}

	public Object getUserPhoto(){
		return userPhoto;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Users{" +
			"user_address = '" + userAddress + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",user_kesatuan = '" + userKesatuan + '\'' + 
			",nrp = '" + nrp + '\'' + 
			",user_pangkat = '" + userPangkat + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",name = '" + name + '\'' + 
			",user_phone = '" + userPhone + '\'' + 
			",id = '" + id + '\'' + 
			",user_photo = '" + userPhoto + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}