package com.example.mark.gohike.dummy;

/**
 * Created by Bobby on 06/02/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.R.string;
import android.R.drawable;
import android.R.layout;
import android.content.Intent;
import com.example.mark.gohike.PathActivity;
import com.example.mark.gohike.R;
import com.example.mark.gohike.MainActivity;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PathViewHolder>{
    Context c;
    private ArrayList<Path> paths;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context c, ArrayList<Path> paths) {
        this.c = c;
        mInflater = LayoutInflater.from(c);
        this.paths = paths;
    }

    class PathViewHolder extends RecyclerView.ViewHolder {
        public PathViewHolder(View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            PathNameTV = (TextView) itemView.findViewById(R.id.nameTxt);
            this.mAdapter = adapter;
        }
        public final TextView PathNameTV;
        final RecyclerViewAdapter mAdapter;
    }

   // @Override
    public int getCount() {
        return paths.size();
    }

  //  @Override
    public Object getItem(int i) {
        return paths.get(i);
    }

    @Override
    public RecyclerViewAdapter.PathViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_view_model, parent, false);
        return new PathViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.PathViewHolder holder, int position) {
        Path mCurrent = paths.get(position);
        holder.PathNameTV.setText(mCurrent.getName());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return paths.size();
    }

    public void startPathActivity(View view) {

    }

  //  @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.list_view_model,viewGroup,false);
        }

        final Path p= (Path) this.getItem(i);

        ImageView img= (ImageView) view.findViewById(R.id.pathImg);
        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxt);
        TextView skillTxt= (TextView) view.findViewById(R.id.skillTxt);


        nameTxt.setText(p.getName());
        skillTxt.setText(p.getDifficulty());
        img.setImageResource(p.getImage());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
