package com.u1tramarinet.autoscrolltwitter.top;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.u1tramarinet.autoscrolltwitter.R;
import com.u1tramarinet.autoscrolltwitter.databinding.FragmentTopBinding;

public class TopFragment extends Fragment {

    private FragmentTopBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentTopBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonTimeline.setOnClickListener(view1 -> findNavController().navigate(R.id.action_TopFragment_to_TimelineFragment));
        binding.buttonSearch.setOnClickListener(v -> findNavController().navigate(R.id.action_TopFragment_to_SearchFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private NavController findNavController() {
        return NavHostFragment.findNavController(TopFragment.this);
    }

}