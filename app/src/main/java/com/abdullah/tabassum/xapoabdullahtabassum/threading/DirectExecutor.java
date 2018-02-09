package com.abdullah.tabassum.xapoabdullahtabassum.threading;

import java.util.concurrent.Executor;

/**
 * Created by mac on 2018-02-08.
 */

public class DirectExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}
