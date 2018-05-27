package com.example.sergey.mobdev;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class fragmentEdit extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragment_edit, container, false);
        Button buttonOk = (Button) view.findViewById(R.id.ok_button);
        Button buttonCancel = (Button) view.findViewById(R.id.cancel_button);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) view.findViewById(R.id.edit_message);
                EditText textSize = (EditText) view.findViewById(R.id.edit_textsize);
                editText.setText("");
                textSize.setText("");
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(view);
            }
        });
        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String message, String size);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " interface OnFragmentInteractionListener was not finded");
        }
    }
    public void updateDetail(View v) {



        EditText editText = (EditText) v.findViewById(R.id.edit_message);
        EditText textSize = (EditText) v.findViewById(R.id.edit_textsize);
        String message = editText.getText().toString();
        String size = textSize.getText().toString();
        // Посылаем данные Activity
        mListener.onFragmentInteraction(message , size);
    }
}