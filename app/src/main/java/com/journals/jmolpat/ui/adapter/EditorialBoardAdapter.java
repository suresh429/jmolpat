package com.journals.jmolpat.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.journals.jmolpat.databinding.EditorialBoardItemBinding;
import com.journals.jmolpat.model.EditorialBoardResponse;

import java.util.List;

public class EditorialBoardAdapter extends RecyclerView.Adapter<EditorialBoardAdapter.ViewHolder> {

    List<EditorialBoardResponse.EditorialboardarrBean> modelList;
    Context context;

    public EditorialBoardAdapter(List<EditorialBoardResponse.EditorialboardarrBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public EditorialBoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(EditorialBoardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull EditorialBoardAdapter.ViewHolder holder, int position) {


        holder.rowItemBinding.txtName.setText(modelList.get(position).getEname());

        if (modelList.get(position).getEditorDescription() != null && !modelList.get(position).getEditorDescription().equalsIgnoreCase("null") && !modelList.get(position).getEditorDescription().isEmpty()) {
            holder.rowItemBinding.txtView1.setText(modelList.get(position).getEditorDescription());
        } else {
            holder.rowItemBinding.txtView1.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        EditorialBoardItemBinding rowItemBinding;

        public ViewHolder(@NonNull EditorialBoardItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
