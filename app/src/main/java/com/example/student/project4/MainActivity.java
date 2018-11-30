package com.example.student.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Recipe> mRecipeList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeListAdapter(this, mRecipeList);
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        String[] image;
        image = getResources().getStringArray( R.array.recipe_images);
        String[] titles = getResources().getStringArray(R.array.recipe_titles);
        String[] subtitles = getResources().getStringArray(R.array.recipe_subtitles);
        String[] date = getResources().getStringArray(R.array.recipe_date);
        String[] ingredients = getResources().getStringArray(R.array.recipe_ingredients);
        String[] instructions = getResources().getStringArray(R.array.recipe_instructions);

        mRecipeList.clear();

        for (int i = 0; i < titles.length; i++) {
            mRecipeList.add(new Recipe(image[i] , titles[i], subtitles[i], date[i], ingredients[i], instructions[i]));
        }

        mAdapter.notifyDataSetChanged();
    }

    public void openWebsite(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/madisonne-cooper-61451a145/?trk=pub-pbmap"));
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.share:
                displayToast("Share");
                return true;
            case R.id.location:
                displayToast("Created In Memphis,TN");
                return true;
            case R.id.developer:
//                openWebsite(View );
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }

}
