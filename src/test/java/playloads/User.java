package playloads;

import java.security.PublicKey;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class User {
	
	
	
	String name;
	

	String description;
	
	Integer range_strat;
	
	Integer insert_before;
	
	
	String uris[];
	
	String uri[];
	
	List<Tracks> tracks;
	
	 @SerializedName("public")
	 boolean ispublic;
	
	public boolean isIspublic() {
		return ispublic;
	}

	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}
	
	
	
	
	

	public String[] getUris() {
		return uris;
	}

	public void setUris(String[] uris) {
		this.uris = uris;
	}

	public String[] getUri() {
		return uri;
	}

	public void setUri(String[] uri) {
		this.uri = uri;
	}

	public Integer getRange_strat() {
		return range_strat;
	}

	public void setRange_strat(Integer range_strat) {
		this.range_strat = range_strat;
	}

	public Integer getInsert_before() {
		return insert_before;
	}

	public void setInsert_before(Integer insert_before) {
		this.insert_before = insert_before;
	}



}
