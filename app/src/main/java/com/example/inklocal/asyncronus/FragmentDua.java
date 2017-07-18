package com.example.inklocal.asyncronus;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentDua extends AppCompatActivity{
    private Button btnAsync;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dua);
        time = (EditText) findViewById(R.id.etTime);
        btnAsync = (Button) findViewById(R.id.btnAsync);
        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String sleepTime = time.getText().toString();
                runner.execute(sleepTime);
            }
        });

    }
    private class AsyncTaskRunner extends AsyncTask<String,String ,String>{
        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params){
            publishProgress("Sleeping...");
            try {
                int time = Integer.parseInt(params[0]) * 1000;

                Thread.sleep(time);

                resp = "Slept for" + params[0] + "secounds";
            }catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            }catch (Exception e){
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onPostExecute(String result){
            progressDialog.dismiss();
            finalResult.setText(result);
        }

        @Override
        protected void onPreExecute(){
            ProgressDialog.show(FragmentDua.this, "ProgressDialog","Wait for"+time.getText().toString()+"secounds");
        }

        @Override
        protected void onProgressUpdate(String... text){
            finalResult.setText(text[0]);
        }
    }
}
