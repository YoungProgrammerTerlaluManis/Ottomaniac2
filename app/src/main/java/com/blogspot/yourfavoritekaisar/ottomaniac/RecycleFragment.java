package com.blogspot.yourfavoritekaisar.ottomaniac;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleFragment extends Fragment {
    String[] namaSultan, detailSultan;
    int[] gambarSultan;
    @BindView(R.id.recycleFragment)
    RecyclerView recycleFragment;
    Unbinder unbinder;


    public RecycleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);
        unbinder = ButterKnife.bind(this, view);

        namaSultan = getResources().getStringArray(R.array.nama_sultan);
        detailSultan = getResources().getStringArray(R.array.detail_sultan);
        gambarSultan = new int[]{R.drawable.suleiman, R.drawable.osman, R.drawable.murad,
                R.drawable.mehmedtheqonq, R.drawable.muradkedua, R.drawable.abdulhamid, R.drawable.gazi};

        AdapterSultan adapterSultan = new AdapterSultan(this, gambarSultan, namaSultan, detailSultan);

        recycleFragment.setHasFixedSize(true);
        recycleFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleFragment.setAdapter(adapterSultan);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
