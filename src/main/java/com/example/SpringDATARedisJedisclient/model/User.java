package com.example.SpringDATARedisJedisclient.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
//import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("User")
public class User implements Serializable {

	// @Id String id; This would generate a unique number by it self without even
	// define it in the construtor just need the import
	// org.springframework.data.annotation.Id;
	@Indexed  private String id;

	
	@Indexed private String nama;

	@Indexed private String location;
	private String address;
	private String password;

	//protected User() {
	//} // this default contructor needed(behind the sence) for the repository to do
		// findall, FindBy* other than save, delete )

	public User(String id, String nama, String location, String address, String password) {

		this.id = id; // this "id" attribute is a must, so use this for NIC
		this.nama = nama;
		this.location = location;
		this.address = address;
		this.password = password;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	/**
	 * @param nama the nama to set
	 */
	public void setNama(String nama) {
		this.nama = nama;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
		return "User [NIC=" + id + ", Firstname=" + nama + ", location=" + location + ", address=" + address
				+ ", password=" + password + "]";
	}

}





