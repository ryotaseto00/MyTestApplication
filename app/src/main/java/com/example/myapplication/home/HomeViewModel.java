package com.example.myapplication.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.database.User;
import com.example.myapplication.database.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final UserRepository repository;

    @Inject
    HomeViewModel(
            UserRepository repository
    ){
        this.repository = repository;
    }

    private MutableLiveData<List<User>>  users;
    public LiveData<List<User>> getUsers() {
        if(users == null){
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers(){
        users.setValue(
                new ArrayList<>(repository.getUserList())
        );
    }
}
