package net.itinajero.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static List<String>getNextDays(int days){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//today's date
		Date start = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);
		Date endDate = c.getTime();
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(start);
		List<String>nextDays = new ArrayList<String>();
		while(!gc.getTime().after(endDate)) {
			Date d = gc.getTime();
			gc.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}
	
	public static String guardarImagen(MultipartFile mpf, HttpServletRequest sr) {
		String originalName = mpf.getOriginalFilename();
		originalName = originalName.replaceAll(" ", "-");
		String finalName = randomAlphanumeric(8) + originalName;
		//get absolut path of images directory
		String rutaFinal = sr.getServletContext().getRealPath("/resources/images/");
		System.out.println(rutaFinal);
		try {
			//formamos el nombre del archivo para guardarlo en el hdd
			File imageFile = new File(rutaFinal + finalName);
			System.out.println(imageFile.getAbsolutePath());
			mpf.transferTo(imageFile);
			return finalName;
			
		}catch(IOException e) {
			System.out.println("Error: "+ e.getMessage());
			return null;
		}
	}
	
	public static String randomAlphanumeric(int n) {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		while(n-- !=0) {
			int car = (int)(Math.random() * caracteres.length());
			sb.append(caracteres.charAt(car));
		}
		return sb.toString();
		
	}

	@Override
	public String toString() {
		return "Utileria [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
