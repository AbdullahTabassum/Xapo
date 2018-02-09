package com.abdullah.tabassum.xapoabdullahtabassum.persisitence;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by mac on 2018-02-08.
 */

@Dao
public interface RepoDao {
    @Query("SELECT * FROM git_hub_repository")
    public LiveData<List<GitHubRepository>> getTrendingRepos();

    @Query("SELECT * FROM git_hub_repository WHERE uid = :repoId")
    public LiveData<GitHubRepository> getRepo(int repoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertRepos(List<GitHubRepository> trendingRepos);

}
