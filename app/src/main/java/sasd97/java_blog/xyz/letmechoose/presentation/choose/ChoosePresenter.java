package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import sasd97.java_blog.xyz.letmechoose.di.scope.MainScope;
import sasd97.java_blog.xyz.letmechoose.domain.ChooseInteractor;

/**
 * Created by alexander on 17/07/2017.
 */

@MainScope
@InjectViewState
public class ChoosePresenter extends MvpPresenter<ChooseView> {

    private ChooseInteractor interactor;

    @Inject
    public ChoosePresenter(@NonNull ChooseInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(ChooseView view) {
        super.attachView(view);
        getViewState().updateList(interactor.getIdeas());
        if (interactor.getSize() > 0) getViewState().showFab();
    }

    public List<String> addIdea(String idea) {
        if (TextUtils.isEmpty(idea)) return interactor.getIdeas();
        List<String> ideas = interactor.addIdea(idea);
        getViewState().updateList(idea);
        getViewState().clearEditText();
        if (interactor.getSize() > 0) getViewState().showFab();
        return ideas;
    }

    public void deleteIdea(int position) {
        interactor.removeIdea(position);
        if (interactor.getSize() == 0) getViewState().hideFab();
    }

    public void clearIdeas() {
        interactor.clearIdeas();
        getViewState().removeHighlight();
        getViewState().clearList();
        getViewState().hideFab();
    }

    public void selectIdea() {
        if (interactor.getSize() <= 0) return;
        getViewState().highlightCard(interactor.getRandomPosition());
    }

    @Override
    public void detachView(ChooseView view) {
        super.detachView(view);
        interactor.saveIdeas();
    }
}
