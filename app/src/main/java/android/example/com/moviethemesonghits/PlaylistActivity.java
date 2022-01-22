package android.example.com.moviethemesonghits;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);
        TextView johnWilliamView = (TextView) findViewById(R.id.johnWilliamsView);
        // Set a click listener on that View
        johnWilliamView.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Start the new activity
                //startActivity(FavoriteIntent);
                Intent JohnWilliamIntent = new Intent(PlaylistActivity.this, JohnWilliamsActivity.class);
                startActivity(JohnWilliamIntent);
            }
        });
        TextView musicalView = (TextView) findViewById(R.id.musicalsView);
        // Set a click listener on that View
        musicalView.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Start the new activity
                //startActivity(FavoriteIntent);
                Intent MusicalIntent = new Intent(PlaylistActivity.this, MusicalListActivity.class);
                startActivity(MusicalIntent);
            }
        });
    }
}