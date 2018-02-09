package com.abdullah.tabassum.xapoabdullahtabassum.connections;

import com.abdullah.tabassum.xapoabdullahtabassum.persisitence.GitHubRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mac on 2018-02-04.
 */

public interface GitHubAPI {

    @GET("/repositories?sort=stars&q=topic:Android")
    Call<List<GitHubRepository>> getTrendingAndroidRepos();

}
