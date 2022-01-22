package android.example.com.moviethemesonghits;
public class SongInfo {
    private String mMovieTitle;
    private String mArtistComposer;
    private int mMediaSong;
    private int mMediaPic;
    public SongInfo(String movieTitle, String artistComposer, int MediaSong, int MediaPic){
        mMovieTitle = movieTitle;
        mArtistComposer = artistComposer;
        mMediaSong = MediaSong;
        mMediaPic = MediaPic;
    }
    public String getMovieTitle(){
        return mMovieTitle;
    }
    public String getArtistComposer(){
        return mArtistComposer;
    }
    public int getMediaSong(){
        return mMediaSong;
    }
    public int getMediaPic(){
        return mMediaPic;
    }
}
