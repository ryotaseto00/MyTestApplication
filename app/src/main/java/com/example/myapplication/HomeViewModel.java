package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.database.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<User>>  users;
    public LiveData<List<User>> getUsers() {
        if(users == null){
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers(){
        users.setValue(new ArrayList<>(Arrays.asList(
                new User(0L, "はなこ", 28),
                new User(1L, "みちこ", 20),
                new User(2L, "ゆうか",19),
                new User(3L,"れな",26),
                new User(4L,"なな",28)
        )
        ));
    }
}
