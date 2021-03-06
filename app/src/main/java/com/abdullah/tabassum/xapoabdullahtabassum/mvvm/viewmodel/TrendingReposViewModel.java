package com.abdullah.tabassum.xapoabdullahtabassum.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.abdullah.tabassum.xapoabdullahtabassum.datamanagement.GitHubRepoDataManager;
import com.abdullah.tabassum.xapoabdullahtabassum.GitRepoApplication;
import com.abdullah.tabassum.xapoabdullahtabassum.persisitence.GitHubRepository;

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
