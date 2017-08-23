package sasd97.java_blog.xyz.letmechoose.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import sasd97.java_blog.xyz.letmechoose.R;
import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

/**
 * Created by alexander on 17/07/2017.
 */

public class IdeasRecyclerAdapter extends RecyclerView.Adapter<IdeasRecyclerAdapter.IdeasViewHolder> {

    private static final int NO_HIGHLIGHT = -1;

    private int highlightPosition = NO_HIGHLIGHT;
    private List<IdeaModel> ideas = new ArrayList<>();

    static class IdeasViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_idea_card) CardView card;
        @BindView(R.id.row_idea_title) TextView title;
        @BindView(R.id.row_idea_description) TextView description;

        @BindColor(R.color.colorWhite) int whiteColor;
        @BindColor(R.color.colorGreyMd600) int colorGrey600;
        @BindColor(R.color.colorGreyMd900) int colorGrey900;

        @BindColor(R.color.colorPrimary) int colorPrimary;


        IdeasViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setIdeaTitle(int number) {
            Context context = title.getContext();
            title.setText(context.getString(R.string.choose_fragment_row_title, number));
        }

        void setDescription(@NonNull String idea) {
            description.setText(idea);
        }

        private void highlightCard() {
            card.setCardBackgroundColor(colorPrimary);
            title.setTextColor(whiteColor);
            description.setTextColor(whiteColor);
        }

        private void paintCard() {
            card.setCardBackgroundColor(whiteColor);
            title.setTextColor(colorGrey600);
            description.setTextColor(colorGrey900);
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
        IdeaModel idea = ideas.get(position);
        holder.setIdeaTitle(position + 1);
        holder.setDescription(idea.getDescription());
        if (position == highlightPosition) holder.highlightCard();
        else holder.paintCard();
    }

    public void add(IdeaModel description) {
        ideas.add(description);
        notifyItemInserted(getItemCount());
    }

    public void addAll(Collection<IdeaModel> collection) {
        int size = getItemCount();
        ideas.addAll(collection);
        notifyItemRangeInserted(size, getItemCount());
    }

    public void clear() {
        notifyItemRangeRemoved(0, getItemCount());
        ideas.clear();
    }

    public void highlightCard(int position) {
        int lastHighlightCard = highlightPosition;
        highlightPosition = position;
        if (lastHighlightCard != NO_HIGHLIGHT) notifyItemChanged(lastHighlightCard);
        notifyItemChanged(highlightPosition);
    }

    public void removeHighlight() {
        this.highlightPosition = NO_HIGHLIGHT;
    }

    public void remove(int position) {
        removeHighlight();
        ideas.remove(position);
        notifyItemRangeChanged(0, position);
        notifyItemRangeChanged(position + 1, getItemCount());
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return ideas.size();
    }
}
