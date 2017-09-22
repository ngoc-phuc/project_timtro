package example.com.timtro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity4 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private EditText et1,et2,et3,et4;
    private Spinner spinner;
    private String[] language;
    private ArrayAdapter<String> spinnerAddapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //tao chu tren thanh toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //tao thanh menu va su kien khi click no
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        spinner = (Spinner) findViewById(R.id.spiner);
        language = getResources().getStringArray(R.array.language);
        spinnerAddapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,language);
        spinner.setAdapter(spinnerAddapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("selected: "+language[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void onClick(View view){
        et1=(EditText) findViewById(R.id.t1) ;
        et2=(EditText) findViewById(R.id.t2) ;
        et3=(EditText) findViewById(R.id.t3) ;
        et4=(EditText) findViewById(R.id.t4) ;
        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();
        String str3 = et3.getText().toString();
        String str4 = et4.getText().toString();
        if(str1.length()>0&&str2.length()>0&&str3.length()>0&&str4.length()>0){
            Snackbar.make(view, "Đăng tin thành công", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Thread bamgio=new Thread(){
                public void run()
                {
                    try {
                        sleep(2000);
                    } catch (Exception e) {

                    }
                    finally
                    {
                        Intent activitymoi=new Intent("example.com.timtro.MainActivity");
                        startActivity(activitymoi);
                    }
                }
            };
            bamgio.start();
        }
        else{
            Snackbar.make(view, "Bạn chưa nhập đủ các trường bắt buộc.Hãy nhập lại!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   //ham xu li mục setting
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.search_view) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.tim_phong) {
            Intent intent = new Intent(MainActivity4.this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.tim_ghep) {
            Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
            startActivity(intent);

        } else if (id == R.id.dang_cho_thue) {

        } else if (id == R.id.dang_tim_ghep) {
            Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
            startActivity(intent);

        } else if (id == R.id.tro_giup) {

        } else if (id == R.id.bao_cao) {

        }
        //cau lenh de quay ve man hinh chinh
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
