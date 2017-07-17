package sasd97.java_blog.xyz.letmechoose.presentation.selectedDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import sasd97.java_blog.xyz.letmechoose.LetMeChooseApp;
import sasd97.java_blog.xyz.letmechoose.R;

/**
 * Created by alexander on 17/07/2017.
 */

public class SelectDialogFragment extends MvpAppCompatDialogFragment implements SelectDialogView {

    private static final String SELECTED_IDEA_ARGS_KEY = "args.key.selected.idea";

    @InjectPresenter SelectDialogPresenter presenter;

    @ProvidePresenter
    public SelectDialogPresenter providePresenter() {
        return LetMeChooseApp
                .get(getContext())
                .getAppComponent()
                .plusMainComponent()
                .getSelectDialogPresenter();
    }

    public static SelectDialogFragment getInstance(@NonNull String selectedIdea) {
        SelectDialogFragment fragment = new SelectDialogFragment();
        Bundle args = new Bundle();
        args.putString(SELECTED_IDEA_ARGS_KEY, selectedIdea);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String selectedIdea = args.getString(SELECTED_IDEA_ARGS_KEY);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext())
                .setTitle(R.string.select_dialog_fragment_title)
                .setMessage(selectedIdea)
                .setIcon(R.drawable.ic_whatshot_black_24dp)
                .setPositiveButton(R.string.select_dialog_fragment_positive_text, null);

        return alertDialogBuilder.create();
    }
}
