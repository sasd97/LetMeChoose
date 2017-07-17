package sasd97.java_blog.xyz.letmechoose.utils;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by alexander on 17/07/2017.
 */

public abstract class SwipeToDismissListener extends ItemTouchHelper.SimpleCallback {

    public SwipeToDismissListener() {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }
}
