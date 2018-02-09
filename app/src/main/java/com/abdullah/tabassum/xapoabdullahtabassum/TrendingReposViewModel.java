package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by mac on 2018-02-05.
 */

public class TrendingReposViewModel extends ViewModel {

    @Inject
    GitHubRepoDataManager dataManager;

    public TrendingReposViewModel() {
        System.out.println("TrendingReposViewModel was called");
        //this.dataManager = dataRepo;
        GitRepoApplication.getGitHubDIComponent().inject(this);
    }

    /**
     * List of git repos
     */
    private LiveData<List<GitHubRepository>> trendingRepos;

    /**
     * Lazy loading of the data here
     * @return
     */
    public LiveData<List<GitHubRepository>> getTrendingRepos() {
        if( this.trendingRepos == null) {
            this.trendingRepos = dataManager.getTrendingRepos();
        }
        return trendingRepos;
    }
}
