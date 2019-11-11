package ru.startandroid.p0012noteseditorsimple;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    ArrayList<Note> notes;

    public NoteAdapter (ArrayList<Note> notes) {
        this.notes = notes;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView tvNote;
        public NoteViewHolder (View view){
            super(view);
            tvNote = (TextView) view.findViewById(R.id.tvNote);
        }
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position){
    holder.tvNote.setText(notes.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

}
