package sasd97.java_blog.xyz.letmechoose.presentation.choose;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sasd97.java_blog.xyz.letmechoose.di.scope.MainScope;
import sasd97.java_blog.xyz.letmechoose.domain.ChooseInteractor;
import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;
import sasd97.java_blog.xyz.letmechoose.utils.RxSchedulers;

/**
 * Created by alexander on 17/07/2017.
 */

@MainScope
@InjectViewState
public class ChoosePresenter extends MvpPresenter<ChooseView> {

    private RxSchedulers schedulers;
    private ChooseInteractor interactor;

    @Inject
    public ChoosePresenter(
            @NonNull RxSchedulers schedulers,
            @NonNull ChooseInteractor interactor) {
        this.schedulers = schedulers;
        this.interactor = interactor;
    }

    @Override
    public void attachView(ChooseView view) {
        super.attachView(view);

        interactor.getIdeas()
                .compose(schedulers.getIoToMainTransformerSingle())
                .subscribe(ideas -> {
                    getViewState().updateList(ideas);
                    if (interactor.getSize() > 0) getViewState().showFab();
                });
    }

    public void addIdea(IdeaModel idea) {
        if (TextUtils.isEmpty(idea.getDescription())) return;
        interactor.addIdea(idea);
        getViewState().updateList(idea);
        getViewState().clearEditText();
        if (interactor.getSize() > 0) getViewState().showFab();
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
        interactor.saveIdeas()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe();
    }
}
