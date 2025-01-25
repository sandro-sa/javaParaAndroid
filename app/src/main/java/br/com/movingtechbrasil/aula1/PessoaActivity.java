package br.com.movingtechbrasil.aula1;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class PessoaActivity extends AppCompatActivity {

    private EditText editTextNome, editTextMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);

        editTextNome = findViewById(R.id.editTextNome);
        editTextMedia = findViewById(R.id.editTextMedia);

    }

    public void limparCampos(View view){

        editTextNome.setText(null);
        editTextMedia.setText(null);
        editTextNome.requestFocus();
        Toast.makeText(this,
                R.string.as_entradas_foram_apagadas,
                Toast.LENGTH_LONG).show();

    }

    public void salvarValores(View view){
        String nome = editTextNome.getText()
                .toString();
        if(nome.trim().isEmpty()){
            Toast.makeText(this,
                    R.string.digite_um_nome,
                    Toast.LENGTH_LONG).show();

            editTextNome.requestFocus();
            return;
        }
        nome = nome.trim();

        String mediaString = editTextMedia.getText()
                .toString();
        if(mediaString.trim().isEmpty()){
            Toast.makeText(this,
                    R.string.digite_a_media,
                    Toast.LENGTH_LONG).show();
            editTextMedia.requestFocus();
            return;
        }

        int media = 0;

        try {

            media = Integer.parseInt(mediaString);

        } catch (NumberFormatException e) {
            Toast.makeText(this,
                    R.string.media_deve_ser_um_numero_inteiro,
                    Toast.LENGTH_LONG).show();
            campoInteiroEmEvidencia(editTextMedia);
            return;
        }

        if(media < 0 || media > 100){
            Toast.makeText(this,
                    R.string.media_deve_ser_entre_0_e_100,
                    Toast.LENGTH_LONG).show();
            campoInteiroEmEvidencia(editTextMedia);
            return;
        }

        Toast.makeText(this,
                getString(R.string.nome_valor)+nome + "\n"+
                getString(R.string.media_valor)+ media, Toast.LENGTH_LONG).show();
    }

    private void campoInteiroEmEvidencia(@NonNull EditText campo){
        campo.setSelection(0, editTextMedia.getText().toString().length());
        campo.requestFocus();
    }

}