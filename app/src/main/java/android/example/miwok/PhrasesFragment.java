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

public class PhrasesFragment extends Fragment {

    MediaPlayer player;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?", "tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?", "michekses?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "eenes'aa?", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I'm coming.", "hee' eenem", R.raw.phrase_yes_im_coming));
        words.add(new word("I'm coming.", "eenem", R.raw.phrase_im_coming));
        words.add(new word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here.", "enni'nem", R.raw.phrase_come_here));


        WordAdapter wordsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
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