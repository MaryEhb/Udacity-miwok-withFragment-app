package android.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPageAdaptor adapter = new SimpleFragmentPageAdaptor(this, getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
//
//    public void openNumberList(View view){
//        Intent intent = new Intent(this, NumbersActivity.class);
//        startActivity(intent);
//    }
//
//    public void openFamilyList(View view){
//        Intent intent = new Intent(this, FamilyActivity.class);
//        startActivity(intent);
//    }
//
//    public void openPhasesList(View view){
//        Intent intent = new Intent(this, PhrasesActivity.class);
//        startActivity(intent);
//    }
//
//    public void openColorsList(View view){
//        Intent intent = new Intent(this, ColorsActivity.class);
//        startActivity(intent);
//    }
}