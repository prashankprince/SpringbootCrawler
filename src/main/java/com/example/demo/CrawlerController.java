package com.example.demo;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Response;
import com.example.service.CrawlerService;

@RestController
public class CrawlerController {
	
	@RequestMapping(value="/crawlservice", method = RequestMethod.GET)
	public Response crawl(@RequestParam(name="domain")String domain) {
		System.out.println("domain name coming in "+domain);
		CrawlerService serv=new CrawlerService();
		Response res=serv.doCrawl(domain);
		
		return res ;
	}

}
