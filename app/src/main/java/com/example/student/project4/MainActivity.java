package com.example.student.project4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Recipe> mRecipeList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeListAdapter(this, mRecipeList);
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData (){
        String[] titles = getResources().getStringArray(R.array.recipe_titles);
        String[] subtitles = getResources().getStringArray(R.array.recipe_subtitles);
        String[] date = getResources().getStringArray(R.array.recipe_date);
        String[] ingredients = getResources().getStringArray(R.array.recipe_ingredients);
        String[] instructions = getResources().getStringArray(R.array.recipe_instructions);

        mRecipeList.clear();

        for(int i=0; i < titles.length; i ++){
            mRecipeList.add(new Recipe(titles[i], subtitles[i],date[i], ingredients[i], instructions[i]));
        }

        mAdapter.notifyDataSetChanged();
    }
}
