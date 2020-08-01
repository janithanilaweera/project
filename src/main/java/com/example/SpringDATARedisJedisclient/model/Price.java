package com.example.SpringDATARedisJedisclient.model;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Price")
public class Price implements Serializable {

//    public enum Gender {
//        MALE, FEMALE
//    }

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id String id; 
	private String nic;  // this id is the nic number 
  @Indexed private String location;
	private String pricecat; // ex 1000, 2000,3000,4000,5000 where 1000 means 0 to 1000 so on 
	private String type;
    private long price;

	protected Price () {} //this default contructor needed(behind the sence) for the repository to do findall, FindBy* other than save, delete )
	public Price(String nic, String location, String pricecat, String type, long price) {
		
		this.nic = nic;
		this.location = location;
		this.pricecat = pricecat;
		this.type = type;
		this.price = price;
	}
	public String getId() {
		return id;
		
	}
	

	public void setNic(String nic) {
		this.nic = nic;
	}
	

		public String getNic() {
			return nic;
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
	 * @return the pricecat
	 */
	public String getPricecat() {
		return pricecat;
	}
	/**
	 * @param pricecat the pricecat to set
	 */
	public void setPricecat(String pricecat) {
		this.pricecat = pricecat;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Price [id=" + id + ", nic=" + nic + ", location=" + location + ", pricecat=" + pricecat + ", type="
				+ type + ", price=" + price + "]";
	}
    
  }