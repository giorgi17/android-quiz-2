package com.giorgi.android_quiz_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ArrayList<Post> posts = new ArrayList<Post>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.txt);

        String url = "https://jsonplaceholder.typicode.com/todos";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                mTextView.setText(response);
//                JSONObject jsonObject2 = new JSONObject(response);
                try {
//                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = new JSONArray(response);
//                    mTextView.setText(jsonArray + "");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject dt = jsonArray.getJSONObject(i);
                        Post post = new Post(dt.getInt("id"), dt.getInt("id"), dt.getString("title"), dt.getString("completed"));
                        posts.add(post);
//                        mTextView.setText(dt.getString("title") + "");
                        // Do you fancy stuff
                        // Example: String gifUrl = jo.getString("url");
                        if (i == 50){
                            String g = posts.size() + "";
                            mTextView.setText("fuck - " + g);
                            return;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
//                    mTextView.setText(e + "");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Anything you want
            }
        });
        queue.add(stringRequest);

        // RECYCLER VIEW
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(posts);
        recyclerView.setAdapter(mAdapter);
    }
}
