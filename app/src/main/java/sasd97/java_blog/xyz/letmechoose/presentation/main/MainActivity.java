package sasd97.java_blog.xyz.letmechoose.presentation.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import sasd97.java_blog.xyz.letmechoose.LetMeChooseApp;
import sasd97.java_blog.xyz.letmechoose.R;
import sasd97.java_blog.xyz.letmechoose.navigation.AppFragmentRouter;
import sasd97.java_blog.xyz.letmechoose.navigation.Router;
import sasd97.java_blog.xyz.letmechoose.navigation.fragments.FragmentCommand;

public class MainActivity extends MvpAppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener,
        MainView {

    @BindView(R.id.activity_choose_bottom_navigation) BottomNavigationView navigation;

    @InjectPresenter MainPresenter presenter;

    @ProvidePresenter
    public MainPresenter providePresenter() {
        return LetMeChooseApp
                .get(this)
                .getAppComponent()
                .plusMainComponent()
                .getMainPresenter();
    }

    private Router<FragmentCommand> router = new AppFragmentRouter(R.id.activity_main_container, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter.setRouter(router);

        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_navigation_room:
                presenter.navigateToChoose();
                return true;
            case R.id.bottom_navigation_settings:
                presenter.navigateToSettings();
                return true;
            case R.id.bottom_navigation_about:
                presenter.navigateToAbout();
                return true;
        }

        return false;
    }
}
