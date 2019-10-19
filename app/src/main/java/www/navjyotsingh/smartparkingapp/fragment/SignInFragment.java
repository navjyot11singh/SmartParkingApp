package www.navjyotsingh.smartparkingapp.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import www.navjyotsingh.smartparkingapp.LoginActivity;
import www.navjyotsingh.smartparkingapp.MainActivity;
import www.navjyotsingh.smartparkingapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {
    private TextView dontHaveAcctTv;
    private TextView forgotPasswordLink;
    private EditText passwordEdt;
    private EditText emailEdt;
    private Button signInBtn;
    private ImageView closeBtn;
    private View view;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";    //pattern for chicking valid emails


    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register_login, container, false);
        init();
        return view;
    }

    //-------------------initialising all the views here--------------
    private void init() {
        dontHaveAcctTv = view.findViewById(R.id.dontHaveAcctTv);
        forgotPasswordLink = view.findViewById(R.id.forgotPasswordLink);
        passwordEdt = view.findViewById(R.id.passwordEdt);
        emailEdt = view.findViewById(R.id.emailEdt);
        signInBtn = view.findViewById(R.id.signInBtn);
        closeBtn = view.findViewById(R.id.closeBtn);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAcctTv.setOnClickListener(this);
        signInBtn.setOnClickListener(this);
        closeBtn.setOnClickListener(this);
        forgotPasswordLink.setOnClickListener(this);

        textChange(); //setting up textwatcher here
    }

    //    --------------checking for the validations here-------------------------

    private void textChange() {
        emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passwordEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    //    ----------------checking the validations  here--------
    private void checkInputs() {
        if (!TextUtils.isEmpty(emailEdt.getText())) {
            if (!TextUtils.isEmpty(passwordEdt.getText())) {
                signInBtn.setEnabled(true);
                signInBtn.setTextColor(Color.rgb(255, 255, 255));
            } else {
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(50, 255, 255, 255));
            }
        } else {
            signInBtn.setEnabled(false);
            signInBtn.setTextColor(Color.argb(50, 255, 255, 255));
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.dontHaveAcctTv) {
            setFragment(new SignUpFragment());
        } else if (view.getId() == R.id.signInBtn) {
            checkEmailandPassword();
        } else if (view.getId() == R.id.closeBtn) {
            Intent mainIntent = new Intent(getActivity(), MainActivity.class);
            startActivity(mainIntent);
            getActivity().finish();
        }
//        } else if (view.getId() == R.id.forgotPasswordLink) {
//            LoginActivity.onResetPasswordFragment = true;  //changing value to true means we are now on register fragment
//            setFragment(new ResetPasswordFragment());
//        }
    }

    //    ---------checking for valid email and password and logging in -------------------------
    private void checkEmailandPassword() {
        if (emailEdt.getText().toString().matches(emailPattern)) {
            if (passwordEdt.length() >= 8) {
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(50, 255, 255, 255));

            } else {
                Toast.makeText(getActivity(), "Incorrect Email or Password", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(getActivity(), "Incorrect Email or Password", Toast.LENGTH_SHORT).show();


        }
    }

    //    ---------------------opening sign up fragment on text click here------------
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(R.id.register_frame_layout, fragment);
        fragmentTransaction.commit();
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.register_frame_layout, new SignUpFragment())
//                .commit();
    }

}
