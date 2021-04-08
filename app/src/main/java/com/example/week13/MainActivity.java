package com.example.week13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view) {


        ApiService service = ApiManager.getService();

        Call<List<TodoItem>> call = service.getList();
        Call<JSONArray> jsonArrayCall = service.getListAsJason();

        call.enqueue(new Callback<List<TodoItem>>() {
            @Override
            public void onResponse(Call<List<TodoItem>> call, Response<List<TodoItem>> response) {


                Log.d("MianActivity", "onRespons: " + response.code());

                if ( response.isSuccessful()) {

                    List<TodoItem> items = response.body();


                    for ( TodoItem item: items) {
                        Log.d("MianActivity", "onRespons: " + item.getTitle());




                    }

                    displayData(items);

                }

            }

            @Override
            public void onFailure(Call<List<TodoItem>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }


            private void displayData(List<TodoItem> list) {

                ListView listView = findViewById(R.id.list_view);

                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

                listView.setAdapter(adapter);

            }
}