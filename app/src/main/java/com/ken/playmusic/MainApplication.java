package com.ken.playmusic;

import android.app.Application;

import com.ken.playmusic.data.entities.Student;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

/**
 * Created by ken on 01/11/2017.
 */

public class MainApplication extends Application {
    public static List<Student> studentList;

    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);
        studentList = new ArrayList<>(100);
        for (int i = 0; i <  100 ; i++) {
             studentList.add(new Student("name_" + i,
                                        "school_" + i,
                                        i
                                ));
        }
    }
}
