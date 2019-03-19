package com.example.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;

import com.example.model.Page;
import com.example.model.Response;

public class CrawlerService {
	
	// Crawling depth
	private static final int MAX_PAGE_TO_SEARCH = 3;
	// Set for Unique entries 
	private HashSet<String> links;
	List<Page> pageList;
	int count;
	
	//Constructor
	public CrawlerService() {
		links = new HashSet<String>();
		pageList=new ArrayList<Page>();
		int count=0;
	}

	/**
	 * Get Page Links and Crawl site recursively and Print result on console 
	 * Use of Jsoup Java Library
	 * 
	 * @param URL
	 * @param page
	 * @param desc
	 * 
	 * @author Prashank Mohan
	 */

	public void getPageLinks(String URL, int page, String desc,String domain) {
		
		
		if ((!links.contains(URL) && (page < MAX_PAGE_TO_SEARCH))) {
			Page pg=new Page();
			pg.setName(desc);
			pg.setPageno(page);
			pg.setLink(URL);
			System.out.println(">> Page: " + page + " -> " + desc + "\n [" + URL + "] \n");
			
			try {
				// add links to set
				links.add(URL);

				//connect to URL using Jsoup
				Document document = Jsoup.connect(URL).get();
				//Elements otherLinks = document.select("a[href*=redhat.com]");
				Elements otherLinks = document.select("a[href*="+domain+".com]");
				//Elements otherLinks = document.select("[title]");

				page++;

				for (Element link : otherLinks) {
					if (links.add(URL)) {
						System.out.println(URL);
					}
					if(count<20)
					getPageLinks(link.attr("abs:href"), page, link.text(),domain);
					
				}
			} catch (IOException e) {
				//System.err.println("Error For URL -> '" + URL + "': " + e.getMessage());
			}
			System.out.println("adding a page object");
			pageList.add(pg);
			count++;
			
		}
		

	}
	

	
	
	public Response doCrawl(String domain) {
		System.out.println("running");
		Response res=new Response();
		getPageLinks("http://www."+domain+".com", 0, domain,domain);
		res.setPages(pageList);
		return res;
		
		
	}

}
