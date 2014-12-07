package ufrgs.mais;

import java.util.Locale;


import ufrgs.mais.MainActivity.PlaceholderFragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import android.content.Intent;

public class Academico extends Activity  implements View.OnClickListener {

	Button btn;
	Button bVoltar;
	//TextView banco;

	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub	
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_academico);
		//banco = (TextView) findViewById(R.id.textViewAcademico);
		//btn=(Button)findViewById(R.id.button3);
        //btn.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Button is clicked!", Toast.LENGTH_LONG).show();
		
	}
	
	
}	
	