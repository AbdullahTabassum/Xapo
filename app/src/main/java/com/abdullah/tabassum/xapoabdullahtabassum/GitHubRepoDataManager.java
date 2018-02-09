package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.lifecycle.LiveData;

import com.abdullah.tabassum.xapoabdullahtabassum.persisitence.GitHubDatabase;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by mac on 2018-02-05.
 * This class abstracts the data source for requests for GitHubRepo data
 */

public class GitHubRepoDataManager {

    @Inject
    GitHubAPI client;

    @Inject
    GitHubDatabase ghBD;

    @Inject
    Executor executor;

    public GitHubRepoDataManager() {
        GitRepoApplication.getGitHubDIComponent().inject(this);
    }

    public LiveData<List<GitHubRepository>> getTrendingRepos() {
        //TODO: implement paging, and periodic refreshing, forced refreshing
        final Call<List<GitHubRepository>> call = client.getTrendingAndroidRepos();
        executor.execute(new Runnable() {
                             @Override
                             public void run() {
                                try {
                                    Response<List<GitHubRepository>> response = call.execute();
                                    for(GitHubRepository repo : response.body()) {
                                        System.out.println(repo);
                                    }
                                    ghBD.repoDao().insertRepos(response.body());

                                } catch(Exception e) {
                                    e.printStackTrace();
                                }
                             }
                         }
        );
        return ghBD.repoDao().getTrendingRepos();
    }

    public LiveData<GitHubRepository> getRepository(int id) {
        return ghBD.repoDao().getRepo(id);
    }

}
