package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import com.arellomobile.mvp.MvpView;

import java.util.List;

/**
 * Created by alexander on 17/07/2017.
 */

public interface ChooseView extends MvpView {
    void updateList(String idea);
    void updateList(List<String> ideas);
    void clearList();

    void clearEditText();

    void highlightCard(int position);
    void removeHighlight();

    void showFab();
    void hideFab();
}
