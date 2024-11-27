package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Users;
import com.example.demo.Repo.Usersrepo;

@Service
public class Userservice {
	
	@Autowired
	private Usersrepo usersrepo;
	
	public List<Users> getAllUsers() {
		return usersrepo.findAll();
	}
	
	//LOGINPAGE
	//check if user exists
	public Users registerUser(Users user) {
		if (usersrepo.findByEmail(user.getEmail()).isPresent()) {
			 throw new RuntimeException("Email already in use.");
		}
		return usersrepo.save(user);
	}
	public boolean validateUser(String email, String password) {
        Users user = usersrepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found."));

        // Compare the entered password with the stored password
        return password.equals(user.getPassword());
}	
}
