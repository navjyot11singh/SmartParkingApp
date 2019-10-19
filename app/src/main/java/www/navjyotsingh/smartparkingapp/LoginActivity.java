package www.navjyotsingh.smartparkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import www.navjyotsingh.smartparkingapp.fragment.SignInFragment;

public class LoginActivity extends AppCompatActivity {
    //----------declaration of all the views with access specifier-----------------
    private FrameLayout frameLayout;

    public static boolean onResetPasswordFragment = false;//to make the fraagment to returnn to sign in fragment on back press

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setDefaultFragment(new SignInFragment());
    }

    //--------------------setting fragment here-------------------
    private void setDefaultFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();

//       ----------alternative method-----------------
//        getSupportFragmentManager().beginTransaction().replace(frameLayout.getId(),fragment)
//                .commit();
    }

    //---------------Initialsing all the views here-----------
    private void init() {
        frameLayout = findViewById(R.id.register_frame_layout);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (onResetPasswordFragment) {
                onResetPasswordFragment = false;
                setFragment(new SignInFragment());
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //    ---------------------opening fragment on text click here------------
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);

        fragmentTransaction.replace(R.id.register_frame_layout, fragment);
        fragmentTransaction.commit();
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.register_frame_layout, new SignInFragment())
//                .commit();
    }
}
