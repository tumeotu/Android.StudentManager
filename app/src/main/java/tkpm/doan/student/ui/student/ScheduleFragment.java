package tkpm.doan.student.ui.student;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.databinding.FragmentScheduleListBinding;
import tkpm.doan.student.ui.components.adapters.ScheduleAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

@AndroidEntryPoint
public class ScheduleFragment extends Fragment {

    private static final String TAG = "ScheduleFragment";

    private FragmentScheduleListBinding binding;

    private List<Schedule> schedules;
    private StudentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        RecyclerViews.setupGridView(recyclerView, 1);

        ScheduleAdapter adapter = new ScheduleAdapter(requireActivity(), schedules);
        recyclerView.setAdapter(adapter);
    }
}
