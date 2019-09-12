package com.hq.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hq.api.entity.Album;
import com.hq.api.repository.AlbumsRepository;
import com.hq.api.service.IAlbumService;

@Service
public class AlbumsService implements IAlbumService {
	
	@Autowired
	private AlbumsRepository repoAlbum;

	@Override
	public List<Album> buscarTodos() {
		return repoAlbum.findAll();
	}

	@Override
	public void guardar(Album a) {
		repoAlbum.save(a);
		
	}

	@Override
	public Album buscarPorId(int id) {
		return repoAlbum.findById(id).get();		
	}

	@Override
	public void eliminar(int id) {
		repoAlbum.deleteById(id);
		
	}

}
