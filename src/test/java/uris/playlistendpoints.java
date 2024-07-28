package uris;

import static io.restassured.RestAssured.*;




import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.mail.Quota.Resource;

import org.apache.http.client.methods.HttpDelete;
import org.json.JSONObject;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet.UserAgent;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import playloads.Tracks;
import playloads.Items;
import scala.annotation.meta.getter;

public class playlistendpoints {
	
	public static Faker faker;
	
	public static String token = "";
	public static Response getuserdetails() {
		

		Response repponse = given()
				   .auth().oauth2(token)
				
				.when()
				    .get(Playlistpaths.user_info);
		
				    
				
				return repponse;
		
	}
	public static Response playlistiteamdetails(String playid) {
		Response repponse = given()
				   .auth().oauth2(token)
				   .pathParam("playlistid",playid)
				
				.when()
				    .get(Playlistpaths.faud_playlits);
				    
				
				return repponse;
	}
	public static Response playlistdetails(String usrid) {
		Response repponse = given()
				   .auth().oauth2(token)
				   .pathParam("userid", usrid)
				
				.when()
				    .get(Playlistpaths.user_playlists);
				    
				
				return repponse;
	}
	
	// creating a new playlist
	public static Response creatplaylist(String userid,Items payload){
		
		
		
		
		Response repponse = given()
		   .contentType(ContentType.JSON)
		   .auth().oauth2(token)
		   .pathParam("userid", userid)
		   .body(payload)
		
		.when()
		    .post(Playlistpaths.user_playlists);
		
		    
		
		return repponse;
		
		
		
		
	}
	
   // adding iteam to playlist
	
	public static Response additemeeplaylist(String playlid,Items payload){
		

		
		Response repponse = given()
				   .contentType("application/json")
				   .auth().oauth2(token)
				   .pathParam("playlistid", playlid)
				   .body(payload)
				
				.when()
				    .post(Playlistpaths.faud_playlits);
				    
		return repponse;
		
		
		
	}
	
	public static Response updateemplalylist(String playlistid,Items payload)
	{	
		
		
		
		Response repponse = given()
				   .contentType(ContentType.JSON)
				   .auth().oauth2(token)
				   .pathParam("playlistid", playlistid)
				   .body(payload)
				
				.when()
				    .put(Playlistpaths.faud_playlits);
				    
		return repponse;
	}
	
	// deleting a iteam from playlist
	
	public static Response deleteiteamplaylist(String playlistid,Items payload){
		
	
	 
		Response repponse = given()
				   .contentType(ContentType.JSON)
				   .auth().oauth2(token)
				   .pathParam("playlistid", playlistid)
				   .body(payload)
				
				.when()
				    .delete(Playlistpaths.faud_playlits);
				    
		return repponse;
		
		
	}

	// deleting a playlist
	public static Response deleteplaylist(String playlistid){
		
		Response repponse = given()
				   .pathParam("playlistid", playlistid)
				   .auth().oauth2(token)
				
				.when()
				    .delete(Playlistpaths.fu_playlists);
				    
		return repponse;
		
		
	}
}
