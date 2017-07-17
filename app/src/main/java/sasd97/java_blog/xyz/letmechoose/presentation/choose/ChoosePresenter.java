package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import sasd97.java_blog.xyz.letmechoose.domain.ChooseInteractor;

/**
 * Created by alexander on 17/07/2017.
 */

@InjectViewState
public class ChoosePresenter extends MvpPresenter<ChooseView> {

    private ChooseInteractor interactor;

    public ChoosePresenter(@NonNull ChooseInteractor interactor) {
        this.interactor = interactor;
    }

    public List<String> addIdea(String idea) {
        List<String> ideas = interactor.addIdea(idea);
        if (TextUtils.isEmpty(idea)) return ideas;
        getViewState().updateList(idea);
        getViewState().clearEditText();
        return ideas;
    }

    public List<String> getIdeas() {
        return interactor.getIdeas();
    }

    public void deleteIdea(int position) {
        interactor.removeIdea(position);
    }

    public void selectIdea() {
        if (interactor.getIdeas().size() <= 0) return;
        String idea = interactor.getRandomIdea();
        getViewState().showDialog(idea);
    }
}
