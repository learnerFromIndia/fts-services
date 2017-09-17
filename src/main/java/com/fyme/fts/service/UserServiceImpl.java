package com.fyme.fts.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.fyme.fts.model.User;



@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<ArrayList<User>> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<ArrayList<User>> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(List<User> userLst : users){
			for(User user : userLst){
				if(user.getId() == id){
					return user;
				}
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(ArrayList<User> userLst : users){
			for(User user : userLst){
				if(user.getUsername().equalsIgnoreCase(name)){
					return user;
				}
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		//users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		//users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		/*for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}*/
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<ArrayList<User>> populateDummyUsers(){
		List<ArrayList<User>> users = new ArrayList<ArrayList<User>>();
		ArrayList<User> user1 = new ArrayList<User>();
		user1.add(new User(counter.incrementAndGet(), 0, "amit", "employee", "fake-jwt-token"));
		user1.add(new User(counter.incrementAndGet(), 0, "ajith", "employee", "fake-jwt-token"));
		user1.add(new User(counter.incrementAndGet(), 0, "umang", "employee", "fake-jwt-token"));
		user1.add(new User(counter.incrementAndGet(), 0, "chandran", "employee", "fake-jwt-token"));
		ArrayList<User> user2 = new ArrayList<User>();
		user2.add(new User(counter.incrementAndGet(), 1, "Tom", "employee", "fake-jwt-token"));	
		user2.add(new User(counter.incrementAndGet(), 1, "Jasmeet", "employee", "fake-jwt-token"));	
		user2.add(new User(counter.incrementAndGet(), 1, "Rich", "employee", "fake-jwt-token"));	
		user2.add(new User(counter.incrementAndGet(), 1, "Bill", "employee", "fake-jwt-token"));	
		ArrayList<User> user3 = new ArrayList<User>();
		user3.add(new User(counter.incrementAndGet(), 2, "Cody", "employee", "fake-jwt-token"));	
		user3.add(new User(counter.incrementAndGet(), 2, "Dmitry", "employee", "fake-jwt-token"));	
		user3.add(new User(counter.incrementAndGet(), 2, "Elana", "employee", "fake-jwt-token"));	
		user3.add(new User(counter.incrementAndGet(), 2, "Jennifer", "employee", "fake-jwt-token"));	
		ArrayList<User> user4 = new ArrayList<User>();
		user4.add(new User(counter.incrementAndGet(), 3, "Jen", "employee", "fake-jwt-token"));	
		user4.add(new User(counter.incrementAndGet(), 3, "Amanada", "employee", "fake-jwt-token"));	
		user4.add(new User(counter.incrementAndGet(), 3, "John", "employee", "fake-jwt-token"));	
		user4.add(new User(counter.incrementAndGet(), 3, "Janet", "employee", "fake-jwt-token"));	
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		return users;
	}

}
