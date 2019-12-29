package me.geed.util;

import java.util.ArrayList;
import java.util.List;

import me.geed.lockscreen.R;
import me.geed.models.LessonCategory;

public class API {
    public  static List<LessonCategory> getLessonCategories() {
        List<LessonCategory> categoriesList = new ArrayList<LessonCategory>();
        categoriesList.add(new LessonCategory("Fizik","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit", R.drawable.cateone));
        categoriesList.add(new LessonCategory("Lineer Cebir","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",R.drawable.catetwo));
        categoriesList.add(new LessonCategory("Kalkülüs 1","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",R.drawable.catethree));

        return categoriesList;
    }
}
