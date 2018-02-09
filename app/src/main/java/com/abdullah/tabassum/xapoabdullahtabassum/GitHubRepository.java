package com.abdullah.tabassum.xapoabdullahtabassum;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mac on 2018-02-04.
 */


@Entity(tableName = "git_hub_repository")
public class GitHubRepository {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "full_name")
    public String full_name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "size")
    public int size;

    @ColumnInfo(name = "watchers")
    public int watchers;

    @ColumnInfo(name = "forks")
    public int forks;

    @ColumnInfo(name = "score")
    public double score;

}
