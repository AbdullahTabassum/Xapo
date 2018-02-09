package com.abdullah.tabassum.xapoabdullahtabassum.mvvm.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdullah.tabassum.xapoabdullahtabassum.R;
import com.abdullah.tabassum.xapoabdullahtabassum.mvvm.viewmodel.RepoDetailsViewModel;
import com.abdullah.tabassum.xapoabdullahtabassum.persisitence.GitHubRepository;

public class RepoDetailsFragment extends Fragment {

    int repoId;

    public RepoDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_repo_details, container, false);


        LiveData<GitHubRepository> repoDetails =  ViewModelProviders.of(getActivity()).get(RepoDetailsViewModel.class).getRepo();

        final TextView name = v.findViewById(R.id.repoName);
        final TextView details = v.findViewById(R.id.repoDetails);
        final TextView forks = v.findViewById(R.id.repoForks);

        // Create the observer which updates the UI.
        final Observer<GitHubRepository> repoObserver = new Observer<GitHubRepository>() {
            @Override
            public void onChanged(@Nullable final GitHubRepository repo) {
                // Update the recycler view adapter with the data.
                name.setText(repo.full_name);
                details.setText(repo.description);
                forks.setText(String.valueOf(repo.forks));
            }
        };

        repoDetails.observe(getActivity(), repoObserver);
        return v;
    }

}
