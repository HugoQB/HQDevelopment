package com.hq.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hq.api.entity.Album;

@Repository
public interface AlbumsRepository extends JpaRepository<Album, Integer>{

}
