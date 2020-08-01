package com.example.SpringDATARedisJedisclient.model;

import java.io.Serializable;
//import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
//import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Userlogin")
public class Userlogin  implements Serializable {
	@Id
	//private Map<String, String> user1;
	private String nic;
	private String password;
	
	/*
	 * public Userlogin(Map<String, String> user1) { this.user1 = user1; }
	 */

	public Userlogin(String nic, String password) {
	
		this.nic = nic;
		this.password = password;
	}

	public Userlogin() {
		// TODO Auto-generated constructor stub
	}

	

	/*
	 * public Map<String, String> getUser() { return user1; }
	 */

	/*
	 * public void setUser(Map<String, String> user1) { this.user1 = user1; }
	 */
	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Userlogin [nic=" + nic + ", password=" + password + "]";
	}

	
	

	
	


}