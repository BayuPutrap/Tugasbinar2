package com.example.inklocal.asyncronus;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Inklocal on 7/18/2017.
 */

public class FragmentSatu extends Fragment{

    EditText etfragment_satu;
    Button btnfragment_satu;

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_satu, container, false);

        etfragment_satu = (EditText) view.findViewById(R.id.etfragment_Satu);

        btnfragment_satu = (Button) view.findViewById(R.id.btnfragment_Satu);
        btnfragment_satu.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Toast.makeText(getActivity().getApplicationContext(),etfragment_satu.getText().toString(), Toast.LENGTH_SHORT).show();

             }
         });

         return view;
    }
}