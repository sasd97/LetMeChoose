package sasd97.java_blog.xyz.letmechoose.navigation;

import sasd97.java_blog.xyz.letmechoose.navigation.activities.ActivityCommand;
import sasd97.java_blog.xyz.letmechoose.navigation.activities.MoveForward;

/**
 * Created by alexander on 09/07/2017.
 */

public class AppActivityRouter implements Router<ActivityCommand> {

    @Override
    public void pushForward(ActivityCommand frame) {
        if (!(frame instanceof MoveForward)) return;
        frame.apply();
    }
}
