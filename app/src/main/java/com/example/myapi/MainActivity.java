package com.example.myapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    ListView lsp;
    Mylistadapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lsp =findViewById(R.id.liv);

        String ls  = getResources().getString(R.string.link);

        final ArrayList<Products> pro = new ArrayList<>();

        try {


            String mysts = new Sycdata().execute(ls).get();
            System.out.println("this main activity"+mysts);


            JSONObject mainobj = new JSONObject(mysts);
            JSONArray proarray = mainobj.getJSONArray("products");


            for(int i = 0; i<proarray.length();i++){


                JSONObject childobj = proarray.getJSONObject(i);

                String name = childobj.getString("title");
                String pimg = childobj.getString("image");

                pro.add(new Products(pimg,name));

                //System.out.println("Bag Names: "+childobj.getString("title"));

                System.out.println("Arraylist size"+pro.size());

                adapt = new Mylistadapter(MainActivity.this,pro);

                lsp.setAdapter(adapt);

                lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(),pro.get(position).getPname(),Toast.LENGTH_LONG).show();

                        Intent i =new Intent(MainActivity.this,ProductDesc.class);

                        i.putExtra("mydata",pro.get(position));
                        startActivity(i);
                    }
                });
            }

        }catch (ExecutionException e)
        {
            Log.e("main class","Mail"+e.getMessage());
        }catch (InterruptedException e){
            Log.e("main class","Mail"+e.getMessage());
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
