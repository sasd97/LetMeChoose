package sasd97.java_blog.xyz.letmechoose.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import sasd97.java_blog.xyz.letmechoose.navigation.Router;
import sasd97.java_blog.xyz.letmechoose.navigation.fragments.AddToBackStack;
import sasd97.java_blog.xyz.letmechoose.navigation.fragments.FragmentCommand;
import sasd97.java_blog.xyz.letmechoose.navigation.fragments.FragmentCommandDecorator;
import sasd97.java_blog.xyz.letmechoose.navigation.fragments.Replace;
import sasd97.java_blog.xyz.letmechoose.presentation.about.AboutFragment;
import sasd97.java_blog.xyz.letmechoose.presentation.choose.ChooseFragment;
import sasd97.java_blog.xyz.letmechoose.presentation.settings.SettingsFragment;

/**
 * Created by alexander on 17/07/2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Router<FragmentCommand> router;

    public void setRouter(Router<FragmentCommand> router) {
        this.router = router;
    }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        open();
    }

    public void open() {
        FragmentCommandDecorator replace = new Replace(ChooseFragment.getInstance());
        router.pushForward(replace);
    }

    public void navigateToChoose() {
        FragmentCommandDecorator command = new Replace(ChooseFragment.getInstance());
        command.setNext(new AddToBackStack());
        router.pushForward(command);
    }

    public void navigateToSettings() {
        FragmentCommandDecorator command = new Replace(SettingsFragment.getInstance());
        command.setNext(new AddToBackStack());
        router.pushForward(command);
    }

    public void navigateToAbout() {
        FragmentCommandDecorator command = new Replace(AboutFragment.getInstance());
        command.setNext(new AddToBackStack());
        router.pushForward(command);
    }
}
