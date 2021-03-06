package com.example.piu.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.piu.R;
import com.example.piu.model.OnBackPressed;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsFragment extends Fragment  implements OnBackPressed{
    private SettingsFragment mSettingsFragment = null;

    public SettingsFragment getSettingsFragment() {
        if (mSettingsFragment == null) mSettingsFragment = new SettingsFragment();
        return mSettingsFragment;
    }

    @BindView(R.id.tips_option)
    TextView mTips;

    @BindView(R.id.garbage_option)
    TextView mGarbageOption;

    private View mView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTips.setOnClickListener(view12 -> {
//                if (Navigation.findNavController(mView).getCurrentDestination().getId() == R.id.mSettingsFragment)
                Navigation.findNavController(mView).navigate(R.id.action_homeFragment_to_tipsFragment);
        });
       // if (Navigation.findNavController(mView).getCurrentDestination().getId() == R.id.settingsFragment){
        mGarbageOption.setOnClickListener(view1 ->{
        //if (Navigation.findNavController(mView).getCurrentDestination().getId() == R.id.settingsFragment) {
            Navigation.findNavController(mView).navigate(R.id.action_homeFragment_to_garbageManagementFragment);

        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() { getActivity().getSupportFragmentManager().popBackStack();}
}
