package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import android.support.annotation.NonNull;

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
        getViewState().updateList(idea);
        return ideas;
    }

    public List<String> getIdeas() {
        return interactor.getIdeas();
    }
}
