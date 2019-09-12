package com.hq.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hq.api.entity.Album;

public interface IAlbumService {
	
	List<Album>buscarTodos();
	
	void guardar(Album a);
	
	Album buscarPorId(int id);
	
	void eliminar(int id);
}
