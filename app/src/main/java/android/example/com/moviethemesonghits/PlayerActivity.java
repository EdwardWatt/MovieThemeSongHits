package android.example.com.moviethemesonghits;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class PlayerActivity extends CatalogActivity {
    // Instantiating the MediaPlayer class
    MediaPlayer music;
    int mp3Play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        //Get extras from previous intent, make sure its not null before beginning
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //Setting up the Strings and int for display and sound, using the extra function to save transferred variables to a local variable
            String movieTitle = "From the Movie: " + extras.getString("Movie");
            String composer = "Performed by: " + extras.getString("Composer");
            int moviePoster = extras.getInt("Pic");
            int mp3Play = extras.getInt("Song");
            //apply local variables to elements in the XML
            ImageView poster = (ImageView) findViewById(R.id.moviePosterImageView);
            poster.setImageResource(moviePoster);
            TextView movieTitleTextView = (TextView) findViewById(R.id.movieTitleTextView);
            TextView composerTextView = (TextView) findViewById(R.id.performerTextView);
            // set this text on the name TextView
            composerTextView.setText(composer);
            movieTitleTextView.setText(movieTitle);
            //initiate player, all code below comes from https://www.geeksforgeeks.org/how-to-build-a-simple-music-player-app-using-android-studio/
            music = MediaPlayer.create(this, mp3Play);
            //The key argument here must match that used in the other activity
        } else {
            this.finish();
        }
    }
    // Playing the music
    public void musicPlayButton(View v)
    {
        music.start();
    }
    // Pausing the music
    public void musicPauseButton(View v)
    {
        music.pause();
    }
    // Stopping the music
    public void musicStopButton(View v)
    {
        music.stop();
        this.finish();
    }
    @Override
    public void onBackPressed(){
        music.stop();
        this.finish();
    }
}