package com.abdullah.tabassum.xapoabdullahtabassum;

import android.app.Application;
import android.content.Context;

import com.abdullah.tabassum.xapoabdullahtabassum.dependencyinjection.GitHubDIComponent;
import com.abdullah.tabassum.xapoabdullahtabassum.dependencyinjection.TrendingReposDIModule;

/**
 * Created by mac on 2018-02-07.
 */

public class GitRepoApplication extends Application {
    private static GitHubDIComponent gitHubDIComponent;

    public static GitHubDIComponent getGitHubDIComponent() {
        return gitHubDIComponent;
    }

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        gitHubDIComponent = buildComponent();
        GitRepoApplication.context = getApplicationContext();
    }

    public static Context getContext() {
        return GitRepoApplication.context;
    }

    protected GitHubDIComponent buildComponent() {
        return com.abdullah.tabassum.xapoabdullahtabassum.dependencyinjection.DaggerGitHubDIComponent.builder().trendingReposDIModule(new TrendingReposDIModule()).build();
    }
}
