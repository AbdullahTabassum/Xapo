package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mac on 2018-02-08.
 */

public class RepoDetailsViewModel extends ViewModel {

    @Inject
    GitHubRepoDataManager dataManager;
    private LiveData<GitHubRepository> repository;

    private int repoId;

    public RepoDetailsViewModel() {
        System.out.println("TrendingReposViewModel was called");
        GitRepoApplication.getGitHubDIComponent().inject(this);
    }

    public LiveData<GitHubRepository> getRepo() {

        this.repository = dataManager.getRepository(repoId);

        return repository;
    }

    public void setRepoId(int id){
        this.repoId = id;
    }
}
