package com.demo.androidlearn01;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment07 extends Fragment {

    private TextView tv_miaoshu;
    private Button btn_zhedie;

    public Fragment07() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment07, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_miaoshu = (TextView) getActivity().findViewById(R.id.tv_zhediemiaoshu);
        btn_zhedie = (Button) getActivity().findViewById(R.id.btn_fragment_zhedie);

        tv_miaoshu.setText("");

        btn_zhedie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getActivity(),CollapsingToolbarActivity.class));
            }
        });

    }
}
