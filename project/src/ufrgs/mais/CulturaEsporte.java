package ufrgs.mais;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CulturaEsporte  extends Activity  implements View.OnClickListener {

	Button btn;
	Button bVoltar;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub	
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_culturaesporte);
		//btn=(Button)findViewById(R.id.button3);
        //btn.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Button is clicked!", Toast.LENGTH_LONG).show();
		
	}
}	
