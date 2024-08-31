package com.example.theworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CellAdapter extends RecyclerView.Adapter<CellAdapter.CellViewHolder> {
    private List<Cell> cells;

    public CellAdapter(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public CellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell, parent, false);
        return new CellViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CellViewHolder holder, int position) {
        Cell cell = cells.get(position);
        holder.bind(cell);
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    class CellViewHolder extends RecyclerView.ViewHolder {
        private TextView cellIcon;
        private TextView cellTitle;
        private TextView cellSubtitle;

        public CellViewHolder(View itemView) {
            super(itemView);
            cellIcon = itemView.findViewById(R.id.cell_icon);
            cellTitle = itemView.findViewById(R.id.cell_title);
            cellSubtitle = itemView.findViewById(R.id.cell_subtitle);
        }

        public void bind(Cell cell) {
            cellTitle.setText(cell.getTitle());
            cellSubtitle.setText(cell.getSubtitle());
            cellIcon.setText(cell.getEmoji()); // Устанавливаем эмодзи в TextView
        }

    }
}
