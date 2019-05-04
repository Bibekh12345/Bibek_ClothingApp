package fragment;

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

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private EditText etreguser, etregpass;
    private Button btnreg;



    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        etreguser= view.findViewById(R.id.et_reguser);
        etregpass = view.findViewById(R.id.et_regpass);
        btnreg= view.findViewById(R.id.btn_register);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        return view;
    }

    private void Register() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", etreguser.getText().toString());
        editor.putString("password", etregpass.getText().toString());
        editor.commit();
        Toast.makeText(getContext(), "Successfully Registered", Toast.LENGTH_LONG).show();

    }
}
