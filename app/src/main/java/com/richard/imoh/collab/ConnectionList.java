package com.richard.imoh.collab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.richard.imoh.collab.Adapters.ConnectionsAdapter;
import com.richard.imoh.collab.Pojo.User;

import java.util.ArrayList;
import java.util.List;

public class ConnectionList extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;
    FirebaseAuth firebaseAuth;
    List<User>connections = new ArrayList<>();
    RecyclerView recyclerView;
    ConnectionsAdapter connectionsAdapter;
    DatabaseReference connectionReference;
    ChildEventListener connectionEventListerner;
    DatabaseReference otherPersonChatRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_list);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        String myUserId = firebaseAuth.getUid();
        databaseReference = firebaseDatabase.getReference().child("agents").child(myUserId);
        recyclerView = findViewById(R.id.connection_list_recycler);
        connectionsAdapter = new ConnectionsAdapter(connections);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new FollowTouchListerner(this, recyclerView, new FollowTouchListerner.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                User touchedUser = connections.get(position);
                String chatRef = touchedUser.getuId() + myUserId;
                otherPersonChatRef = firebaseDatabase.getReference().child("agents").child(touchedUser.getuId()).child("chats");
                otherPersonChatRef.child(myUserId).setValue(chatRef);
                databaseReference.child("chats").child(touchedUser.getuId()).setValue(chatRef);
                Intent intent = new Intent(ConnectionList.this,Chat.class);
                intent.putExtra("chatRef",chatRef);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setAdapter(connectionsAdapter);



        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String user = (String) dataSnapshot.getValue();
                Log.d("ebojele",user.trim());
                connectionListen(user.trim());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseReference.child("connections").addChildEventListener(childEventListener);
    }

    void connectionListen(String user){
        Log.d("ben","The user is "+user);
        connectionReference = firebaseDatabase.getReference().child("agents").child(user).child("info");
        connectionEventListerner = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                User mUser = dataSnapshot.getValue(User.class);
                Log.d("ben",mUser.getuId());
                connections.add(mUser);
                connectionsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        connectionReference.addChildEventListener(connectionEventListerner);
    }
}
