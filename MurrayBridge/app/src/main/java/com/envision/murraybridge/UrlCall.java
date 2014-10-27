package com.envision.murraybridge;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

/**
 * Created by Stephen Farrugia on 14/10/2014.
 */
public class UrlCall extends AsyncTask<String, Void, String>
{

    @Override
    protected String doInBackground(String... uri)
    {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        try
        {
            response = httpclient.execute(new HttpGet(uri[0]));

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.getEntity().writeTo(out);
            out.close();
            responseString = out.toString();
        }
        catch(ClientProtocolException e)
        {
            System.out.println("CE:" + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return responseString;
    }


    @Override
    protected void onPreExecute()
    {
    }
}