package com.fyme.fts.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fyme.fts.model.User;
import com.fyme.fts.service.UserService;
import com.fyme.fts.util.MapsUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoogleApiTestClient {

	@Autowired
	UserService userService;
	
	@Autowired
	MapsUtil mapsUtil;

	@Test
	public void testGetCoordinates() {
		List<User> employees = userService.findAllEmployes();
		User user = employees.get(0);
		try {
			String latLongs[] = mapsUtil.getCordinates(user.getAddress().getAddress(), "India");
			System.err.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateCoordinates() {
		List<User> employees = userService.findAllEmployes();
		for(User user : employees){
			try {
				String latLongs[] = mapsUtil.getCordinates(user.getAddress().getAddress(), "India");
				System.err.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
				user.getAddress().setLatitude(Double.valueOf(latLongs[0]));
				user.getAddress().setLongitude(Double.valueOf(latLongs[1]));
				userService.updateUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
