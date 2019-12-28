package me.geed.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import me.geed.lockscreen.R;
import me.geed.models.LessonCategory;

public class LayoutInitializer {

    private Context context;
    private Activity activity;

    public LayoutInitializer(Context applicationContext) {
        context = applicationContext;
        activity = getActivity(applicationContext);

    }

    public Activity getActivity() {
        return activity;
    }

    public Context getContext() {
        return context;
    }


    public Activity getActivity(Context context)
    {
        if (context == null)
        {
            return null;
        }
        else if (context instanceof ContextWrapper)
        {
            if (context instanceof Activity)
            {
                return (Activity) context;
            }
            else
            {
                return getActivity(((ContextWrapper) context).getBaseContext());
            }
        }

        return null;
    }

    public boolean isActivityNull(){
        return getActivity() != null;
    }




}
