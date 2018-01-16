package tw.com.shiaoshia.ex2018011601;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void click01(View v) {
        Log.d("File",getFilesDir().toString()); //取得file資料夾位置/data/user/0/tw.com.shiaoshia.ex2018011601/files
        Log.d("File",getCacheDir().toString()); //取得catch資料夾位置/data/user/0/tw.com.shiaoshia.ex2018011601/cache
        String str = getFilesDir().getAbsolutePath();
        String str1=getCacheDir().getAbsolutePath();
        Log.d("FILE",str);
        Log.d("FILE",str1);
    }

    public void click02(View v) {
        File f = new File(getFilesDir(),"myfile.txt");

        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Hello World");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click03(View v) {
        ArrayList<String> mylist = new ArrayList<>();
        mylist.add("Bob");
        mylist.add("Tony");
        mylist.add("Amy");
        File f = new File(getFilesDir(),"myfile1.txt");

        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click04(View v) {
        ArrayList<Student> mydata = new ArrayList<>();
        mydata.add(new Student(1,"Bob",95));
        mydata.add(new Student(2,"Tom",83));
        mydata.add(new Student(3,"Amy",90));

        File f = new File(getFilesDir(),"myfile2.txt");

        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mydata);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Student {
        public int id;
        public String name;
        public int score;
        public Student(int id,String name,int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }
    }
}
