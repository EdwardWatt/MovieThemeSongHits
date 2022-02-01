package android.example.com.moviethemesonghits;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class FavoriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list_layout);
        ArrayList<SongInfo> allSongs = new ArrayList<SongInfo>();
        allSongs.add(new SongInfo("Space Fights", "William Johns", 1977, true));
        allSongs.add(new SongInfo("Dino Land: Theme Park", "William Johns", 1993, true));
        allSongs.add(new SongInfo("Fedora Man", "William Johns", 1981, true));
        allSongs.add(new SongInfo("Super Person", "William Johns", 1978, true));
        allSongs.add(new SongInfo("Yellow Brick Road", "Harry Arlis", 1939, true));
        allSongs.add(new SongInfo("Magic Lamp", "Allen Milton", 1992, true));
        allSongs.add(new SongInfo("Philadelphia Boxer", "Will Contigia", 1976, true));
        allSongs.add(new SongInfo("Secret Agent Man", "Sonny Nermal", 1962, true));            // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
            // adapter knows how to create list items for each item in the list.
        SongInfoAdapter adapter = new SongInfoAdapter(this, allSongs);
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
                //When Item is click, We start the process to display which song was tapped
                SongInfo song = allSongs.get(position);
                //Display the Movie Title
                CharSequence TitleText = "You Picked: " + song.getMovieTitle();
                Toast.makeText(getApplicationContext(), TitleText, Toast.LENGTH_LONG).show();
                //Display the Artitst
                CharSequence ArtistText = "Performed by:  " + song.getArtistComposer();
                Toast.makeText(getApplicationContext(), ArtistText, Toast.LENGTH_LONG).show();
                //Display the year it was released in
                CharSequence ReleaseText = "Movie Released in " + song.getReleaseYear();
                Toast.makeText(getApplicationContext(), ReleaseText, Toast.LENGTH_LONG).show();
                //Find out if its a favorite
                CharSequence FavoriteText = "This song is not a Favorite";
                if (song.getFavorite()!=false){FavoriteText = "This song is in Your Favorites";}
                Toast.makeText(getApplicationContext(), FavoriteText, Toast.LENGTH_LONG).show();
            }
        });
    }
}
