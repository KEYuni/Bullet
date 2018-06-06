package com.keyuni.android.bullet.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.keyuni.android.bullet.R;

public class ChequeFragment extends Fragment {


    public ChequeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cheque, container, false);
    }
}
