package com.example.student.project4;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>  {

    private final ArrayList<Recipe> mRecipeList;
    private Context mContext;

    public RecipeListAdapter(Context context,
                             ArrayList<Recipe> RecipeList) {
        this.mRecipeList = RecipeList;
        this.mContext = context;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recipelist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.bindTo(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mRecipeTitle;
        private TextView mRecipeSubtitle;
        private TextView mRecipeDate;
        private TextView mRecipeIngredients;
        private TextView mRecipeInstructions;

        RecipeViewHolder(View itemView) {
            super(itemView);
            mRecipeTitle = (TextView)itemView.findViewById(R.id.recipe_title);
            mRecipeSubtitle = (TextView)itemView.findViewById(R.id.recipe_subtitle);
            mRecipeDate = (TextView)itemView.findViewById(R.id.recipe_date);

            itemView.setOnClickListener(this);
        }

        void bindTo(Recipe mCurrent){
            mRecipeTitle.setText(mCurrent.getTitle());
            mRecipeSubtitle.setText(mCurrent.getSubtitle());
            mRecipeDate.setText(mCurrent.getDate());
        }

        @Override
        public void onClick(View view) {

        }


    }
}
