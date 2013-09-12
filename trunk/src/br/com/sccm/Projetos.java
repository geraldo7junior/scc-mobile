package br.com.sccm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Projetos extends BaseMenu {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projetos);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		/*#### LISTA PROJETOS ####*/
		
		initList();

		ListView lv = (ListView) findViewById(R.id.listProjetos);

		SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});

		lv.setAdapter(simpleAdpt);
		
		/*#### LISTA PROJETOS - FIM ####*/
		
		
	}
	
	/*#### LISTA PROJETOS ####*/
	List<Map<String, String>> planetsList = new ArrayList<Map<String,String>>();

	private void initList() {

		planetsList.add(createPlanet("planet", "Mercury"));
		planetsList.add(createPlanet("planet", "Venus"));
		planetsList.add(createPlanet("planet", "Mars"));
		planetsList.add(createPlanet("planet", "Jupiter"));
		planetsList.add(createPlanet("planet", "Saturn"));
		planetsList.add(createPlanet("planet", "Uranus"));
		planetsList.add(createPlanet("planet", "Neptune"));
		planetsList.add(createPlanet("planet", "Saturn"));
		planetsList.add(createPlanet("planet", "Uranus"));
		planetsList.add(createPlanet("planet", "Neptune"));

	}

	private HashMap<String, String> createPlanet(String key, String name) {
		HashMap<String, String> planet = new HashMap<String, String>();
		planet.put(key, name);

		return planet;
	}
	
	/*#### LISTA PROJETOS - FIM ####*/
}
