package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

@Service
public class BannerServiceImp implements IBannerService {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private List<Banner>bannerList = null;
	
	public BannerServiceImp() {

		bannerList = new LinkedList<>();
		
		Banner b = new Banner();
		Banner b2 = new Banner();
		Banner b3 = new Banner();

		b.setId(1);
		b.setTitulo("Slide 1");
		b.setArchivo("slide1.jpg");
		
		b2.setId(2);
		b2.setTitulo("Slide 2");
		b2.setArchivo("slide2.jpg");
		
		b3.setId(3);
		b3.setTitulo("Slide 3");
		b3.setArchivo("slide3.jpg");

		bannerList.add(b);
		bannerList.add(b2);
		bannerList.add(b3);
	}

	@Override
	public List<Banner> getBannerList() {
		return bannerList;
	}

	@Override
	public void addBanner(Banner b) {
		bannerList.add(b);
	}

}
