package android.example.com.moviethemesonghits;
public class SongInfo {
    private String mMovieTitle;
    private String mArtistComposer;
    private int mReleaseYear;
    private boolean mFavorite;
    public SongInfo(String movieTitle, String artistComposer, int ReleaseYear, boolean Favorite){
        mMovieTitle = movieTitle;
        mArtistComposer = artistComposer;
        mReleaseYear = ReleaseYear;
        mFavorite = Favorite;
    }
    public String getMovieTitle(){
        return mMovieTitle;
    }
    public String getArtistComposer(){
        return mArtistComposer;
    }
    public int getReleaseYear(){
        return mReleaseYear;
    }
    public boolean getFavorite(){
        return mFavorite;
    }
}
