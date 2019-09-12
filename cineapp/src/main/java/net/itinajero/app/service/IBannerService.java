package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Banner;

public interface IBannerService {

	List<Banner>getBannerList();
	
	void addBanner(Banner b);
	
}
