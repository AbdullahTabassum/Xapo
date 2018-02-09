package com.abdullah.tabassum.xapoabdullahtabassum;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by mac on 2018-02-05.
 */

public class TrendingReposAdapter extends RecyclerView.Adapter<TrendingReposAdapter.ViewHolder> {

    //reference the data source
    private List<GitHubRepository> repositories;
    private OnRepoSelected selectionListener;

    public TrendingReposAdapter(List<GitHubRepository> repos, OnRepoSelected listener) {
        this.repositories = repos;
        this.selectionListener = listener;
    }

    //only used in this class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mainTitle;
        private TextView description;
        private TextView size;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");

                    //transition to fragment with the details of the selected repo
                    selectionListener.onRepoSelected(repositories.get(getAdapterPosition()).uid);

                }
            });

            mainTitle = (TextView) v.findViewById(R.id.repo_name);
            description = (TextView) v.findViewById(R.id.repo_description);
            size = (TextView) v.findViewById(R.id.repo_size);
        }

        public TextView getMainTitle() {
            return mainTitle;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getSize() {
            return size;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.repository_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        viewHolder.getMainTitle().setText( repositories.get(position).name );
        viewHolder.getDescription().setText( repositories.get(position).description );
        viewHolder.getSize().setText( "Size: " + repositories.get(position).size );
    }

    @Override
    public int getItemCount() {
        if (repositories == null)
            return 0;
        else return repositories.size();
    }

    public void setRepositories(List<GitHubRepository> repos) {
        this.repositories = repos;
    }
}
