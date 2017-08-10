package shoaibhassan.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by SHOAIB HASSAN on 5/18/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {


ArrayList<Detail>  arrayList= new ArrayList<>();

    RecyclerAdapter(ArrayList<Detail> arrayList    )

    {

        this.arrayList =arrayList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_Lauout,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

          return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Detail detail = arrayList.get(position);
        holder.Title.setText(detail.getTitle());
        holder.Notice.setText(detail.getNotice()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {

        TextView Title,Notice,Detail;

        RecyclerViewHolder(View view) {
            super(view);
            Title =(TextView)view.findViewById(R.id.title);
            Notice =(TextView)view.findViewById(R.id.notice);
            Detail =(TextView)view.findViewById(R.id.detal);
        }
    }
}
