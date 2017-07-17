package sasd97.java_blog.xyz.letmechoose.navigation.fragments;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 17/07/2017.
 */

public class ShowDialog extends FragmentCommandDecorator {

    private DialogFragment destinationFragment;

    public ShowDialog(DialogFragment destinationFragment) {
        super();
        this.destinationFragment = destinationFragment;
    }

    @Override
    protected FragmentTransaction onApply(FragmentTransaction transaction) {
        destinationFragment.show(transaction, null);
        return transaction;
    }
}
