package hugo4295.leerjsonlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        InputStream is;
        byte[] buffer;
        AssetManager manager = this.getAssets();
        int size = 0;
        try {
            is = manager.open("File/acceso.json");
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            String jsoncadena = new String(buffer, "UTF-8");
            JSONObject jsonobjeto = new JSONObject(jsoncadena);
            Log.i("informacion",jsonobjeto.getString("nombre"));
            is.close();
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PrincipalActivity.this, PreguntasActivity.class);
                startActivity(intent);
            }
        },1000);
    }
}