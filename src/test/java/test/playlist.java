package test;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.regex.Matcher;


import org.checkerframework.checker.index.qual.LessThan;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import uris.endpoints;

public class playlist extends Base{
	
	

	
	
	
	
	@Test(priority = 1)
	public void userdetails(ITestContext context) {
		
	Response userdetailressponse = endpoints.getuserdetails();
	String id = userdetailressponse.jsonPath().get("id");
	userdetailressponse.then().statusCode(200);
	userdetailressponse.then().time(Matchers.lessThan(3000l));
	context.setAttribute("user_id", id);
	
	}
	
	@Test(priority = 2)
	public void playlistdetails(ITestContext context) {
	
	String id = (String) context.getAttribute("user_id");
	Response playlisdetailressponse = endpoints.playlistdetails(id);
	int playlisttotal = playlisdetailressponse.jsonPath().get("total");
	playlisdetailressponse.then().statusCode(200);
	playlisdetailressponse.then().time(Matchers.lessThan(3000l));

	}
	
	@Test(priority = 3)
	public void createstplaylist(ITestContext context) {
		
		String id = (String) context.getAttribute("user_id");
		logger.info(id);
		Response creatplaylistressponse = endpoints.creatplaylist(id,createplaylistpl);
		String plyid = creatplaylistressponse.jsonPath().get("id");
		creatplaylistressponse.then().statusCode(201);
		creatplaylistressponse.then().time(Matchers.lessThan(3000l));
	    
		context.setAttribute("play_id", plyid);

	}
	
	@Test(priority = 4)
	public void addtplaylist(ITestContext context) {
		
	
		
		String plyid = (String) context.getAttribute("play_id");
		logger.info(plyid);
		Response additeamressponse = endpoints.additemeeplaylist(plyid,addingiteampl);
		additeamressponse.then().statusCode(201);
		additeamressponse.then().time(Matchers.lessThan(3000l));

	}

	@Test(priority = 5)
	public void updatetplaylist(ITestContext context) {
		
		String plyid = (String) context.getAttribute("play_id");
		Response updateiteamressponse = endpoints.updateemplalylist(plyid,updatiteamsoderpl);
		updateiteamressponse.then().log().all();
		updateiteamressponse.then().statusCode(200);
		updateiteamressponse.then().time(Matchers.lessThan(3000l));
		

	}
	
	
	@Test(priority = 6)
	public void deletetiteamplaylist(ITestContext context) {
		
		
		
		String plyid = (String) context.getAttribute("play_id");
		Response deleteiteamressponse = endpoints.deleteiteamplaylist(plyid,deletediteampl);
		deleteiteamressponse.then().log().all();
		deleteiteamressponse.then().statusCode(200);
		deleteiteamressponse.then().time(Matchers.lessThan(3000l));
		
	}
	
	@Test(priority = 7)
	public void playlistitemdetails(ITestContext context) {
		
		String plyid = (String) context.getAttribute("play_id");
		Response iteamdetailsressponse = endpoints.playlistiteamdetails(plyid);
		int iteamtotal = iteamdetailsressponse.jsonPath().get("total");
		AssertJUnit.assertEquals(iteamtotal,0);
		iteamdetailsressponse.then().statusCode(200);
		iteamdetailsressponse.then().time(Matchers.lessThan(5000l));
		
		
		
	}
	
	@Test(priority = 8)
	public void deleteplaylist(ITestContext context) {
		
		String id = (String) context.getAttribute("play_id");
		Response deleteplaylistressponse = endpoints.deleteplaylist(id);
		deleteplaylistressponse.then().log().all();
		deleteplaylistressponse.then().statusCode(200);

		

		
		
		
	}
	
	
	@Test(priority = 9)
	public void playlitdetails(ITestContext context) {
		
		
		String id = (String) context.getAttribute("user_id");
		Response getplaylistressponse = endpoints.playlistdetails(id);
		int finalplaylistitotal = getplaylistressponse.jsonPath().get("total");
		AssertJUnit.assertEquals(finalplaylistitotal,0);
		getplaylistressponse.then().statusCode(200);
		getplaylistressponse.then().time(Matchers.lessThan(3000l));


		
		
		
	}
	
	
}


