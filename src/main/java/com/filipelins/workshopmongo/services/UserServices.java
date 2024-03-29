package com.filipelins.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipelins.workshopmongo.domain.User;
import com.filipelins.workshopmongo.dto.UserDTO;
import com.filipelins.workshopmongo.repository.UserRepository;
import com.filipelins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public User insert(User user) {
		return repo.save(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User newUserData) {
		User currentUserData = findById(newUserData.getId());
		updateData(currentUserData, newUserData);
		return repo.save(currentUserData);
	}
	
	private void updateData(User currentUserData, User newUserData) {
		currentUserData.setName(newUserData.getName());
		currentUserData.setEmail(newUserData.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
