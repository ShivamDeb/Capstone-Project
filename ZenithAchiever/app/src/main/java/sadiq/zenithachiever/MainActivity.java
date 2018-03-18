package sadiq.zenithachiever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button signUp,logIn;
    EditText lreg_no,lpassword;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        signUp=findViewById(R.id.btn_signup);
        logIn=findViewById(R.id.btn_login);
        lreg_no=findViewById(R.id.uname);
        lpassword=findViewById(R.id.upass);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reg_no=lreg_no.getText().toString();
                String password =lpassword.getText().toString();
                String type="login";

                BackgroundTask bt =new BackgroundTask(MainActivity.this);
                bt.execute(type,reg_no,password);
                //callPage1();
               // Toast.makeText(getApplicationContext(),"Hi There "+BackgroundTask.sname+" id :  "+BackgroundTask.reg_id,Toast.LENGTH_SHORT).show();

                //getJSON("http://rkcapstone.000webhostapp.com/client/login.php");
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });


    }
   /* public void callPage1()
    {
        if (BackgroundTask.name!=null) {
            Intent i = new Intent(MainActivity.this, First_Page.class);
            startActivity(i);
        }
        else
            Toast.makeText(getApplicationContext(),"Nope ",Toast.LENGTH_SHORT).show();
    }



    //Test

    /*private void getJSON(final String urlWebService) {



        class GetJSON extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s+"hi", Toast.LENGTH_SHORT).show();
                try {
                    String reg_no=lreg_no.getText().toString();
                    String password =lpassword.getText().toString();
                    String type="login";
                    BackgroundTask bt =new BackgroundTask(MainActivity.this);
                     bt.execute(type,reg_no,password);
                    //Toast.makeText(getApplicationContext(), s+"hi Try 1", Toast.LENGTH_SHORT).show();
                    load(s);
                   // Toast.makeText(getApplicationContext(), s+"hi Try 2", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), s+"Exception hai bhai ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... args) {



                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void load(String json) throws JSONException {

        JSONObject jsonArray = new JSONObject(json);
        String sname=jsonArray.getString("name");
       int reg_id =jsonArray.getInt("reg_id");
       Toast.makeText(getApplicationContext(),"Hi There "+sname+" id :  "+reg_id,Toast.LENGTH_SHORT).show();



    } */


}

