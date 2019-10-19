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

import java.util.HashMap;
import java.util.Map;

import www.navjyotsingh.smartparkingapp.MainActivity;
import www.navjyotsingh.smartparkingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {
//    ------------------initialisg views here--------------

    private TextView alreadyHaveAcctTv;
    private View view;

    private EditText nameEdt;
    private EditText emailEdt;
    private EditText passwordEdt;
    private EditText confirmPasswordEdt;

    private ImageView closeBtn;
    private Button signUpBtn;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";    //pattern for chicking valid emails

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        init();
        return view;
    }
    //    ----------------------------initialsing views here---------------------------------------
    private void init() {

        alreadyHaveAcctTv = view.findViewById(R.id.alreadyHaveAcctTv);
        nameEdt = view.findViewById(R.id.nameEdt);
        emailEdt = view.findViewById(R.id.emailEdt);
        passwordEdt = view.findViewById(R.id.passwordEdt);
        confirmPasswordEdt = view.findViewById(R.id.confirmPasswordEdt);
        closeBtn = view.findViewById(R.id.closeBtn);
        signUpBtn = view.findViewById(R.id.signUpBtn);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveAcctTv.setOnClickListener(this);
        textChange(); //setting up textwatcher here
        closeBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
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
        nameEdt.addTextChangedListener(new TextWatcher() {
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
        confirmPasswordEdt.addTextChangedListener(new TextWatcher() {
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

    //    -----------------checking all the inputs here--------------------
    private void checkInputs() {
        if (!TextUtils.isEmpty(emailEdt.getText())) {
            if (!TextUtils.isEmpty(nameEdt.getText())) {
                if (!TextUtils.isEmpty(passwordEdt.getText()) && passwordEdt.length() >= 8) {
                    if (!TextUtils.isEmpty(passwordEdt.getText())) {
                        signUpBtn.setEnabled(true);
                        signUpBtn.setTextColor(Color.rgb(255, 255, 255));
                    }
                } else {
                    signUpBtn.setEnabled(false);
                    signUpBtn.setTextColor(Color.argb(50, 255, 255, 255));
                }

            } else {
                signUpBtn.setEnabled(false);
                signUpBtn.setTextColor(Color.argb(50, 255, 255, 255));
            }
        } else {
            signUpBtn.setEnabled(false);
            signUpBtn.setTextColor(Color.argb(50, 255, 255, 255));
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.alreadyHaveAcctTv) {
            setFragment();
        } else if (view.getId() == R.id.signUpBtn) {
            checkEmailandPassword();
        } else if (view.getId()==R.id.closeBtn){
            Intent mainIntent = new Intent(getActivity(), MainActivity.class);
            startActivity(mainIntent);
            getActivity().finish();
        }
    }

    private void checkEmailandPassword() {
        if (emailEdt.getText().toString().matches(emailPattern)) {
            if (passwordEdt.getText().toString().equals(confirmPasswordEdt.getText().toString())) {
                signUpBtn.setEnabled(false);
                signUpBtn.setTextColor(Color.argb(50, 255, 255, 255));


            } else {
                confirmPasswordEdt.setError("Password dosen't match!");
            }
        } else {
            emailEdt.setError("Not a valid email addres");
        }
    }

    //    ---------------------opening fragment on text click here------------
    private void setFragment() {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);

        fragmentTransaction.replace(R.id.register_frame_layout, new SignInFragment());
        fragmentTransaction.commit();
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.register_frame_layout, new SignInFragment())
//                .commit();
    }

}
