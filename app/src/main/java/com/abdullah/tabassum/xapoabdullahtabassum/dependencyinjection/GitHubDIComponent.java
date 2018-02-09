package com.abdullah.tabassum.xapoabdullahtabassum.dependencyinjection;

import com.abdullah.tabassum.xapoabdullahtabassum.datamanagement.GitHubRepoDataManager;
import com.abdullah.tabassum.xapoabdullahtabassum.mvvm.viewmodel.RepoDetailsViewModel;
import com.abdullah.tabassum.xapoabdullahtabassum.mvvm.viewmodel.TrendingReposViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mac on 2018-02-07.
 */

@Component(modules = {TrendingReposDIModule.class})
@Singleton
public interface GitHubDIComponent {
    void inject(TrendingReposViewModel trendingRepoVM);
    void inject(RepoDetailsViewModel repoDetails);
    void inject(GitHubRepoDataManager dataManager);
}
