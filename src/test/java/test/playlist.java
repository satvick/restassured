package test;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.regex.Matcher;


import org.checkerframework.checker.index.qual.LessThan;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import uris.playlistendpoints;

public class playlist extends Base{
	
	

	
	
	
	
	@Test(priority = 1)
	public void userdetails(ITestContext context) {
		
	Response userdetailressponse = playlistendpoints.getuserdetails();
	String id = userdetailressponse.jsonPath().get("id");
	userdetailressponse.then().statusCode(200);
	userdetailressponse.then().time(Matchers.lessThan(3000l));
	context.setAttribute("user_id", id);
	
	}
	
	@Test(priority = 2)
	public void playlistdetails(ITestContext context) {
	
	String id = (String) context.getAttribute("user_id");
	Response playlisdetailressponse = playlistendpoints.playlistdetails(id);
	int playlisttotal = playlisdetailressponse.jsonPath().get("total");
	playlisdetailressponse.then().statusCode(200);
	playlisdetailressponse.then().time(Matchers.lessThan(3000l));

	}
	
	@Test(priority = 3)
	public void createstplaylist(ITestContext context) {
		
		String id = (String) context.getAttribute("user_id");
		logger.info(id);
		Response creatplaylistressponse = playlistendpoints.creatplaylist(id,createplaylistpl);
		String plyid = creatplaylistressponse.jsonPath().get("id");
		creatplaylistressponse.then().statusCode(201);
		creatplaylistressponse.then().time(Matchers.lessThan(3000l));
	    
		context.setAttribute("play_id", plyid);

	}
	
	@Test(priority = 4)
	public void addtplaylistitems(ITestContext context) {
		
	
		
		String plyid = (String) context.getAttribute("play_id");
		logger.info(plyid);
		Response additeamressponse = playlistendpoints.additemeeplaylist(plyid,additemspl);
		additeamressponse.then().statusCode(201);
		String res= additeamressponse.getBody().asString();
		assertTrue(res.contains("snapshot_id"));
		additeamressponse.then().time(Matchers.lessThan(3000l));

	}

	@Test(priority = 5)
	public void updatetplaylistitems(ITestContext context) {
		
		String plyid = (String) context.getAttribute("play_id");
		Response updateiteamressponse = playlistendpoints.updateemplalylist(plyid,updateitemsoderpl);
		updateiteamressponse.then().statusCode(200);
		String res= updateiteamressponse.getBody().asString();
		assertTrue(res.contains("snapshot_id"));
		updateiteamressponse.then().time(Matchers.lessThan(3000l));
		

	}
	
	
	@Test(priority = 6)
	public void deletetplaylistitems(ITestContext context) {
		
		
		
		String plyid = (String) context.getAttribute("play_id");
		Response deleteiteamressponse = playlistendpoints.deleteiteamplaylist(plyid,deleteitemspl);
		deleteiteamressponse.then().statusCode(200);
		String res= deleteiteamressponse.getBody().asString();
		assertTrue(res.contains("snapshot_id"));
		deleteiteamressponse.then().time(Matchers.lessThan(3000l));
		
	}
	
	@Test(priority = 7)
	public void playlistitemdetails(ITestContext context) {
		
		String plyid = (String) context.getAttribute("play_id");
		Response iteamdetailsressponse = playlistendpoints.playlistiteamdetails(plyid);
		int iteamtotal = iteamdetailsressponse.jsonPath().get("total");
		AssertJUnit.assertEquals(iteamtotal,0);
		iteamdetailsressponse.then().statusCode(200);
		iteamdetailsressponse.then().time(Matchers.lessThan(5000l));
		
		
		
	}
	
	@Test(priority = 8)
	public void deleteplaylist(ITestContext context) {
		
		String id = (String) context.getAttribute("play_id");
		Response deleteplaylistressponse = playlistendpoints.deleteplaylist(id);
		deleteplaylistressponse.then().statusCode(200);

		

		
		
		
	}
	
	
	@Test(priority = 9)
	public void playlitdetails(ITestContext context) {
		
		
		String id = (String) context.getAttribute("user_id");
		Response getplaylistressponse = playlistendpoints.playlistdetails(id);
		int finalplaylistitotal = getplaylistressponse.jsonPath().get("total");
		AssertJUnit.assertEquals(finalplaylistitotal,0);
		getplaylistressponse.then().statusCode(200);
		getplaylistressponse.then().time(Matchers.lessThan(3000l));


		
		
		
	}
	
	
}


