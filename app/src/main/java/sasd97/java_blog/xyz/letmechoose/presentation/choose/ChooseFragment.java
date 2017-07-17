package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sasd97.java_blog.xyz.letmechoose.LetMeChooseApp;
import sasd97.java_blog.xyz.letmechoose.R;
import sasd97.java_blog.xyz.letmechoose.presentation.IdeasRecyclerAdapter;
import sasd97.java_blog.xyz.letmechoose.utils.SwipeToDismissListener;

/**
 * Created by alexander on 17/07/2017.
 */

public class ChooseFragment extends MvpAppCompatFragment
        implements ChooseView {

    private IdeasRecyclerAdapter adapter = new IdeasRecyclerAdapter();
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    private ItemTouchHelper.Callback swipeToDismiss = new SwipeToDismissListener() {
        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            adapter.remove(position);
            presenter.deleteIdea(position);
        }
    };

    @InjectPresenter ChoosePresenter presenter;

    @BindView(R.id.choose_fragment_idea_message) EditText ideaDescription;
    @BindView(R.id.fragment_choose_recycler) RecyclerView ideasRecycler;
    @BindView(R.id.choose_fragment_select_idea) FloatingActionButton selectIdeaButton;

    @ProvidePresenter
    public ChoosePresenter providePresenter() {
        return LetMeChooseApp.get(getContext())
                .getAppComponent()
                .plusMainComponent()
                .getChoosePresenter();
    }

    public static ChooseFragment getInstance() {
        return new ChooseFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeToDismiss);

        ideasRecycler.setHasFixedSize(true);
        ideasRecycler.setLayoutManager(linearLayoutManager);
        ideasRecycler.setAdapter(adapter);
        touchHelper.attachToRecyclerView(ideasRecycler);
    }

    @Override
    public void updateList(String idea) {
        adapter.add(idea);
    }

    @Override
    public void updateList(List<String> ideas) {
        adapter.addAll(ideas);
    }

    @Override
    public void clearEditText() {
        ideaDescription.setText(null);
    }

    @Override
    public void highlightCard(int position) {
        Log.d("POSITION", String.valueOf(position));
        adapter.highlightCard(position);
        linearLayoutManager.scrollToPositionWithOffset(position, 20);
    }

    @Override
    public void showFab() {
        selectIdeaButton.show();
    }

    @Override
    public void hideFab() {
        selectIdeaButton.hide();
    }

    @OnClick(R.id.choose_fragment_add)
    public void onAddIdeaClick(View v) {
        String description = ideaDescription.getText().toString();
        presenter.addIdea(description);
    }

    @OnClick(R.id.choose_fragment_select_idea)
    public void onSelectIdeaClick(View v) {
        presenter.selectIdea();
    }
}
