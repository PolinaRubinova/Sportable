package io.polytech.sportable.activities.statistics.total;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import io.polytech.sportable.R;
import io.polytech.sportable.models.practice.PracticeType;
import io.polytech.sportable.persistence.PracticeResult;
import io.polytech.sportable.persistence.PracticeResultViewModel;

public class TotalPageFragment extends Fragment {

    private PracticeResultViewModel mPracticeResultViewModel;

    public static TotalPageFragment newInstance() {
        return new TotalPageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.total_fragment, container, false);

        TotalAdapter adapter = new TotalAdapter(view);

        mPracticeResultViewModel = new ViewModelProvider(this).get(PracticeResultViewModel.class);
       /* mPracticeResultViewModel.insert(new PracticeResult(3042021, 100.f, 3.f, 100000, PracticeType.Run));
        mPracticeResultViewModel.insert(new PracticeResult(2042021, 100.f, 3.f, 100000, PracticeType.Run));
        mPracticeResultViewModel.insert(new PracticeResult(5042021, 10.f, 52.f, 300000, PracticeType.Walk));*/
        mPracticeResultViewModel.allData.observe(getViewLifecycleOwner(), adapter::setData);
        return view;
    }
}