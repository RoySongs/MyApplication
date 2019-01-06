package com.example.a17_supportlibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.widget.ProgressBar;

public class ThirdFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // 다이얼로그
       /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(R.string.strBtn3);
        builder.setMessage(R.string.strBtn3_Detail);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog = builder.create();
        return dialog;
*/

        // 프로그레스바
        ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "돌아갑니다.","잠시만기다려주세요", true);
        return progressDialog;
    }
}
