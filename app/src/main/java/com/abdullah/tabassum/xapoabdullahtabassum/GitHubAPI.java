package com.abdullah.tabassum.xapoabdullahtabassum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mac on 2018-02-04.
 */

public interface GitHubAPI {

    @GET("/repositories?sort=stars&q=topic:Android")
    Call<List<GitHubRepository>> getTrendingAndroidRepos();

}
