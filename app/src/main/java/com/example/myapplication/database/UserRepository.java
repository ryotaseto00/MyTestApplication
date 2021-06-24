package com.example.myapplication.database;

import android.content.Context;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class UserRepository {

    private final Context context;

    @Inject
    UserRepository(@ApplicationContext Context context){
        this.context = context;
    }


    private final User hanako = new User(0L, "はなこ", 28,"東京");
    private final User mitiko = new User(1L, "みちこ", 20,"大阪");
    private final User yuuka = new User(2L, "ゆうか", 19, "兵庫");
    private final User rena = new User(3L, "れな", 26, "神奈川");
    private final User hana = new User(4L,"はな",28,"宮城");

    private final List<User> userList = new ArrayList<>(Arrays.asList(
            hanako,
            mitiko,
            yuuka,
            rena,
            hana
    ));

    public List<User> getUserList() {
        hana.setSelfIntroduction(context.getString(R.string.self_introduction_sample_hana));
        hanako.setSelfIntroduction(context.getString(R.string.self_introduction_sample));
        mitiko.setSelfIntroduction(context.getString(R.string.self_introduction_sample_1));
        return this.userList;
    }
}
