package com.example.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ButtonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnPreto;
    private Button btnAzul;
    private Button btnAmarelo;
    private Button btnVerde;
    private Button btnVermelho;
    private FrameLayout colorFrame;

    private OnFragmentInteractionListener mListener;



    public ButtonsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ButtonsFragment newInstance(String param1, String param2) {
        ButtonsFragment fragment = new ButtonsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

         btnPreto = view.findViewById(R.id.btnPreto);
         btnAzul = view.findViewById(R.id.btnAzul);
         btnAmarelo = view.findViewById(R.id.btnAmarelo);
         btnVerde = view.findViewById(R.id.btnVerde);
         btnVermelho = view.findViewById(R.id.btnVermelho);

        colorFrame = view.findViewById(R.id.colorFrame);

         btnPreto.setOnClickListener(this);
         btnAzul.setOnClickListener(this);
         btnAmarelo.setOnClickListener(this);
         btnVerde.setOnClickListener(this);
         btnVermelho.setOnClickListener(this);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (mListener != null) {
        switch (v.getId()){
            case R.id.btnPreto:
                colorFrame.setBackgroundResource(R.color.black);
                break;
            case R.id.btnAzul:
                colorFrame.setBackgroundResource(R.color.blue);
                break;
            case R.id.btnAmarelo:
                colorFrame.setBackgroundResource(R.color.yellow);
                break;
            case R.id.btnVerde:
                colorFrame.setBackgroundResource(R.color.green);
                break;
            case R.id.btnVermelho:
                colorFrame.setBackgroundResource(R.color.red);
                break;
            default:
                break;
        }
           mListener.onFragment();
       }
    }

    public interface OnFragmentInteractionListener{
        void onFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}