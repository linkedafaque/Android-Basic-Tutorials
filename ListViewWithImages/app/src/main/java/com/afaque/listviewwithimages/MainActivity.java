package com.afaque.listviewwithimages;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images= {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        memeTitles = resources.getStringArray(R.array.titles);
        memeDescriptions = resources.getStringArray(R.array.descriptions);

        listView = (ListView) findViewById(R.id.listView);
        MessageAdapter adapter = new MessageAdapter(this, memeTitles, memeDescriptions, images);
        listView.setAdapter(adapter);

    }
}

class MessageAdapter extends ArrayAdapter<String>
{
    int[] images;
    String[] titles, descriptions;

    MessageAdapter(Context context, String[] titles, String[] descriptions, int[] images) {
        super(context, R.layout.single_row, R.id.textViewLarge, titles);
        this.images = images;
        this.titles = titles;
        this.descriptions = descriptions;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        View row = convertView;
//
//        if(row == null) {
//            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(R.layout.single_row, parent, false);
//        }
//
//        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
//        TextView title = (TextView) row.findViewById(R.id.textViewLarge);
//        TextView description = (TextView) row.findViewById(R.id.textViewSmall);
//
//        imageView.setImageResource(images[position]);
//        title.setText(titles[position]);
//        description.setText(descriptions[position]);
//
//        return row;
//    }

    class MyViewHolder {
        ImageView myImage;
        TextView myTitle;
        TextView myDescription;

        MyViewHolder(View view) {
            myImage = (ImageView) view.findViewById(R.id.imageView);
            myTitle = (TextView) view.findViewById(R.id.textViewLarge);
            myDescription = (TextView) view.findViewById(R.id.textViewSmall);
        }
    }

    //Using the ViewHolder Design Pattern To Improve Performance
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        MyViewHolder myViewHolder = null;

        if(row == null) { //1st time
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            myViewHolder = new MyViewHolder(row);
            row.setTag(myViewHolder);
        }
        else { //recycling
            myViewHolder = (MyViewHolder) row.getTag();
        }
        myViewHolder.myImage.setImageResource(images[position]);
        myViewHolder.myDescription.setText(descriptions[position]);
        myViewHolder.myTitle.setText(titles[position]);
        return row;
    }
}
