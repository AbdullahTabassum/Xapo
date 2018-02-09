package com.abdullah.tabassum.xapoabdullahtabassum;

/**
 * Created by mac on 2018-02-06.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;

import com.abdullah.tabassum.xapoabdullahtabassum.mvvm.view.RepoDetailsFragment;
import com.abdullah.tabassum.xapoabdullahtabassum.mvvm.view.TrendingRepositoriesFragment;

/**
 * This class is responsible for manging transitions between the detail and list fragments
 *
 * TOOD: brain storm if this calss needs to be a view model class - in order for it to be cleaned up when it needs to be
 */
public class TransitionManager {

    private Fragment currentFragment;

    public void initializeView(FragmentActivity a) {
        showInitialFragment(a);
    }

    public void showInitialFragment(FragmentActivity a) {
        showListFragment(a);
    }

    public void showDetailFragment(FragmentActivity a) {
        Fragment detailsFragment = new RepoDetailsFragment();
        FragmentTransaction transaction = a.getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, detailsFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public void showListFragment(FragmentActivity a){
        //
        Fragment listFragment = new TrendingRepositoriesFragment();
        FragmentTransaction transaction = a.getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.fragment_container, listFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public Fragment getCurrentFragment() {
        return null;
    }
}
