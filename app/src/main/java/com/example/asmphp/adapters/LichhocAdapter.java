package com.example.asmphp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asmphp.R;
import com.example.asmphp.dto.LichhocResponseDTO;

import java.util.List;

public class LichhocAdapter extends RecyclerView.Adapter<LichhocAdapter.ViewHolder> {

    private List<LichhocResponseDTO> list;

    public LichhocAdapter(List<LichhocResponseDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LichhocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lichhoc_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichhocAdapter.ViewHolder holder, int position) {
        holder.namemon.setText(list.get(position).getName());
        holder.ngayhoc.setText(list.get(position).getNgay() + "");
        holder.giohoc.setText(list.get(position).getGio());
        holder.lophoc.setText(list.get(position).getLop());
        holder.phonghoc.setText(list.get(position).getPhong());
        holder.cahoc.setText(list.get(position).getCa());
        Glide
                .with(holder.itemView.getContext())
                .load(list.get(position).getHinh())
                .centerCrop()
                .into(holder.hinhgiangvien);
        holder.namegiangvien.setText(list.get(position).getGiangvien());
        holder.mamonhoc.setText(list.get(position).getMamon());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView namemon;
        private TextView ngayhoc;
        private TextView giohoc;
        private TextView lophoc;
        private TextView phonghoc;
        private TextView cahoc;
        private ImageView hinhgiangvien;

        private TextView namegiangvien, mamonhoc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namemon = itemView.findViewById(R.id.namemon);
            ngayhoc = itemView.findViewById(R.id.ngayhoc);
            giohoc = itemView.findViewById(R.id.giohoc);
            lophoc = itemView.findViewById(R.id.lophoc);
            phonghoc = itemView.findViewById(R.id.phonghoc);
            cahoc = itemView.findViewById(R.id.cahoc);
            hinhgiangvien = itemView.findViewById(R.id.hinhgiangvien);
            namegiangvien = itemView.findViewById(R.id.namegiangvien);
            mamonhoc = itemView.findViewById(R.id.mamonhoc);
        }
    }
}
