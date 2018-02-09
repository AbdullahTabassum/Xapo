package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.abdullah.tabassum.xapoabdullahtabassum.connections.GitHubAPI;
import com.abdullah.tabassum.xapoabdullahtabassum.persisitence.GitHubDatabase;
import com.abdullah.tabassum.xapoabdullahtabassum.threading.DirectExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mac on 2018-02-07.
 */
@Module
public class TrendingReposDIModule {

        @Provides
        @Singleton
        @NonNull
        public GitHubRepoDataManager getGHDataManager() {
            return new GitHubRepoDataManager();
        }


        @Provides
        @NonNull
        public GitHubAPI getGITHubAPIClient() {
                Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/search/")
                .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();

                return retrofit.create(GitHubAPI.class);
        }

        @Provides
        @NonNull
        public Executor getExecutor() {
                return new DirectExecutor();
        }

        @Provides
        @NonNull
        @Singleton
        public GitHubDatabase getGitHubDB() {
                return  Room.databaseBuilder(GitRepoApplication.getContext(), GitHubDatabase.class, "database-name").build();
        }
}
