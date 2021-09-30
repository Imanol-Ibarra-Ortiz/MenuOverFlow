package com.imanolio.menuoverflow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
EditText txtCadena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCadena=findViewById(R.id.txtCadena);
        registerForContextMenu(txtCadena);
    }

    //Metodo para mostrar y ocultar el menú de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Menu para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.item1){
            Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.item2){
            Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.item3){
            Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //Metodo para mostrar menús contextuales
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontextual, menu);
    }

    //Asignar las funciones correspondientes a las opciones menús contextuales
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int numero = item.getItemId();
        switch (numero){
            case R.id.itMayus:
                txtCadena.setText(txtCadena.getText().toString().toUpperCase());
                return true;
            case R.id.itMinus:
                txtCadena.setText(txtCadena.getText().toString().toLowerCase());
                return true;
        }
        return super.onContextItemSelected(item);
    }

    //Metodo para mostrar menús emergente
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menuemergente, popup.getMenu());
        popup.show();
    }

    //Metodo para realizar una acción cuando el usuario selecciona un elemento de menú
    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);

        // This activity implements OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menuemergente);
        popup.show();
    }

    //Asignar las funciones correspondientes a las opciones menús emergente
    @Override
    public boolean onMenuItemClick (MenuItem item) {
        int numero = item.getItemId();
        switch (numero) {
            case R.id.itmME1:
                Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itmME2:
                Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itmME3:
                Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}