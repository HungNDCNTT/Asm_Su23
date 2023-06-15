package com.example.basicandroid.employee;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicandroid.R;
import com.example.basicandroid.models.EmployeeEntity;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private final List<EmployeeEntity> mEmployee;

    public EmployeeAdapter(List<EmployeeEntity> employee) {
        mEmployee = employee;
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.member_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder viewHolder, int position) {
        EmployeeEntity employee = mEmployee.get(position);

        TextView empCode = viewHolder.employeeCode;
        empCode.setText(employee.getEmployeeCode());
        TextView empFullName = viewHolder.employeeFullName;
        empFullName.setText(employee.getEmployeeFullName());
        TextView empDepartment = viewHolder.employeeDepartment;
        empDepartment.setText(employee.getEmployeeDepartment());

        ImageView btEdit = viewHolder.btnEdit;
        ImageView btDelete = viewHolder.btnDelete;
    }

    @Override
    public int getItemCount() {
        return mEmployee.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView employeeCode;
        public TextView employeeFullName;
        public TextView employeeDepartment;
        public ImageView btnEdit;
        public ImageView btnDelete;

        public ViewHolder(View itemView) {

            super(itemView);
            employeeCode = (TextView) itemView.findViewById(R.id.value1);
            employeeFullName = (TextView) itemView.findViewById(R.id.value2);
            employeeDepartment = (TextView) itemView.findViewById(R.id.value3);
            btnEdit = (ImageView) itemView.findViewById(R.id.icEdit);
            btnDelete = (ImageView) itemView.findViewById(R.id.icDelete);
        }
    }
}
