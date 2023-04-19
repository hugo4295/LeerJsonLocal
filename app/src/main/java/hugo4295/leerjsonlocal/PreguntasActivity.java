package hugo4295.leerjsonlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import PreguntasDTO.CPreguntas;

public class PreguntasActivity extends AppCompatActivity {

    TextView tvpregunta;
    RadioButton rbpa, rbpb, rbpc;
    Button btnsig;

    int indice=0;

    List<CPreguntas> listap = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        tvpregunta = findViewById(R.id.tvpregunta);
        rbpa = findViewById(R.id.rbpa);
        rbpb = findViewById(R.id.rbpb);
        rbpc = findViewById(R.id.rbpc);
        btnsig = findViewById(R.id.btnsig);

        InputStream is;
        byte[] buffer;
        AssetManager manager = this.getAssets();
        int size = 0;
        try {
            is = manager.open("File/preguntas.json");
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            String jsoncadena = new String(buffer, "UTF-8");
            JSONObject jsonobjeto = new JSONObject(jsoncadena);
            JSONArray jsonArray = jsonobjeto.getJSONArray("preguntas");

            for (int i=0;i<jsonArray.length();i++) {
                JSONObject itemJson = jsonArray.getJSONObject(i);
                listap.add(convertir(itemJson));
            }
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        //cargar la primer pregunta con el indice 0
        //Cpreguntas pregunta = listap.get(0);
        //lblpregunta.setText(pregunta.getpregunta());
        CPreguntas cPreguntas = listap.get(indice);
        tvpregunta.setText(cPreguntas.getPregunta());
        rbpa.setText(cPreguntas.getRespuesta_a());
        rbpb.setText(cPreguntas.getRespuesta_b());
        rbpc.setText(cPreguntas.getRespuesta_c());
        indice++;
    }

    private CPreguntas convertir(JSONObject DatoJson){
        CPreguntas cPreguntas = null;
        try {
            cPreguntas = new CPreguntas(DatoJson.getString("pregunta"),
                    DatoJson.getString("respuesta-a"),DatoJson.getString("respuesta-b"),
                    DatoJson.getString("respuesta-c"),"respuesta");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        String pregunta = cPreguntas.getPregunta();
        Log.i("valor pregunta","pregunta");
        return cPreguntas;
    }

    public void botones(View view){
        switch (view.getId()){
            case R.id.btnsig: cargarsig();break;
        }
    }

    private void cargarsig(){
        if (!(indice >= listap.size())) {
            CPreguntas cPreguntas = listap.get(indice);
            tvpregunta.setText(cPreguntas.getPregunta());
            rbpa.setText(cPreguntas.getRespuesta_a());
            rbpb.setText(cPreguntas.getRespuesta_b());
            rbpc.setText(cPreguntas.getRespuesta_c());
            indice++;
        }
    }
}