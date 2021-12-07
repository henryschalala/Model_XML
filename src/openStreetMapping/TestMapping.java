package openStreetMapping;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;

import openStreetMapping.api.OpenStreetMappingAPI;
import openStreetMapping.api.OpenStreetMappingHiPEApp;

public class TestMapping extends OpenStreetMappingHiPEApp {

	public OpenStreetMappingAPI api;
	
	public static void main(String[] args) {
		var t = new TestMapping();
		
		
		t.api.connectNodes().apply();
		
		
		// save
		try {
			t.api.getModel().getResources().get(0).save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		t.api.terminate();
	}
	
	TestMapping() {
		createModel(URI.createURI("osm.xmi"));
		api = this.initAPI();
		
	}
}
