package android.example.com.moviethemesonghits;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
public class CatalogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list_layout);
        //Declare Custom Arraylist
        ArrayList<SongInfo> allSongs = new ArrayList<SongInfo>();
        allSongs.add(new SongInfo("Star Wars", "John Williams", R.raw.starwars, R.drawable.starwars));
        allSongs.add(new SongInfo("Halloween", "John Carpenter", R.raw.halloween, R.drawable.halloween));
        allSongs.add(new SongInfo("Indiana Jones", "John Williams", R.raw.indianajones, R.drawable.indianajones));
        allSongs.add(new SongInfo("Jaws", "John Williams", R.raw.jaws, R.drawable.jaws));
        allSongs.add(new SongInfo("Chariots of Fire", "Vangelis Papathanassiou", R.raw.cof, R.drawable.cof));
        allSongs.add(new SongInfo("The Good, The Bad and the Ugly", "Ennio Morricones", R.raw.goodbadugly, R.drawable.goodbadugly));
        allSongs.add(new SongInfo("The Pink Panther", "Henry Mancini", R.raw.pinkpanther, R.drawable.pinkpanther));
        allSongs.add(new SongInfo("Shaft", "Isaac Hayes", R.raw.shaft, R.drawable.shaft));
        allSongs.add(new SongInfo("Terminator", "Brad Fiedel", R.raw.terminator, R.drawable.terminator));
        allSongs.add(new SongInfo("Superman", "John Williams", R.raw.superman, R.drawable.superman));
        allSongs.add(new SongInfo("Lawrence of Arabia", "Maurice Jarre", R.raw.loa, R.drawable.loa));
        allSongs.add(new SongInfo("Wizard of Oz", "Harold Arlen", R.raw.wizardofoz, R.drawable.wizardofoz));
        allSongs.add(new SongInfo("Aladdin", "Alan Menken", R.raw.aladdin, R.drawable.aladdin));
        allSongs.add(new SongInfo("The Little Mermaid", "Alan Menken", R.raw.littlemermaid, R.drawable.littlemermaid));
        allSongs.add(new SongInfo("Rocky", "Bill Conti", R.raw.rocky, R.drawable.rocky));
        allSongs.add(new SongInfo("The Magnificent Seven", "Elmer Bernstein", R.raw.magnificent7, R.drawable.magnificent7));
        allSongs.add(new SongInfo("Godfather", "Nino Rota", R.raw.godfather, R.drawable.godfather));
        allSongs.add(new SongInfo("Beauty and the Beast", "Howard Ashman", R.raw.beautybeast, R.drawable.beautybeast));
        allSongs.add(new SongInfo("Schindler's List", "John Williams", R.raw.schindlerslist, R.drawable.schindlerslist));
        allSongs.add(new SongInfo("James Bond", "Monty Norman", R.raw.jamesbond, R.drawable.jamesbond));
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
                Intent i = new Intent(CatalogActivity.this, PlayerActivity.class);
                i.putExtra("Movie", song.getMovieTitle());
                i.putExtra("Composer", song.getArtistComposer());
                i.putExtra("Song", song.getMediaSong());
                i.putExtra("Pic", song.getMediaPic());
                startActivity(i);
            }
        });
    }
}
