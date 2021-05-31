package com.rsschool.android2021;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
    }

    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        transaction.commit(); //? TODO: invoke function which apply changes of the transaction
    }

    //запуск фрагмета2 с передачей min и max значения генерируемого числа
    private void openSecondFragment(int min, int max) {
        final Fragment secondFragment = SecondFragment.newInstance(min,max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment);
        transaction.commit();
    }
    // реализация метода интерфейса ActionPerformedListener для вызова второго фрагмента2
    @Override
    public void actionPerformed2(int min, int max) {
        openSecondFragment(min, max);
    }

    // реализация метода интерфейса ActionPerformedListener для вызова второго фрагмента1
    @Override
    public void actionPerformed1(int number) {
        openFirstFragment(number);
    }
}
