package me.geed.lockscreen;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.util.Pair;

import com.ncorti.slidetoact.SlideToActView;

import java.util.Random;

import io.saeid.fabloading.LoadingView;
import me.geed.models.Question;
import me.geed.util.QuestionInitializer;
import me.geed.util.TimeUtil;


/**
 * if the screen is locked, this Activity will show.
 *
 * @author Andy
 */
public class LockScreenActivity extends Activity {
    /**
     * click this ImageView to unlock screen
     */
    private SlideToActView iv_key;

    /**
     * this TextView is used to show current time as an example, also you can show any thing on the {@link LockScreenActivity} you want to
     */
    private TextView tv_time;

    /**
     * check whether the screen is locked or not
     */
    public static boolean isLocked = false;


    // Outside container


    private  RelativeLayout mainContainer;

    private LinearLayout categoryInfoContainer;

    private ImageView categoryImageView;

    private TextView questionTitleText;

    private TextView questionDescriptionText;

    //Inside Container

    private Animation from_unvisible;

    private Animation from_visible;

    private  RelativeLayout insideContainer;

    private LinearLayout categoryInfoContainerInside;

    private ImageView categoryImageViewInside;

    private TextView questionTitleTextInside;

    private TextView questionDescriptionTextInside;

    private SlideToActView insideExitSlideAction_key;

    private SlideToActView insideContinueSlideAction_key;


    // Question Buttons

    private ImageView left_key;

    private ImageView right_key;


    // Default Background Colors

    private String [] colours = {
            "#3498db",
            "#e74c3c",
            "#1abc9c",
            "#34495e",
            "#53bbb4",
    };




    /**
     *
     * Animation Variables
     */
    private LoadingView mLoadingView;
    private LoadingView mLoadViewLong;
    private LoadingView mLoadViewNoRepeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        from_unvisible = AnimationUtils.loadAnimation(this,R.anim.lockscreen_fromunvisible);
        from_visible = AnimationUtils.loadAnimation(this,R.anim.lockscreen_fromvisible);


        QuestionInitializer.initializeQuestions();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        setContentView(R.layout.activity_lock_screen);

        boolean isLollipop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
        int marvel_1 = isLollipop ? R.drawable.categoryfour : R.drawable.categoryfour;
        int marvel_2 = isLollipop ? R.drawable.catefive : R.drawable.catefive;
        int marvel_3 = isLollipop ? R.drawable.categorysix : R.drawable.categorysix;

        mLoadingView = (LoadingView) findViewById(R.id.loading_view);
        mLoadingView.addAnimation(Color.parseColor("#FFFFFF"), marvel_1, LoadingView.FROM_LEFT);
        mLoadingView.addAnimation(Color.parseColor("#FFFFFF"), marvel_2, LoadingView.FROM_LEFT);
        mLoadingView.addAnimation(Color.parseColor("#FFFFFF"), marvel_3, LoadingView.FROM_LEFT);

        //also you can add listener for getting callback (optional)
        mLoadingView.addListener(new LoadingView.LoadingListener() {
            @Override public void onAnimationStart(int currentItemPosition) {
            }

            @Override public void onAnimationRepeat(int nextItemPosition) {
            }

            @Override public void onAnimationEnd(int nextItemPosition) {
            }
        });


        isLocked = true;

        iv_key = (SlideToActView) findViewById(R.id.iv_key);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_time.setText(TimeUtil.getTime());




        iv_key.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                virbate();
                isLocked = false;
                Toast.makeText(LockScreenActivity.this, "Screen is unlocked", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        try {
            startService(new Intent(this, LockScreenService.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainContainer = (RelativeLayout) findViewById(R.id.mainContainer);
        categoryInfoContainer = (LinearLayout) findViewById(R.id.categoryInfoContainer);
        categoryImageView = (ImageView) findViewById(R.id.categoryImageView);
        questionTitleText = (TextView) findViewById(R.id.questionTitleText);
        questionDescriptionText = (TextView) findViewById(R.id.questionDescriptionText);


        insideContainer = findViewById(R.id.insideContainer);
        insideContainer.setLayoutParams(new RelativeLayout.LayoutParams(0,0));

        categoryInfoContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insideContainer.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                insideContainer.startAnimation(from_unvisible);



                if(false){
                    Intent sharedIntent = new Intent(LockScreenActivity.this, SharedActivity.class);


                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        Pair[] pairs = new Pair[4];
                        pairs[0] = Pair.create((View)categoryImageView, "categoryImageQuestionTransition");
                        pairs[1]= Pair.create((View)questionTitleText, "questionTitleTransition");
                        pairs[2] = Pair.create((View)questionDescriptionText, "questionDescriptionTransition");
                        pairs[3] = Pair.create((View)mainContainer, "containerTransition");


                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LockScreenActivity.this);
                        startActivity(sharedIntent, options.toBundle());
                    }
                    else{
                        startActivity(sharedIntent);
                    }

                }

            }
        });

        left_key = (ImageView) findViewById(R.id.left_key);
        right_key = (ImageView) findViewById(R.id.right_key);

        left_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousQuestion();

            }
        });

        right_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
            }
        });

        //Set Current question to view
        setQuestionView(QuestionInitializer.getCurrentQuestion());


        insideContinueSlideAction_key = (SlideToActView) findViewById(R.id.insideContinueSlideAction_key);
        insideContinueSlideAction_key.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {

            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                nextQuestion();
                insideContinueSlideAction_key.resetSlider();
                insideContainer = findViewById(R.id.insideContainer);
                insideContainer.startAnimation(from_visible);
            }
        });

        insideExitSlideAction_key = (SlideToActView) findViewById(R.id.insideExitSlideAction_key);
        insideExitSlideAction_key.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {

            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                insideExitSlideAction_key.resetSlider();
                insideContainer = findViewById(R.id.insideContainer);
                insideContainer.startAnimation(from_visible);
            }
        });


        from_visible.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                insideContainer.setLayoutParams(new RelativeLayout.LayoutParams(0,0));
            }
        });

        }


    private void nextQuestion() {
        // TODO: get next Question
        Question next_question = QuestionInitializer.getNextQuestion();
        setQuestionView(next_question);

    }

    private void previousQuestion() {
        //TODO : get previous Question
        Question previous_question = QuestionInitializer.getPreviousQuestion();
        setQuestionView(previous_question);
    }

    private void setQuestionView(Question question) {
        mainContainer = (RelativeLayout) findViewById(R.id.mainContainer);
        categoryInfoContainer = (LinearLayout) findViewById(R.id.categoryInfoContainer);
        categoryImageView = (ImageView) findViewById(R.id.categoryImageView);
        questionTitleText = (TextView) findViewById(R.id.questionTitleText);
        questionDescriptionText = (TextView) findViewById(R.id.questionDescriptionText);

        Random randomColor = new Random();
        int randomColorNumber = randomColor.nextInt(colours.length);
        int backgroudColor = Color.parseColor(colours[randomColorNumber]);

        mainContainer.setBackgroundColor(backgroudColor);

        questionTitleText.setText(question.getTitle());
        questionDescriptionText.setText(question.getDescription());

        insideContainer = findViewById(R.id.insideContainer);
        categoryImageViewInside = findViewById(R.id.categoryImageViewInside);
        questionTitleTextInside = findViewById(R.id.questionTitleTextInside);
        questionDescriptionTextInside = findViewById(R.id.questionDescriptionTextInside);

        questionTitleTextInside.setText(question.getTitle());
        questionDescriptionTextInside.setText(question.getDescription());

    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void pause(View v) {
        mLoadingView.pauseAnimation();
        mLoadViewLong.pauseAnimation();
        mLoadViewNoRepeat.pauseAnimation();
    }

    public void start(View v) {
        mLoadingView.startAnimation();
        mLoadViewLong.startAnimation();
        mLoadViewNoRepeat.startAnimation();
    }

    public void resume(View v) {
        mLoadingView.resumeAnimation();
        mLoadViewLong.resumeAnimation();
        mLoadViewNoRepeat.resumeAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_HOME)) {
            // Key code constant: Home key. This key is handled by the framework and is never delivered to applications.
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void onBackPressed() {
        //return;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * virbate means that the screen is unlocked success
     */
    private void virbate() {
        Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
}
