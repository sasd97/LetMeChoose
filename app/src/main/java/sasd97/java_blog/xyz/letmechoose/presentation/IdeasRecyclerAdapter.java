package sasd97.java_blog.xyz.letmechoose.presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sasd97.java_blog.xyz.letmechoose.R;

/**
 * Created by alexander on 17/07/2017.
 */

public class IdeasRecyclerAdapter extends RecyclerView.Adapter<IdeasRecyclerAdapter.IdeasViewHolder> {

    private List<String> ideas = new ArrayList<>();

    public static class IdeasViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_idea_title) TextView title;

        public IdeasViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public IdeasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.row_idea, parent, false);
        return new IdeasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(IdeasViewHolder holder, int position) {
        String description = ideas.get(position);
        holder.title.setText(description);
    }

    public void add(String description) {
        ideas.add(description);
        notifyItemInserted(getItemCount());
    }

    @Override
    public int getItemCount() {
        return ideas.size();
    }
}
