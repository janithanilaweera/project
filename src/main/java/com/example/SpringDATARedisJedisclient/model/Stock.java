package com.example.SpringDATARedisJedisclient.model;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
//import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Stock")
public class Stock implements Serializable {
	@Id private String id;  // This would generate a unique number by it self without even define it in the construtor just need the import org.springframework.data.annotation.Id;
	private String nic;
	private String size;
	@Indexed private String location;
	private long total;
	private String date;
	
	 protected Stock() {} //this default contructor needed(behind the sence) for the repository to do findall, FindBy* other than save, delete )
	public Stock(String nic, String location, String size, long total, String date) {
		
		this.nic = nic;
		this.location = location;
		this.size = size;
		this.total = total;
		this.date = date;
	}
	
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
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Stock [nic=" + nic + ", location=" + location + ", size=" + size + ", total=" + total
				+ ", date=" + date + "]";
	} 
	
	
}