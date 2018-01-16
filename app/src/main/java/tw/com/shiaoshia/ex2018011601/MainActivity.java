package tw.com.shiaoshia.ex2018011601;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
