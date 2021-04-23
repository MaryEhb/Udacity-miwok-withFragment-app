
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

public class NumbersFragment extends Fragment {

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

        words.add(new word("one","lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new word("two","otikio",R.drawable.number_two, R.raw.number_two));
        words.add(new word("three","tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new word("four","oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new word("five","massokka",R.drawable.number_five, R.raw.number_five));
        words.add(new word("six","temmokka",R.drawable.number_six, R.raw.number_six));
        words.add(new word("seven","kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("eight","kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("nine","wo'e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("ten","na aacha",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter wordsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
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

        // Inflate the layout for this fragment
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