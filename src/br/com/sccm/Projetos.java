package br.com.sccm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
		
		// React to user clicks on item
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				TextView clickedView = (TextView) view;
				Toast.makeText(Projetos.this, "Idem de ID "+id+" - Posição "+position+" na lista - De nome "+clickedView.getText(), Toast.LENGTH_SHORT).show();
				
			}
		});
		
		// we register for the contextmneu        
		registerForContextMenu(lv);
		
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
	
	// We want to create a context Menu when the user long click on an item
	  @SuppressWarnings("unchecked")
	@Override
	  public void onCreateContextMenu(ContextMenu menu, View v,
	          ContextMenuInfo menuInfo) {

	      super.onCreateContextMenu(menu, v, menuInfo);
	      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

	      SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});;
		HashMap<String, String> map =  ((HashMap<String, String>) simpleAdpt.getItem(aInfo.position));

	      menu.setHeaderTitle("Opções de " + map.get("planet"));
	      menu.add(1, 1, 1, "Detalhes");
	      menu.add(1, 2, 2, "Excluir");

	  }
	  
	// This method is called when user selects an Item in the Context menu
	  @Override
	  public boolean onContextItemSelected(MenuItem item) {
	      int itemId = item.getItemId();
	      // Implements our logic
	      Toast.makeText(this, "Item "+itemId, Toast.LENGTH_SHORT).show();
	      return true;
	  }
	
	
	/*#### LISTA PROJETOS - FIM ####*/
	
}
