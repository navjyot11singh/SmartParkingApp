package www.navjyotsingh.smartparkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import www.navjyotsingh.smartparkingapp.fragment.FindFragment;
import www.navjyotsingh.smartparkingapp.fragment.SearchParkingFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private SearchParkingFragment searchParkingFragment = new SearchParkingFragment();
    private FindFragment findFragment = new FindFragment();
    private BottomNavigationView mBottomNavigation;
    private Fragment activeFragment = null;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        setUpBottomNavigation();
        addAllFragmentOnce();
    }

    //    ------------------------views are ititialsed here-----------------------
    private void init() {
        mBottomNavigation = findViewById(R.id.nav_view);
    }

    //bottom navigatio view setup
    private void setUpBottomNavigation() {
        mBottomNavigation.setOnNavigationItemSelectedListener(MainActivity.this);
        manager = getSupportFragmentManager();
        activeFragment = searchParkingFragment;
    }
    //--------add the all the fragment on app start and only show home fragment and hide other fragments-----------------

    private void addAllFragmentOnce() {

        manager.beginTransaction()
                .add(R.id.parentLayout, activeFragment)
                .commit();

        manager.beginTransaction()
                .add(R.id.parentLayout, findFragment)
                .hide(findFragment)
                .commit();

//        manager.beginTransaction()
//                .add(R.id.parentLayout, hsPotCalmingActivitesFragment)
//                .hide(hsPotCalmingActivitesFragment)
//                .commit();
//
//        manager.beginTransaction()
//                .add(R.id.parentLayout, chatFragment)
//                .hide(chatFragment)
//                .commit();
//
//        manager.beginTransaction()
//                .add(R.id.parentLayout, accountFragment)
//                .hide(accountFragment)
//                .commit();
    }

    //-------show fragment based on selection item id---------------
    private void showHideFragment(Fragment fragment) {
        manager.beginTransaction()
                .hide(activeFragment)
                .show(fragment)
                .commit();
    }

    //    ------------------------this method is called when navigatin item is selected-----------
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.id1:
                clearBackStack();
                showHideFragment(searchParkingFragment);
                activeFragment = searchParkingFragment;
                break;

            case R.id.id2:
                clearBackStack();
                showHideFragment(findFragment);
                activeFragment = findFragment;
                break;

//            case R.id.id3:
//                clearBackStack();
//                FragmenCheck.ActivityFragment = "1";
//                Log.d("VALUE", FragmenCheck.ActivityFragment);
//                showHideFragment(hsPotCalmingActivitesFragment);
////                FragmenCheck.ActivityFragment="1";
//                activeFragment = hsPotCalmingActivitesFragment;
//                break;

        }
        return true;
    }

    //---------to hide navigatio drawer-----------
    public void hideNavigationDrawer() {
        mBottomNavigation.setVisibility(View.GONE);
    }

    //----------to show navigatin drawer--------------
    public void showNavigationDrawer() {
        mBottomNavigation.setVisibility(View.VISIBLE);
    }

    //    --------------clear the fragments from the stack-------------------
    private void clearBackStack() {
        FragmentManager fm = this.getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
}
