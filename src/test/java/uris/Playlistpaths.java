package uris;

public class Playlistpaths {
	
public static String base_url = "https://api.spotify.com/v1";
	
	// to get current user details
	
	public static String user_info = base_url+"/me";
	
	// geating a list of playlists or creating a playlists
	
	public static String user_playlists = base_url+"/users/{userid}/playlists";
	
	// faud - featching adding updating deleting playlist items
	
	public static String faud_playlits = base_url+"/playlists/{playlistid}/tracks";
	
	// fu - following unfollowing playlits 
	
	public static String fu_playlists = base_url+"/playlists/{playlistid}/followers";

}
