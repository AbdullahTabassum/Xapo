package com.abdullah.tabassum.xapoabdullahtabassum.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.abdullah.tabassum.xapoabdullahtabassum.OnRepoSelected;
import com.abdullah.tabassum.xapoabdullahtabassum.R;
import com.abdullah.tabassum.xapoabdullahtabassum.TransitionManager;
import com.abdullah.tabassum.xapoabdullahtabassum.mvvm.viewmodel.RepoDetailsViewModel;

public class TrendingRepositories extends FragmentActivity implements OnRepoSelected {

    private TransitionManager transitionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_repositories);

        //instantiate transition manager
        transitionManager = new TransitionManager();
        transitionManager.initializeView(this);
    }

    @Override
    public void onRepoSelected(int repoId) {
        ViewModelProviders.of(this).get(RepoDetailsViewModel.class).setRepoId(repoId);
        transitionManager.showDetailFragment(this);
    }
}
