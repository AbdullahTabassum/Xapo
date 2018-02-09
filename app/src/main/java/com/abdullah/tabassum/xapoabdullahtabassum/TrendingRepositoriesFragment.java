package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class TrendingRepositoriesFragment extends Fragment implements OnRepoSelected {

    private RecyclerView reposRecyclerView;
    private TrendingReposAdapter reposAdapter;

    public TrendingRepositoriesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_trending_repositories, container, false);

        LiveData<List<GitHubRepository>> trendingRepos =  ViewModelProviders.of(getActivity()).get(TrendingReposViewModel.class).getTrendingRepos();

        reposRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        List<GitHubRepository> test = new ArrayList<GitHubRepository>();
        reposAdapter = new TrendingReposAdapter(test, this);
        reposRecyclerView.setAdapter(reposAdapter);
        reposRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create the observer which updates the UI.
        final Observer<List<GitHubRepository>> reposObserver = new Observer<List<GitHubRepository>>() {
            @Override
            public void onChanged(@Nullable final List<GitHubRepository> repos) {
                // Update the recycler view adapter with the data.
                reposAdapter.setRepositories(repos);
                reposAdapter.notifyDataSetChanged();
            }
        };

        trendingRepos.observe(getActivity(), reposObserver);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onRepoSelected(int repoId) {
        ((TrendingRepositories)getActivity()).onRepoSelected(repoId);
    }
}
