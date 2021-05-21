package com.books.bankingapp.allUsers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.books.bankingapp.MainActivity;
import com.books.bankingapp.R;
import com.books.bankingapp.database.User;
import com.books.bankingapp.viewmodel.UserViewModel;

import java.util.List;

public class AllUsers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UserListAdapter adapter = new UserListAdapter(new UserListAdapter.UserDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserViewModel mUserViewModel = new ViewModelProvider(this, getDefaultViewModelProviderFactory()).get(UserViewModel.class);

        mUserViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.submitList(users);
            }
        });
          mUserViewModel.insert(new User(3,"Hrithik","hrithik@gmail.com",30000));
          mUserViewModel.insert(new User(4,"Arpit","arpit@gmail.com",10000));
          mUserViewModel.insert(new User(5,"Harsh","harsh@gmail.com",5820));
          mUserViewModel.insert(new User(6,"Ravi","ravi@gmail.com",2110));
          mUserViewModel.insert(new User(7,"Sanjeev","sanjeev@gmail.com",24200));
          mUserViewModel.insert(new User(8,"Suraj","suraj@gmail.com",3200));
          mUserViewModel.insert(new User(9,"Shubham","shubham@gmail.com",52000));
          mUserViewModel.insert(new User(10,"Sunny","sunny@gmail.com",8522));
          mUserViewModel.insert(new User(0,"Rishav","rishav@gmail.com",9000));
          mUserViewModel.insert(new User(0,"Nirmal","nirmal@gmail.com",7000));

         mUserViewModel.deleteUser(new User(12,"Vignesh","vignesh@gmail.com",7000));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AllUsers.this, MainActivity.class));
        finish();
    }
}