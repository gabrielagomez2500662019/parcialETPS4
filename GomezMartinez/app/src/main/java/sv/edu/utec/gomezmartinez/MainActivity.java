package sv.edu.utec.gomezmartinez;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.gomezmartinez.helper.HelperBD;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drwLayout;
    Toolbar tlBarra;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra= findViewById(R.id.toolbar);
        drwLayout=findViewById(R.id.drawerLayout);
        navView=findViewById(R.id.navigator);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drwLayout,tlBarra,R.string.open,R.string.close);
        drwLayout.addDrawerListener(toggle);
        toggle.syncState();


        HelperBD helperBD = new HelperBD(MainActivity.this);
        SQLiteDatabase db = helperBD.getWritableDatabaseWithJournal();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.agregar://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new AgregarClienteFragment());
                        break;
                    case R.id.agregarVehiculos://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new AgregarVehiculoFragment());
                        break;
                    case R.id.listar://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new ListarClientesFragment());
                        break;

                }
                return true;
            }
        });
    }
    private void fragmentosR(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();

    }
}