package com.filipelins.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipelins.workshopmongo.domain.Post;
import com.filipelins.workshopmongo.services.PostServices;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostServices service;

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post= service.findById(id);
		return ResponseEntity.ok(post);
	}
}
