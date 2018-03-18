package sadiq.zenithachiever;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Sadiq on 3/11/2018.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    public static  String name;
    public static int reg_id;
    public BackgroundTask(Context context) {
        this.context=context;
    }
    @Override
    protected String doInBackground(String... param) {
        String type =param[0];
        String login_url="http://rkcapstone.000webhostapp.com/client/login.php";
       if(type.equals("login")) try {
            String reg_id=param[1];
            String u_password=param[2];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data= URLEncoder.encode("reg_id","UTF-8")+"="+URLEncoder.encode(reg_id,"UTF-8")+"&"+
                    URLEncoder.encode("u_password","UTF-8")+"="+URLEncoder.encode(u_password,"UTF-8");
            bw.write(post_data);
            bw.flush();
            bw.close();
            outputStream.close();

            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line=br.readLine())!=null)
            {
                result+=line;
            }
            br.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(type.equals("login"))
        {

        }
        return null;
    }

    @Override
    protected void onPreExecute() {

       // alertDialog= new AlertDialog.Builder(context).create();
       // alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            load(result);
            //MainActivity obj = new MainActivity();
            //obj.callPage1();
            alertDialog.setMessage(result+name);
           alertDialog.show();
        } catch (JSONException e) {
            e.printStackTrace();
            //Toast.makeText(BackgroundTask.this,"Excep in fetching ",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(String aVoid) {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
    private String load(String json) throws JSONException {

        JSONObject jsonArray = new JSONObject(json);
           String sname=jsonArray.getString("name");
         //reg_id =jsonArray.getInt("reg_id"
        //Toast.makeText(getApplicationContext(),"Hi There "+sname+" id :  "+reg_id,Toast.LENGTH_SHORT).show();

return  sname;

    }


}
