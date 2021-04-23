package android.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {

    MediaPlayer player;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("red","wetetti", R.drawable.color_red, R.raw.color_red));
        words.add(new word("mustard yellow", "chiwiita", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new word("dusty yellow", "topiisa",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new word("white", "kelelli", R.drawable.color_white, R.raw.color_white));

        WordAdapter wordsAdapter = new WordAdapter(getActivity(), words, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                player = MediaPlayer.create(getActivity(),  words.get(position).getmSongRec());
                player.start();
                player.setOnCompletionListener(completionListener);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

}