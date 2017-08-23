package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

/**
 * Created by alexander on 17/07/2017.
 */

public interface ChooseView extends MvpView {
    void updateList(IdeaModel idea);
    void updateList(List<IdeaModel> ideas);
    void clearList();

    void clearEditText();

    void highlightCard(int position);
    void removeHighlight();

    void showFab();
    void hideFab();
}
