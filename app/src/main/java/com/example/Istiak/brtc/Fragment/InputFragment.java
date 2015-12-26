package com.example.zahid.brtc.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zahid.brtc.DataBase.DBHelper;
import com.example.zahid.brtc.DataBase.Helper;
import com.example.zahid.brtc.ListActivity;
import com.example.zahid.brtc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    EditText vno,tire,gearbox,mobil,oil,engine;
    Button save,show;


    public InputFragment() {
        // Required empty public constructor
    }





        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.fragment_input, container, false);
            vno = (EditText) rootView.findViewById(R.id.editTextVehicleNo);
            tire = (EditText) rootView.findViewById(R.id.editTextTire);
            gearbox = (EditText) rootView.findViewById(R.id.editTexGearBox);
            mobil = (EditText) rootView.findViewById(R.id.editTextMobil);
            oil = (EditText) rootView.findViewById(R.id.editTextOil);
            engine = (EditText) rootView.findViewById(R.id.editTextEngine);
            save = (Button) rootView.findViewById(R.id.buttonSave);
            show = (Button) rootView.findViewById(R.id.buttonShowList);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            Helper helper = new Helper(vno.getText().toString(), tire.getText().toString(), gearbox.getText().toString(), mobil.getText().toString(), oil.getText().toString(),engine.getText().toString());
             DBHelper dbHelper=new DBHelper(getActivity(), null, null, 1);

                    dbHelper.addInfo(helper);
                    Toast.makeText(getActivity(), vno.getText().toString() + " has been successfully saved.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity().getApplication(), ListActivity.class);
                    startActivity(i);


                }
            });
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity().getApplication(), ListActivity.class);
                    startActivity(i);
                }
            });

            return rootView;
        }

}
