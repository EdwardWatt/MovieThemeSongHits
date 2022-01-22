package android.example.com.moviethemesonghits;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
public class FavoriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list_layout);
        ArrayList<SongInfo> allFavSongs = new ArrayList<SongInfo>();
        allFavSongs.add(new SongInfo("Star Wars", "John Williams", R.raw.starwars, R.drawable.starwars));
        allFavSongs.add(new SongInfo("Indiana Jones", "John Williams", R.raw.indianajones, R.drawable.indianajones));
        allFavSongs.add(new SongInfo("Terminator", "Brad Fiedel", R.raw.terminator, R.drawable.terminator));
        allFavSongs.add(new SongInfo("Superman", "John Williams", R.raw.superman, R.drawable.superman));
        allFavSongs.add(new SongInfo("Wizard of Oz", "Harold Arlen", R.raw.wizardofoz, R.drawable.wizardofoz));
        allFavSongs.add(new SongInfo("Aladdin", "Alan Menken", R.raw.aladdin, R.drawable.aladdin));
        allFavSongs.add(new SongInfo("Rocky", "Bill Conti", R.raw.rocky, R.drawable.rocky));
        allFavSongs.add(new SongInfo("James Bond", "Monty Norman", R.raw.jamesbond, R.drawable.jamesbond));
            // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
            // adapter knows how to create list items for each item in the list.
        SongInfoAdapter adapter = new SongInfoAdapter(this, allFavSongs);
            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.musicListView);
            // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
            // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
            // Set a click listener on that View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //When Item is click, We start the process to open Player, we use item click position to figure out which song to play
                SongInfo song = allFavSongs.get(position);
                //Create intent and transfer Extras from this intent to the player intent, then start the player
                Intent i = new Intent(FavoriteActivity.this, PlayerActivity.class);
                i.putExtra("Movie", song.getMovieTitle());
                i.putExtra("Composer", song.getArtistComposer());
                i.putExtra("Song", song.getMediaSong());
                i.putExtra("Pic", song.getMediaPic());
                startActivity(i);
            }
        });
    }
}
