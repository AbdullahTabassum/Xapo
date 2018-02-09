package com.abdullah.tabassum.xapoabdullahtabassum.persisitence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.abdullah.tabassum.xapoabdullahtabassum.GitHubRepository;

/**
 * Created by mac on 2018-02-08.
 */

@Database(entities = {GitHubRepository.class}, version = 1)
public abstract class GitHubDatabase extends RoomDatabase{
    public abstract RepoDao repoDao();
}
