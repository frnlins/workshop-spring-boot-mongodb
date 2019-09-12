package com.filipelins.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipelins.workshopmongo.domain.Post;
import com.filipelins.workshopmongo.repository.PostRepository;
import com.filipelins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	public List<Post> findByTitle(String title){
		return repo.searchTitle(title);
	}
}
