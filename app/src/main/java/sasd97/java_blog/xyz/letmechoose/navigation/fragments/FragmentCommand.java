package sasd97.java_blog.xyz.letmechoose.navigation.fragments;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import sasd97.java_blog.xyz.letmechoose.navigation.Command;

/**
 * Created by alexander on 09/07/2017.
 */

public interface FragmentCommand extends Command {
    void setContainer(@IdRes int containerId);
    FragmentTransaction apply(FragmentTransaction transaction);
}
