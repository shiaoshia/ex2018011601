package tw.com.shiaoshia.ex2018011601;

import android.icu.util.ValueIterator;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

    //讀檔
    public void click05(View v) {
        File f = new File(getFilesDir(),"myfile1.txt");

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine(); //讀出一行資料
            Log.d("FILE",str);
            Gson gson = new Gson();
            ArrayList<String> mydata = gson.fromJson(str, new TypeToken<ArrayList<String>>(){}.getType());
            for(String s:mydata) {
                Log.d("FILE","data:" + s);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //讀檔
    public void click06(View v) {
        File f = new File(getFilesDir(),"myfile2.txt");

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine(); //讀出一行資料
            Log.d("FILE",str);
            Gson gson = new Gson();
            ArrayList<Student> mydata = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
            for(Student s:mydata) {
                Log.d("FILE","id:" + s.id +",name:" + s.name +",score="+s.score);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click07(View v) {

        //  /storage/emulated/0/Android/data/tw.com.shiaoshia.ex2018011601/files/data
        File f = getExternalFilesDir("data");
        Log.d("FILE",f.getAbsolutePath());

        //  /storage/emulated/0
        f = Environment.getExternalStorageDirectory();
        Log.d("FILE",f.getAbsolutePath());
    }
}
