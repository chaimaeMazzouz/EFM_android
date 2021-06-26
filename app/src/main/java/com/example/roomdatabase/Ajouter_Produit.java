package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter_Produit extends AppCompatActivity {
    EditText codeEdt,desinationEdt,prixUnitaireEdt;
    CheckBox TypeOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter__produit);
        codeEdt=findViewById(R.id.codeEdt);
        desinationEdt=findViewById(R.id.disignationEdt);
        prixUnitaireEdt=findViewById(R.id.prixUnitaireEdt);
        TypeOp= findViewById(R.id.TypeOp);
    }

    public void ajouterProduit(View view) {
        if(isFieldEmty())return;
        Integer code=Integer.parseInt(codeEdt.getText().toString());
        String designation=desinationEdt.getText().toString();
        Double prixUnitaire=Double.parseDouble(prixUnitaireEdt.getText().toString());
        boolean typeO =TypeOp.isChecked();
        Produit p=MainActivity.db.produitDAO().getProduitByCode(code);
        if(p!=null){
            showToast("Cet id est deja existe");
            return;
        }
        try{
            MainActivity.db.produitDAO().ajouterProduit(new Produit(code, designation, prixUnitaire,typeO));
            showToast("Le Operation a ete ajouter");
        }catch (Exception e){
            showToast(e.getMessage());
        }
    }

    private void showFillFields() {
        showToast("il faut remplir tous les champs");
    }
    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public boolean isFieldEmty(){
        if(TextUtils.isEmpty(codeEdt.getText().toString())){
            showFillFields();
            return true;
        }
        if(TextUtils.isEmpty(desinationEdt.getText().toString())){
            showFillFields();
            return true;
        }
        if(TextUtils.isEmpty(prixUnitaireEdt.getText().toString())){
            showFillFields();
            return true;
        }
        return false;
    }

    public void backToMenu(View view) {
        finish();
    }

    public void changeCheck(View view) {
        if(TypeOp.isChecked()){
            TypeOp.setText("sortie d'argent");
        }else {
            TypeOp.setText("entree d'argent");
        }
    }
}