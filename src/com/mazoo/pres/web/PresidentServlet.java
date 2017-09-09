package com.mazoo.pres.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mazoo.pres.data.President;
import com.mazoo.pres.data.PresidentDAO;

/**
 * Servlet implementation class PresidentServlet
 */
@SuppressWarnings("serial")
public class PresidentServlet extends HttpServlet {
	private PresidentDAO presDAO;
	private List<President> curList;
	private int presIndex = 0;
	
	public void init() throws ServletException {
		presDAO = new PresidentDAO(getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeSearch = req.getParameter("presSubmit");
		presIndex = 0;
		switch (typeSearch) {
		case "all presidents":
			curList = new ArrayList<>(presDAO.getAllPres());
			break;
		case "filter":	
			curList = new ArrayList<>(listFilter(req.getParameter("filterVal")));
			System.out.println(curList.get(0).getName());
//			presIndex = Integer.parseInt(req.getParameter("term"));
			break;
		case "go to":
			curList = new ArrayList<>(presDAO.getAllPres());
			presIndex = Integer.parseInt(req.getParameter("term")) - 1;
			break;
		}
		req.setAttribute("pres", curList.get(presIndex));
		req.getRequestDispatcher("WEB-INF/president.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String incOrDec = req.getParameter("cycle");
		switch (incOrDec) {
		case "increment":
			if(presIndex == curList.size() -1) {				
				presIndex = 0;
			} else {
				presIndex++;
			}
			break;
		case "decrement":
			if(presIndex == 0) {				
				presIndex = curList.size() - 1;
			} else {
				presIndex--;
			}
			break;
		}
		req.setAttribute("pres", curList.get(presIndex));
		req.getRequestDispatcher("WEB-INF/president.jsp").forward(req, resp);
	}
	
	
	private List<President> listFilter(String filter){
		List<President> filtered = new ArrayList<>();
		for (President president :presDAO.getAllPres()) {
			if(president.getParty().equals(filter)) {
				filtered.add(president);
			}
		}
		return filtered;
	}
	
}
