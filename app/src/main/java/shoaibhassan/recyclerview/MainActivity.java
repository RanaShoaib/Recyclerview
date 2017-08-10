package shoaibhassan.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button) findViewById(R.id.downloadlist);
        b2 =(Button) findViewById(R.id.displaylist);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             BackgroundTask backgroundTask =new BackgroundTask(MainActivity.this);
                backgroundTask.execute();


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Displaylist.class));
            }
        });
    }
}
