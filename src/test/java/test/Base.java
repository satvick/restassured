package test;

import java.awt.desktop.UserSessionEvent;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;



import playloads.Tracks;
import playloads.User;
import scala.annotation.newMain;

public class Base {
	
	
	//pl = playload
	
	Faker faker;
	User createplaylistpl;
	User addingiteampl;
	User updatiteamsoderpl;
	User deletediteampl;
	User deleteplaylistpl;
	
	public Logger logger;
	
	Tracks trackname1;
	Tracks trackname2;
	
	String useruris[]= {"spotify:track:6rqhFgbbKwnb9MLmUQDhG6","spotify:track:6bmmHeCvZI92pRiTHxEdTC"};
	
	@BeforeClass
	public void setup(){
		
		
		logger = LogManager.getLogger(this.getClass());
		
		createplaylistpl = new User();
		addingiteampl = new User();
		updatiteamsoderpl = new User();
		deletediteampl = new User();
		deleteplaylistpl = new User();
		
		trackname1 =new Tracks();
		trackname2 = new Tracks();
		
		
		createplaylistpl.setName("Work Songs");
		

		
		
		addingiteampl.setUris(useruris);
		
		
		
		updatiteamsoderpl.setUris(useruris);
		updatiteamsoderpl.setRange_strat(0);
		updatiteamsoderpl.setInsert_before(2);
		
		updatiteamsoderpl.setRange_strat(0);
		updatiteamsoderpl.setInsert_before(2);
		
		trackname1.setUri("spotify:track:6rqhFgbbKwnb9MLmUQDhG6");
		trackname2.setUri("spotify:track:6bmmHeCvZI92pRiTHxEdTC");
		List<Tracks> alltracks = new ArrayList<>(); 
		alltracks.add(trackname1);
		alltracks.add(trackname2);
		deletediteampl.setTracks(alltracks);
		
		deleteplaylistpl.setTracks(alltracks);
		
		
	}
	
	

}
