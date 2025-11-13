package msku.ceng.madlab.week7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TableLayout board ;
    BoardPresenter boardPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }); */
        board = findViewById(R.id.board);
        boardPresenter = new BoardPresenter((BoardView) this);
        for (byte row=0;row<3;row++){
            TableRow tableRow = (TableRow) board.getChildAt(row);
            for (byte col =0;col<3;col++){
                Button button = (Button) tableRow.getChildAt(col);
                BoardPresenter.CellListener cellListener = new BoardPresenter.CellListener(boardPresenter,row,col);
                button.setOnClickListener(cellListener);
            }
        }


    }
    public void newGame(){

    }
    public  void invalidPlayer(byte row, byte col){
        Toast.makeText(this,"Invalid Move" , Toast.LENGTH_SHORT).show();
    }
}