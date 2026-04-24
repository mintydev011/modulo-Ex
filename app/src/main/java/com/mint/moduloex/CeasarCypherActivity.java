package com.mint.moduloex;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CeasarCypherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ceasar_cypher);


        EditText PlainText = findViewById(R.id.editTextEnClair);
        EditText CipherText  = findViewById(R.id.editTextChiffre);
        EditText Key = findViewById(R.id.editTextCle);
        Button DECENCBUTTON = findViewById(R.id.buttonEncryptDecrypt);


        DECENCBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plaintxt = PlainText.getText().toString();
                String ciphertxt = CipherText.getText().toString();
                String ResultText = "";
                int key = parseInt(Key.getText().toString());
                if(!plaintxt.isEmpty() && ciphertxt.isEmpty())
                {
                        if(key<26 && key>-1)
                        {
                            for (int i=0;i<plaintxt.length();i++)
                            {
                                if(plaintxt.charAt(i)>='a' && plaintxt.charAt(i)<='z')
                                {
                                   ResultText += (char)((plaintxt.charAt(i) - 'a'  + key)%26 + 97);

                                }else{
                                    ResultText += (char)((plaintxt.charAt(i) - 'A' + key)%26 + 65);
                                    // pour comprendre en suppose on a A donc c 65  on fait 65 - 'A' pour avoir ca position
                                    // donc on va avoir 0 apres on fait 0 + key par exemple 5 donc c = 5
                                    // apres il faut extraire la lettre qui correspond au position 5 from code ascii
                                    // donc c + 'A' = 'F'
                                }
                            }
                        }
                    CipherText.setText(ResultText);
                }else if(plaintxt.isEmpty() && !ciphertxt.isEmpty())
                {
                    if(key<26 && key>-1)
                    {
                        for (int i=0;i<ciphertxt.length();i++)
                        {
                            if(ciphertxt.charAt(i)>='a' && ciphertxt.charAt(i)<='z')
                            {
                                ResultText += (char)((ciphertxt.charAt(i) - 'a' - key +26)%26 +97);
                            }else{

                                ResultText += (char)((ciphertxt.charAt(i) -'A' - key +26)%26 + 65);
                            }
                        }
                    }
                    PlainText.setText(ResultText);
                }



            }
        });
    }
}