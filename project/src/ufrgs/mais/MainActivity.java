package ufrgs.mais;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import android.widget.Toast;




public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private TextView introText;
    
    static DataBase consult = new DataBase();
    JSONArray jsonArray = consult.bdUfrgs();
    //static String textDB = consult.bdUfrgs("calendarioAca");
    public final static String EXTRA_MESSAGE = "Testando.o.bando.de.dados.UFRGS+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
       
  
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();    	
    }
    
    public String bancoDeDados(String fieldDB){
    	
    	String result = null;
    	
    	try{
		    for (int i = 0; i < jsonArray.length(); i++) {
		      JSONObject jsonObject = jsonArray.getJSONObject(i);
		      result = jsonObject.getString(fieldDB);
		    }
    	}catch (Exception e) {
		    e.printStackTrace();
		  }
    	
    	return result;
    }
    
	public void textFromDB(String fieldDB, String title){
		Intent intent = new Intent(this, TextFromDB.class);
		Bundle argv = new Bundle();
		
		//argv.putString("fieldDB", bancoDeDados(fieldDB));	//passa o campo do banco de dados requisitado
		//argv.putStringArrayList("fieldDB", new String[]{"",""});
		argv.putStringArray("fieldDB", new String[] {bancoDeDados(fieldDB),title});
		intent.putExtras(argv);
		startActivity(intent);
	}
	
	//Academico
	public void formatura(View view){
		textFromDB("formatura", "Formatura"); 	// Campo da tabela e o Título da tela
	}
	
	public void matriculaVet(View view){
		textFromDB("matriculaVet", "Matrícula Veteranos");
	}
	
	public void matriculaCal(View view){
		textFromDB("matriculaCal", "Matrícula Calouros");
	}
	
	public void calendarioAca(View view){
		textFromDB("calendarioAca", "Calendário Acadêmico");
	}
	
	//Ingresso
	public void passos(View view){
		textFromDB("passos", "Primeiros Passos");
	}
	
	public void cotas(View view){
		textFromDB("cotas", "Cotas");
	}
	
	public void sisu(View view){
		textFromDB("sisu", "SISU");
	}
	
	public void cursos(View view){
		textFromDB("cursos", "Cursos oferecidos");
	}
	
	public void vestibular(View view){
		textFromDB("vestibular", "Vestibular");
	}
	
	//Serviços
	public void biblioteca(View view){
		textFromDB("biblioteca", "Bibliotecas");
	}
	
	public void ru(View view){
		textFromDB("restaurante", "Restaurante Universitário");
	}
	
	public void assSaude(View view){
		textFromDB("assSaude", "Assistência à Saúde");
	}
	
	public void coloniaFerias(View view){
		textFromDB("coloniaFerias", "Colônia de Férias");
	}
	
	public void casaEstudante(View view){
		textFromDB("casaEstudante", "Casa do Estudante");
	}
	
	// Facilidades
	public void linhasOnibus(View view){
		textFromDB("linhas", "Linhas de Ônibus");
	}
	
	public void servicos(View view){
		textFromDB("servicos", "Serviços Externos");
	}
	
	public void telefones(View view){
		textFromDB("telefones", "Telefones");
	}
	
	public void mapas(View view){
		textFromDB("mapa", "Mapas do Campi");
	}
	
	//Beneficios
	public void auxilios(View view){
		textFromDB("auxilios", "Auxílios");
	}
	
	public void monitoria(View view){
		textFromDB("monitoria", "Monitoria Acadêmica");
	}
	
	public void bolsas(View view){
		textFromDB("bolsas", "Bolsas");
	}
	
	public void mobilidade(View view){
		textFromDB("mobilidade", "Mobilidade Acadêmica");
	}
	
	public void ic(View view){
		textFromDB("ic", "Iniciação Científica");
	}
	
	// Cultura e esporte
	public void radio(View view){
		textFromDB("radio", "Rádio da universidade");
	}
	
	public void agenda(View view){
		textFromDB("agenda", "Agenda Cultural");
	}
	
	public void jornal(View view){
		textFromDB("jornal", "Jornal da Universidade");
	}
	
	public void esporte(View view){
		textFromDB("esporte", "Esporte");
	}
      

    public void onSectionAttached(int number) {
        switch (number) {
	        case 1:
	            mTitle = getString(R.string.title_Home);
	            break;
	        case 2:
                mTitle = getString(R.string.title_Acad);
                break;
            case 3:
                mTitle = getString(R.string.title_BenOpo);
                break;
            case 4:
                mTitle = getString(R.string.title_CulEsp);
                break;
            case 5:
                mTitle = getString(R.string.title_Fac);
                break;
            case 6:
                mTitle = getString(R.string.title_Ing);
                break;
            case 7:
                mTitle = getString(R.string.title_Ser);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment /*implements OnClickListener*/ {
    	
    	int numberInDrawer;
    	Button btn;
    	ImageButton imgButton;
        
    	/**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	
        	int number = getArguments().getInt(ARG_SECTION_NUMBER);
        	numberInDrawer=number;
        	//Toast.makeText(getActivity(), number+ " dancando agora.", Toast.LENGTH_SHORT).show();
        	 View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        	switch (number) {
             case 1:
            	 rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            	 btn = (Button) rootView.findViewById(R.id.button1);
//                 btn.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voc� est� no HOME",
//                                 Toast.LENGTH_LONG).show();
//                         Intent intent = new Intent(getActivity(), Academico.class);
//                         startActivity(intent);    
//                        // finish();
//                     }
//                 });
            	 break;
             case 2:
            	 rootView = inflater.inflate(R.layout.activity_academico, container, false);
            	 imgButton = (ImageButton) rootView.findViewById(R.id.buttonCalendario);
            	// imgButton.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voce está no Calendario",
//                                 Toast.LENGTH_LONG).show();
//                     }
                // });
            	 break;
             case 3:
            	 rootView = inflater.inflate(R.layout.activity_benefoport, container, false);
            	 imgButton = (ImageButton) rootView.findViewById(R.id.buttonAuxilios);
//            	 imgButton.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voc� est� no Benef�cios e Oportunidades",
//                                 Toast.LENGTH_LONG).show();
//                     }
//                 });

            	 break;
             case 4:
            	 rootView = inflater.inflate(R.layout.activity_culturaesporte, container, false);
            	 imgButton = (ImageButton) rootView.findViewById(R.id.buttonEsporte);
//            	 imgButton.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voc� est� no Cultura e Esporte",
//                                 Toast.LENGTH_LONG).show();
//                     }
//                 });
            	 break;
             case 5:
            	 rootView = inflater.inflate(R.layout.activity_facilidades, container, false);
            	 imgButton = (ImageButton) rootView.findViewById(R.id.buttonMapas);
//            	 imgButton.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voc� est� no Facilidades",
//                                 Toast.LENGTH_LONG).show();
//                     }
//                 });
            	 break;
             case 6:
            	 rootView = inflater.inflate(R.layout.activity_ingresso, container, false);
            	 imgButton = (ImageButton) rootView.findViewById(R.id.buttonVestibular);
//            	 imgButton.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voc� est� no Ingresso",
//                                 Toast.LENGTH_LONG).show();
//                     }
//                 });
            	 break;	 
             case 7:
            	 rootView = inflater.inflate(R.layout.activity_servicos, container, false);
            	 imgButton = (ImageButton) rootView.findViewById(R.id.buttonRu);
//            	 imgButton.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         Toast.makeText(getActivity(), "Voc� est� no Servi�os",
//                                 Toast.LENGTH_LONG).show();
//                     }
//                 });
            	 break;	 	
         }
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
/*
		@Override
		public void onClick(DialogInterface dialog, int which) {
			Toast.makeText(this.getActivity(), "Button is clicked!", Toast.LENGTH_LONG).show();
			
		}        
  */      
    }

}
