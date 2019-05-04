package fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bibek_clothingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Button btnlogin;
    private EditText etloguser, etlogpass;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etloguser= view.findViewById(R.id.et_loguser);
        etlogpass= view.findViewById(R.id.et_logpass);
        btnlogin= view.findViewById(R.id.btn_login);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });




        return view;
    }
    private void Login(){

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        String Username =sharedPreferences.getString("username","");
        String Password =sharedPreferences.getString("password","");

        if(Username.equals(etloguser.getText().toString()) && Password.equals(etlogpass.getText().toString())){
            Intent intent = new Intent(getContext(), AfterLoginActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getContext(),"Incorrect Credentials.",Toast.LENGTH_LONG).show();

        }
    }

}
