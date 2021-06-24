package com.example.myapplication.message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.database.Message;
import com.example.myapplication.database.MessageRepository;
import com.example.myapplication.database.User;
import com.example.myapplication.database.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MessageViewModel extends ViewModel {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Inject
    MessageViewModel(
            UserRepository userRepository,
            MessageRepository messageRepository
    ){
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    private MutableLiveData<List<User>>  users;
    public LiveData<List<User>> getUsers() {
        if(users == null){
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    private MutableLiveData<List<Message>> messages;
    public LiveData<List<Message>> getMessages(){
        if(messages == null){
            messages = new MutableLiveData<>();
            loadMessages();
        }
        return messages;
    }


    private void loadUsers(){
        users.setValue(
                new ArrayList<>(userRepository.getUserList())
        );
    }

    private void loadMessages(){
        messages.setValue(
                new ArrayList<>(messageRepository.getMessageList())
        );
    }



}
