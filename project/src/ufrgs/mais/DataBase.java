package ufrgs.mais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.*;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

public class DataBase {


@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public JSONArray bdUfrgs() {
	  
	  JSONArray jsonArray = null;
	  int SDK_INT = android.os.Build.VERSION.SDK_INT;
	  if(SDK_INT > 9){
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		  StrictMode.setThreadPolicy(policy);
  	
			  try {
			    jsonArray = new JSONArray (requestJson());
//			    for (int i = 0; i < jsonArray.length(); i++) {
//			      JSONObject jsonObject = jsonArray.getJSONObject(i);
//			      result = jsonObject.getString(fieldDB);
//			    }
			    return jsonArray;
			    
			  } catch (Exception e) {
			    e.printStackTrace();
			  }
  				}
	  		return jsonArray;
			}

		public static String requestJson() {
		  StringBuilder builder = new StringBuilder();
		  //HttpClient client = HttpClientBuilder.create().build();
		  DefaultHttpClient client = new DefaultHttpClient();
		  
		  HttpGet httpGet = new HttpGet("http://ufrgs.br/ufrgsmais/bdUfrgsMais.php"); //Aqui ele pega o json do tutorial, nessa linha que o seu cliente vai declarar o webservice que enviará o json
		 // return "Bom dia ";
		  try {
		    HttpResponse response = client.execute(httpGet);
		    StatusLine statusLine = response.getStatusLine();
		    int statusCode = statusLine.getStatusCode();
		    if (statusCode == 200) {
		      HttpEntity entity = response.getEntity();
		      InputStream content = entity.getContent();
		      BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		      String line;
		      while ((line = reader.readLine()) != null) {
		        builder.append(line);
		      }
		    } 
		  } catch (ClientProtocolException e) {
		    e.printStackTrace();
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		  return builder.toString();
		}
}
