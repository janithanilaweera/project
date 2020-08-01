package com.example.SpringDATARedisJedisclient.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDATARedisJedisclient.SpringDataRedisJedisclientApplication;
import com.example.SpringDATARedisJedisclient.model.Price;
import com.example.SpringDATARedisJedisclient.model.Stock;
import com.example.SpringDATARedisJedisclient.model.User;
import com.example.SpringDATARedisJedisclient.model.Userlogin;
import com.example.SpringDATARedisJedisclient.repo.PriceRepository;
import com.example.SpringDATARedisJedisclient.repo.StockRepository;
import com.example.SpringDATARedisJedisclient.repo.UserRepository;
import com.example.SpringDATARedisJedisclient.repo.UserloginRepository;
import com.example.SpringDATARedisJedisclient.config.RedisConfig;
import com.example.SpringDATARedisJedisclient.SpringDataRedisJedisclientApplication;

//import java.util.HashMap;
//
//import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

//import java.util.Optional;
//import java.util.Map;

@RestController
public class homeController {
	private final static Logger log = LoggerFactory.getLogger(SpringDataRedisJedisclientApplication.class);
	// private Map<String, String> map = new HashMap<> ();

	@Autowired
	PriceRepository repo;
	@Autowired
	UserRepository repo2;
	@Autowired
	StockRepository stockrepo;
	@Autowired
	UserloginRepository userloginrepo;
//	@Autowired
	@Resource(name = "userlogin")
	Userlogin userlogin;

	@PostMapping("/addprice")
	public @ResponseBody Price addprice(@RequestParam String nic, @RequestParam String location,@RequestParam String pricecat, @RequestParam String type, @RequestParam long price) {
		Price student = new Price(nic, location, pricecat,type, price);
		return repo.save(student);
	}

	@GetMapping("/allprice")
	public @ResponseBody Iterable<Price> allprice() {
		for (Price price : repo.findAll()) {
			log.info(price.toString());
		}
		// addprice("677679", "ihib", "15", 60);
		return repo.findAll();
	}

	@GetMapping("/findpricebylocation")
	public @ResponseBody Iterable<Price> findpricebylocation(@RequestParam String location) {
		for (Price price : repo.findByLocation(location)) {
			log.info(price.toString());
		}
		return repo.findByLocation(location);
	}

//	 @GetMapping("/all")
//	  public @ResponseBody Iterable<User> getAllUsers() {
//	    // This returns a JSON or XML with the users
//		  repo2.save(new  User( "782840525v", "Name", "Location",  "Addres",  "Password")) ;
//		 for ( User bb : repo2.findAll()) {
//		  String s = bb.getName();
//		  if ( "Name".equals(s))  // this the way to do a "If" statement with Strings   if ( "fuck".equals(s)) 
//		    {
//			  bb.setName("Sarath");
//			  repo2.save(bb);
//		    }
//		 
//		 }
//		 repo2.save(new  User( "782840525v", "Name", "Lo",  "Addres",  "Password")) ;
//		  repo2.save(new  User("78", "N", "Lo",  "Ad",  "Password")) ;
//	    return   repo2.findAll();
//	  }
	@PostMapping("/adduser")
	public @ResponseBody User adduser(@RequestParam String id, @RequestParam String firstName,
			@RequestParam String location, @RequestParam String address, @RequestParam String password) {
		// repo2.deleteAll();
		// return repo2.findById("002").orElse(null);
		log.info(userlogin.toString());
		userlogin.setNic(id);
		userlogin.setPassword(password);
		log.info(userlogin.toString());
		return repo2.save(new User(id, firstName, location, address, password));
	}

	@GetMapping("/alluser")
	public @ResponseBody Iterable<User> alluser() {
		return repo2.findAll();
	}

	@GetMapping("/finduserbyid")
	public @ResponseBody User finduserbyid(@RequestParam String id) {
		return repo2.findById(id).orElse(null);
	}

	@GetMapping("/finduserbylocation")
	public @ResponseBody List<User> finduserbylocation(@RequestParam String location) {
		return repo2.findByLocation(location);
	}

	@GetMapping("/finduserbyname")
	public @ResponseBody List<User> finduserbyname(@RequestParam String nama) {
		return repo2.findByNama(nama);
	}

	@DeleteMapping("/deluser")
	public @ResponseBody Iterable<User> deluser(@RequestParam String id) {
		repo2.deleteById(id);
		return alluser();
	}
	
	@PutMapping("/changeuserpassword")
	public @ResponseBody User changeuserpassword(@RequestParam String id, @RequestParam String password) {

		User user = repo2.findById(id).orElseThrow();
		user.setPassword(password);

		log.info(userlogin.toString());
		userlogin.setNic(id);
		userlogin.setPassword(password);
		log.info(userlogin.toString());
		return repo2.save(user);
	}

	@GetMapping("/alluserlogin")
	public @ResponseBody String alluserlogin() {
// this end point is just to testing for "userlogin" session bean and its working :))
		log.info(userlogin.toString());
		return userlogin.toString();
	}
	@GetMapping("/adduserlogin") // this ADDS A entry every time user logged in 
	public @ResponseBody String adduserlogin (@RequestParam String nic,
					@RequestParam String password) {
		userlogin.setNic(nic);
		userlogin.setPassword(password);
		return userlogin.toString();
		
		
	}

	@GetMapping("/allstock")
	public @ResponseBody Iterable<Stock> allstock() {
		return stockrepo.findAll();
	}

	@PostMapping("/addstock")
	public @ResponseBody Stock addsock(@RequestParam String nic, @RequestParam String location,
			@RequestParam String size, @RequestParam long total, @RequestParam String date) {
		return stockrepo.save(new Stock(nic, location, size, total, date));

	}

	@GetMapping("/findstockbylocation")
	public @ResponseBody List<Stock> findstockbylocation(@RequestParam String location) {
		return stockrepo.findByLocation(location);
	}

	@GetMapping("/findbyid")
	public @ResponseBody Stock findbyid(@RequestParam String id) {
		return stockrepo.findById(id).orElse(null);
	}

	@DeleteMapping("/delstock")
	public @ResponseBody String delstock(@RequestParam String id) {
		if (stockrepo.findById(id).isEmpty())
			return "record not found ";
		stockrepo.deleteById(id);
		log.info("Deleted");
		return id + "  " + "deleted successfully";
	}

}