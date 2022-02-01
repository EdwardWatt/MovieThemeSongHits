package android.example.com.moviethemesonghits;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
/*
 * {@link SongInfoAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link SongInfo} objects.
 * */
public class SongInfoAdapter extends ArrayAdapter<SongInfo> {
    private static final String LOG_TAG = SongInfoAdapter.class.getSimpleName();
    public SongInfoAdapter(Activity context, ArrayList<SongInfo> SongInfo) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, SongInfo);
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_card, parent, false);
        }
        // Get the {@link currentSongInfo} object located at this position in the list
        SongInfo currentSong = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView movieTitleTextView = (TextView) listItemView.findViewById(R.id.movieTitle_text_view);
        // Get the movie name from the current SongInfo object and
        // set this text on the moviename TextView
        movieTitleTextView.setText(currentSong.getMovieTitle());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artistComposer_text_view);
        // Get the composer from the current SongInfo object and
        // set this text on the artist TextView
        artistTextView.setText(currentSong.getArtistComposer());
        TextView releaseTextView = (TextView) listItemView.findViewById(R.id.movieReleaseTextView);
        releaseTextView.setText("" + currentSong.getReleaseYear());
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
