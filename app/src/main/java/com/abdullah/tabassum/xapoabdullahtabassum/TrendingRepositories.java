package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class TrendingRepositories extends FragmentActivity implements OnRepoSelected{

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
