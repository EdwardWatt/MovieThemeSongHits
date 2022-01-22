package android.example.com.moviethemesonghits;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView favoriteView = (TextView) findViewById(R.id.favoritesView);
        // Set a click listener on that View
        favoriteView.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Start the new activity
                //startActivity(FavoriteIntent);
                Intent FavoriteIntent = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(FavoriteIntent);
            }
        });
        TextView playlistView = (TextView) findViewById(R.id.playlistsView);
        // Set a click listener on that View
        playlistView.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Start the new activity
                //startActivity(FavoriteIntent);
                Intent PlaylistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(PlaylistIntent);
            }
        });
        TextView catalogView = (TextView) findViewById(R.id.catalogsView);
        // Set a click listener on that View
        catalogView.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent CatalogIntent = new Intent(MainActivity.this, CatalogActivity.class);
                // Start the new activity
                startActivity(CatalogIntent);
            }
        });

    }
}