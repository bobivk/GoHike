package com.example.mark.gohike;

/**
 * Created by Bobby on 06/02/2018.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//RecyclerView.Adapter<RecyclerViewAdapter.PathViewHolder>

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PathViewHolder> {
    Context c;
    private ArrayList<Path> paths;
    private LayoutInflater mInflater;


    public RecyclerViewAdapter(Context c, ArrayList<Path> paths) {
        this.c = c;
        mInflater = LayoutInflater.from(c);
        this.paths = paths;
    }

    class PathViewHolder extends RecyclerView.ViewHolder {

        public final TextView PathNameTV;
        public TextView PathDifficultyTV;
        public TextView PathLengthTV;
        public ImageView PathImageView;
        public TextView PathRatingTV;
        final RecyclerViewAdapter mAdapter;

        public PathViewHolder(View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            PathNameTV = itemView.findViewById(R.id.nameTxt);
            PathDifficultyTV = itemView.findViewById(R.id.difficultyTxt);
            PathLengthTV = itemView.findViewById(R.id.lengthTxt);
            PathRatingTV = itemView.findViewById(R.id.ratingTxt);
            PathImageView = itemView.findViewById(R.id.pathImg);
            this.mAdapter = adapter;
        }

    }

    //@Override
    public int getCount() {

        return paths.size();
    }

    //@Override
    public Object getItem(int i) {

        return paths.get(i);
    }

    public void startPathActivity(Context c, int position) {
        Intent intent = new Intent(c, PathActivity.class);
        intent.putExtra("Path sent", paths.get(position));
        c.startActivity(intent);
    }

    @Override
    public RecyclerViewAdapter.PathViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_view_model, parent, false);
        return new PathViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.PathViewHolder holder,  final int position) {

        Path currentPath = paths.get(position);

        holder.PathNameTV.setText(currentPath.getName());
        holder.PathDifficultyTV.setText(currentPath.getDifficulty());
        holder.PathLengthTV.setText(String.valueOf(currentPath.getLength()));
        holder.PathRatingTV.setText(String.valueOf(currentPath.getRating()));
        holder.PathImageView.setImageResource(currentPath.getImage());

        CardView mCardView = holder.itemView.findViewById(R.id.cardView);

        mCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startPathActivity(c, position);
            }

        });
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return paths.size();
    }



    /*public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            view= LayoutInflater.from(c).inflate(R.layout.list_view_model,viewGroup,false);
        }

        final Path p= (Path) this.getItem(i);

        ImageView img= (ImageView) view.findViewById(R.id.pathImg);
        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxt);
        TextView difficultyTxt= (TextView) view.findViewById(R.id.difficultyTxt);
        TextView lengthTxt = (TextView) view.findViewById(R.id.lengthTxt);

        nameTxt.setText(p.getName());
        difficultyTxt.setText(p.getDifficulty());
        img.setImageResource(p.getImage());
        lengthTxt.setText("lengthtxt");



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }*/

}
