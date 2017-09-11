package com.mazoo.pres.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentDAO {
	
	private String fileName = "/WEB-INF/presData2.txt";
	private List<President> allPres;
	private ServletContext context;
	
	
	public PresidentDAO (ServletContext context) {
		this.context = context;
		allPres = new ArrayList<>();
		loadPresidents();
	}
	
	private void loadPresidents () {
		InputStream is = context.getResourceAsStream(fileName);
		try {
			BufferedReader  br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				allPres.add(new President(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}	
	}

	public List<President> getAllPres() {
		return allPres;
	}
}
