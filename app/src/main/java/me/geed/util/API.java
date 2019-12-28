package me.geed.util;

import java.util.ArrayList;
import java.util.List;

import me.geed.lockscreen.R;
import me.geed.models.LessonCategory;

public class API {
    public  static List<LessonCategory> getLessonCategories() {
        List<LessonCategory> categoriesList = new ArrayList<LessonCategory>();
        categoriesList.add(new LessonCategory("Fresh Food","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit", R.drawable.cateone));
        categoriesList.add(new LessonCategory("Fast Delivery","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",R.drawable.catetwo));
        categoriesList.add(new LessonCategory("Easy Payment","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",R.drawable.catethree));
        return categoriesList;
    }
}
