package com.abdullah.tabassum.xapoabdullahtabassum.dependencyinjection;

import com.abdullah.tabassum.xapoabdullahtabassum.GitHubRepoDataManager;
import com.abdullah.tabassum.xapoabdullahtabassum.RepoDetailsViewModel;
import com.abdullah.tabassum.xapoabdullahtabassum.TrendingReposViewModel;

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
