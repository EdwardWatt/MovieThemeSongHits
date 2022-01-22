package android.example.com.moviethemesonghits;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
public class JohnWilliamsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list_layout);
        //Declare Custom Arraylist
        ArrayList<SongInfo> allSongs = new ArrayList<SongInfo>();
        allSongs.add(new SongInfo("Star Wars", "John Williams", R.raw.starwars, R.drawable.starwars));
        allSongs.add(new SongInfo("Indiana Jones", "John Williams", R.raw.indianajones, R.drawable.indianajones));
        allSongs.add(new SongInfo("Jaws", "John Williams", R.raw.jaws, R.drawable.jaws));
        allSongs.add(new SongInfo("Superman", "John Williams", R.raw.superman, R.drawable.superman));
        allSongs.add(new SongInfo("Schindler's List", "John Williams", R.raw.schindlerslist, R.drawable.schindlerslist));
        // Create an {@link SongInfoAdapter}, whose data source is a list of {@link Songs}s. The
        // adapter knows how to create list items for each item in the list.
        SongInfoAdapter adapter = new SongInfoAdapter(this, allSongs);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_card.xml layout file.
        ListView listView = (ListView) findViewById(R.id.musicListView);
        // Make the {@link ListView} use the {@link SongInfoAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link SongInfo} in the list.
        listView.setAdapter(adapter);
        // Set a Item click listener on that View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //When Item is click, We start the process to open Player, we use item click position to figure out which song to play
                SongInfo song = allSongs.get(position);
                //Create intent and transfer Extras from this intent to the player intent, then start the player
                Intent i = new Intent(JohnWilliamsActivity.this, PlayerActivity.class);
                i.putExtra("Movie", song.getMovieTitle());
                i.putExtra("Composer", song.getArtistComposer());
                i.putExtra("Song", song.getMediaSong());
                i.putExtra("Pic", song.getMediaPic());
                startActivity(i);
            }
        });
    }
}
