package me.geed.dashboard;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import me.geed.lockscreen.LaunchActivity;
import me.geed.lockscreen.R;
import me.geed.models.LessonCategory;
import me.geed.util.API;

public class DashboardActivity extends AppCompatActivity {

    TextView headerTitle, headerDescription, dashboardCategory, rareItemsTitle;
    LinearLayout categoriesLayout;

    private ViewPager screenPager;

    Animation fromtopbottom, fromtopbottomtwo, fromtopbottomthree, frombottomtop;
    View animation_view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        fromtopbottom = AnimationUtils.loadAnimation(this, R.anim.dashboard_fromtopbottom);
        fromtopbottom.setStartOffset(400);
        fromtopbottomtwo = AnimationUtils.loadAnimation(this, R.anim.dashboard_fromtopbottom);
        fromtopbottomtwo.setStartOffset(600);
        fromtopbottomthree = AnimationUtils.loadAnimation(this, R.anim.dashboard_fromtopbottom);
        fromtopbottomthree.setStartOffset(800);

        frombottomtop = AnimationUtils.loadAnimation(this, R.anim.dashboard_frombottomtop);


        headerTitle = (TextView) findViewById(R.id.headerTitle);
        headerDescription = (TextView) findViewById(R.id.headerDescription);
        dashboardCategory = (TextView) findViewById(R.id.dashboardCategory);


        headerTitle.setTypeface(MMedium);
        headerDescription.setTypeface(MLight);
        dashboardCategory.setTypeface(MMedium);

        headerTitle.startAnimation(fromtopbottom);
        headerDescription.startAnimation(frombottomtop);
        dashboardCategory.startAnimation(frombottomtop);

        LayoutInflater layoutInflater;

        LinearLayout lessonCategoriesLayout;
        layoutInflater = LayoutInflater.from(this);
        lessonCategoriesLayout = (LinearLayout) findViewById(R.id.categories);

        int l = 1;
        for (LessonCategory lesson : API.getLessonCategories()) {
            final View v = layoutInflater.inflate(R.layout.layout_lesson_category, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.image_view);
            imageView.setImageResource(lesson.getScreenImg());
            Animation instance_anim = AnimationUtils.loadAnimation(this, R.anim.dashboard_frombottomtop);
            instance_anim.setStartOffset(l*300);
            imageView.startAnimation(instance_anim);
            lessonCategoriesLayout.addView(v);
            l++;

        }

        rareItemsTitle = (TextView) findViewById(R.id.rareItemsTitle);
        rareItemsTitle.startAnimation(frombottomtop);


        LinearLayout rareItemsLayout;
        rareItemsLayout = (LinearLayout) findViewById(R.id.rareItems);

        for (LessonCategory lesson : API.getLessonCategories()) {
            final View v = layoutInflater.inflate(R.layout.layout_rare_item, null);
            ImageView rareItemImageView = (ImageView) v.findViewById(R.id.rareItemImageView);
            TextView rareItemTitle = (TextView) v.findViewById(R.id.rareItemTitle);

            rareItemImageView.setImageResource(lesson.getScreenImg());
            rareItemTitle.setText(lesson.getTitle());

            rareItemsLayout.addView(v);

        }

        for (int i = 0; i < API.getLessonCategories().size(); i++) {
            animation_view = rareItemsLayout.getChildAt(i);
            Animation instance_anim = AnimationUtils.loadAnimation(this, R.anim.dashboard_fromtopbottom);

            instance_anim.setStartOffset(i*300);
            LinearLayout child_linear_layout = (LinearLayout) animation_view.findViewById(R.id.mainItemSection);
            child_linear_layout.startAnimation(instance_anim);
            animation_view = null;
        }

        ImageButton btn_settings = (ImageButton) findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * start lock screen service
                 */
                Intent mainActivity = new Intent(getApplicationContext(), LaunchActivity.class);
                startActivity(mainActivity);

            }
        });
    }
}
