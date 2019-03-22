package com.vimasolusi.vmelection.etities;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BukuResult {

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("buku")
	private List<Buku> buku;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setBuku(List<Buku> buku){
		this.buku = buku;
	}

	public List<Buku> getBuku(){
		return buku;
	}

	@Override
 	public String toString(){
		return 
			"BukuResult{" +
			"pesan = '" + pesan + '\'' + 
			",buku = '" + buku + '\'' + 
			"}";
		}
}