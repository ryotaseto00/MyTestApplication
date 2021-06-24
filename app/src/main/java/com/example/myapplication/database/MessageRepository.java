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
public class MessageRepository {

    private final Context context;

    private final Message message0 = new Message(0L,0L);
    private final Message message1 = new Message(1L,4L);
    private final Message message2 = new Message(2L,0L);
    private final Message message3 = new Message(3L,1L);
    private final Message message4 = new Message(4L,2L);
    private final Message message5 = new Message(5L,0L);
    private final Message message6 = new Message(6L,1L);
    private final Message message7 = new Message(7L,0L);
    private final Message message8 = new Message(8L,2L);
    private final Message message9 = new Message(9L,3L);
    private final Message message10 = new Message(10L,0L);
    private final Message message11 = new Message(11L,0L);
    private final Message message12 = new Message(12L,3L);
    private final Message message13 = new Message(13L,0L);
    private final Message message14 = new Message(14L,4L);
    private final Message message15 = new Message(15L,0L);
    private final Message message16 = new Message(16L,3L);
    private final Message message17 = new Message(17L,2L);
    private final Message message18 = new Message(18L,1L);
    private final Message message19 = new Message(19L,1L);

    @Inject
    MessageRepository(@ApplicationContext Context context){
        this.context = context;
    }

    private final List<Message> messageList = new ArrayList<>(Arrays.asList(
            message0,
            message1,
            message2,
            message3,
            message4,
            message5,
            message6,
            message7,
            message8,
            message9,
            message10,
            message11,
            message12,
            message13,
            message14,
            message15,
            message16,
            message17,
            message18,
            message19
    ));

    public List<Message> getMessageList(){
        message0.setContent(context.getString(R.string.message_sample_0));
        message1.setContent(context.getString(R.string.message_sample_1));
        message2.setContent(context.getString(R.string.message_sample_2));
        message3.setContent(context.getString(R.string.message_sample_3));
        message4.setContent(context.getString(R.string.message_sample_4));
        message5.setContent(context.getString(R.string.message_sample_5));
        message6.setContent(context.getString(R.string.message_sample_6));
        message7.setContent(context.getString(R.string.message_sample_7));
        message8.setContent(context.getString(R.string.message_sample_8));
        message9.setContent(context.getString(R.string.message_sample_9));
        message10.setContent(context.getString(R.string.message_sample_10));
        message11.setContent(context.getString(R.string.message_sample_11));
        message12.setContent(context.getString(R.string.message_sample_12));
        message13.setContent(context.getString(R.string.message_sample_13));
        message14.setContent(context.getString(R.string.message_sample_14));
        message15.setContent(context.getString(R.string.message_sample_15));
        message16.setContent(context.getString(R.string.message_sample_16));
        message17.setContent(context.getString(R.string.message_sample_17));
        message18.setContent(context.getString(R.string.message_sample_18));
        message19.setContent(context.getString(R.string.message_sample_19));
        return this.messageList;
    }
}
