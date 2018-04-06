package isl.busroad.baeminsu.busroaduser;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by alstn on 2017-09-07.
 */

public class Splash extends Activity {

    Handler handler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final PropertyManager propertyManager = PropertyManager.getInstance();


        final boolean login = propertyManager.getAutoLogin();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (login) {
                    Intent intent = new Intent(Splash.this, SelectAffActivity.class);
                   new AsyncSelect().execute(PropertyManager.getInstance().getAffiliation());

                } else {
                    Intent intent = new Intent(Splash.this, SelectAffActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };


    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    class AsyncSelect extends AsyncTask<String, Void, Void> {

        Response response;
        String aff;

        @Override
        protected Void doInBackground(String... strings) {
            aff = strings[0];
            final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            OkHttpClient okHttpClient = new OkHttpClient();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("aff", strings[0]);
                RequestBody body = RequestBody.create(JSON, jsonObject.toString());

                Request request = new Request.Builder()
                        .post(body)
                        .url("http://52.79.108.145/busstop_server/user_aff_select.php")
                        .build();

                response = okHttpClient.newCall(request).execute();
            } catch (JSONException | IOException e) {
                Log.e("체크1", e.toString());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            JSONObject jsonObject;

            try {
                String strResponse = response.body().string();
                jsonObject = new JSONObject(strResponse);
                String result = jsonObject.getString("msg");


                if (result.equals("성공")) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("affiliation", aff);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainContext.getContext(), "일치하는 소속이 없습니다", Toast.LENGTH_SHORT).show();
                }


            } catch (IOException | JSONException e) {
                e.printStackTrace();
                Log.e("체크2", e.toString());
            }


        }
    }

}
