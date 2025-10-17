package msku.ceng.madlab.week3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PostActivity extends AppCompatActivity {

    static final int CAPTURE_IMAGE = 0;
    ImageView img;
    EditText txtMessage;

    ImageButton btnOK;
    ImageButton btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtMessage = findViewById(R.id.txtMessage);
        img = findViewById(R.id.imgView);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAPTURE_IMAGE);
            }
        });
        btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener()){

        }




        btnCancel = findViewById(R.id.btnCancel);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAPTURE_IMAGE && resultCode == PostActivity.RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap image = (Bitmap) bundle.get("data");

        }
    }
}