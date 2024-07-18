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
import playloads.User;
import scala.annotation.meta.getter;

public class endpoints {
	
	public static Faker faker;
	
	public static String token = "BQAEymIjvM7zkZf2rw-d5McP7MJXutXf-dcAab_oX4vJy22N-TT_lniFMmw2LjD3Gp7WAhrZ7q9CEYdRvYJCsfnkTSJfhdxDrORivoBu-6BmVjtBdcRYg0b04rl6BUEmEfZPjVPrnDf9sNdQ5U7P3BSr1JAgeK6EZNMD7GNzmPyJH-DHC5oIz-FhGY9oXJL_GcS-aEjdm9wAnpxjroTF0en10yU36cXbIA3qj_enld_3_TiMm2ejTja9Zb2KLAw67TI";
	
	public static Response getuserdetails() {
		

		Response repponse = given()
				   .auth().oauth2(token)
				
				.when()
				    .get(paths.user_info);
		
				    
				
				return repponse;
		
	}
	public static Response playlistiteamdetails(String playid) {
		Response repponse = given()
				   .auth().oauth2(token)
				   .pathParam("playlistid",playid)
				
				.when()
				    .get(paths.faud_playlits);
				    
				
				return repponse;
	}
	public static Response playlistdetails(String usrid) {
		Response repponse = given()
				   .auth().oauth2(token)
				   .pathParam("userid", usrid)
				
				.when()
				    .get(paths.user_playlists);
				    
				
				return repponse;
	}
	
	// creating a new playlist
	public static Response creatplaylist(String userid,User payload){
		
		
		
		
		Response repponse = given()
		   .contentType(ContentType.JSON)
		   .auth().oauth2(token)
		   .pathParam("userid", userid)
		   .body(payload)
		
		.when()
		    .post(paths.user_playlists);
		
		    
		
		return repponse;
		
		
		
		
	}
	
   // adding iteam to playlist
	
	public static Response additemeeplaylist(String playlid,User payload){
		

		
		Response repponse = given()
				   .contentType("application/json")
				   .auth().oauth2(token)
				   .pathParam("playlistid", playlid)
				   .body(payload)
				
				.when()
				    .post(paths.faud_playlits);
				    
		return repponse;
		
		
		
	}
	
	public static Response updateemplalylist(String playlistid,User payload)
	{	
		
		
		
		Response repponse = given()
				   .contentType(ContentType.JSON)
				   .auth().oauth2(token)
				   .pathParam("playlistid", playlistid)
				   .body(payload)
				
				.when()
				    .put(paths.faud_playlits);
				    
		return repponse;
	}
	
	// deleting a iteam from playlist
	
	public static Response deleteiteamplaylist(String playlistid,User payload){
		
	
	 
		Response repponse = given()
				   .contentType(ContentType.JSON)
				   .auth().oauth2(token)
				   .pathParam("playlistid", playlistid)
				   .body(payload)
				
				.when()
				    .delete(paths.faud_playlits);
				    
		return repponse;
		
		
	}

	// deleting a playlist
	public static Response deleteplaylist(String playlistid){
		
		Response repponse = given()
				   .pathParam("playlistid", playlistid)
				   .auth().oauth2(token)
				
				.when()
				    .delete(paths.fu_playlists);
				    
		return repponse;
		
		
	}
}
