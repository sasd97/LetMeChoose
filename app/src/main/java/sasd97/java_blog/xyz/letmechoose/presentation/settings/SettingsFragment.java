package sasd97.java_blog.xyz.letmechoose.presentation.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import sasd97.java_blog.xyz.letmechoose.R;

/**
 * Created by alexander on 17/07/2017.
 */

public class SettingsFragment extends MvpAppCompatFragment implements SettingsView {

    public static SettingsFragment getInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        return v;
    }
}
