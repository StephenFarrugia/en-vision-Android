package com.envision.murraybridge;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;


public class ActivityIndex extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
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

    public void OnButtonClick(View i) {
        System.out.println("Working");
        try {
            System.out.println("Working try");
            // Calls a website this will run in the background
            String data = new UrlCall().execute("http://www.blacklancestudio.com/testcode.php").get();
            readJSON(data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readJSON(String jsonData) {
        try {
            JSONObject jsonObj = new JSONObject(jsonData);

            JSONObject response = jsonObj.getJSONObject("response");
            System.out.println(response.getString("msg"));
            System.out.println(response.getString("success"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
