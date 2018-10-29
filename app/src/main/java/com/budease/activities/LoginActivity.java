package com.budease.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.budease.R;
import com.budease.fragments.GetNumber;
import com.budease.fragments.IntroTemplate;
import com.budease.fragments.VerifyNumber;

public class LoginActivity extends FragmentActivity implements GetNumber.OnNumberEnteredListener {

    private FrameLayout loginContainer;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button loginTransactionBtn;
    private int FRAGMENT_IDENTIFIER = 0;
    private String userPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginContainer = (FrameLayout) findViewById(R.id.loginContainer);
        loginTransactionBtn = (Button) findViewById(R.id.loginTransactionBtn);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.loginContainer,IntroTemplate.getInstance(R.drawable.ic_launcher_background));
        fragmentTransaction.commit();

        loginTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (FRAGMENT_IDENTIFIER){
                    case 0:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.loginContainer,IntroTemplate.getInstance(R.drawable.ic_launcher_background));
                        fragmentTransaction.commit();
                        FRAGMENT_IDENTIFIER++;
                        break;
                    case 1:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.loginContainer,IntroTemplate.getInstance(R.drawable.common_google_signin_btn_icon_dark));
                        fragmentTransaction.commit();
                        FRAGMENT_IDENTIFIER++;
                        break;
                    case 2:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.loginContainer,new GetNumber());
                        fragmentTransaction.commit();
                        FRAGMENT_IDENTIFIER++;
                        loginTransactionBtn.setEnabled(false);
                        break;
                    case 3:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        Fragment fragment = new VerifyNumber();
                        Bundle bundle = new Bundle();
                        bundle.putString("PhoneNumber",userPhoneNumber);
                        fragment.setArguments(bundle);
                        fragmentTransaction.replace(R.id.loginContainer,fragment);
                        FRAGMENT_IDENTIFIER++;
                        break;
                    case 4:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.loginContainer,new GetNumber());
                        fragmentTransaction.commit();
                        //FRAGMENT_IDENTIFIER++;
                        loginTransactionBtn.setEnabled(false);
                        loginTransactionBtn.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }

    @Override
    public void onNumberFetched(String number) {
        this.userPhoneNumber = number;
        loginTransactionBtn.setEnabled(true);
    }
}
