package com.example.sergey.mobdev;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class secondLabFragment extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder.setTitle("Information").setMessage("Application was created by student group IS-51, Sergey Yakovenko.\nPress OK to close window.").setPositiveButton("OK", null).create();
    }

}

