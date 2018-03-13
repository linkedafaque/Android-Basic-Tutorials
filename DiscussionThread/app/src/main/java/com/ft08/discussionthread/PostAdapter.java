package com.ft08.discussionthread;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    public PostAdapter(Context context, int resource, List<Post> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        ImageView photo;
        TextView name;
        TextView message;
        ViewHolder(View v) {
            photo = (ImageView) v.findViewById(R.id.messagePhoto);
            name = (TextView) v.findViewById(R.id.nameTextView);
            message = (TextView) v.findViewById(R.id.messageTextView);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        ViewHolder myViewHolder = null;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.message_item, parent, false);
            myViewHolder = new ViewHolder(row);
            row.setTag(myViewHolder);
        }
        else { myViewHolder = (ViewHolder) row.getTag(); }

        Post post = getItem(position);
        myViewHolder.name.setText(post.getName());
        boolean isPhoto = post.getPhotoUrl() != null;

        if(isPhoto) {
            myViewHolder.message.setVisibility(View.GONE);
            myViewHolder.photo.setVisibility(View.VISIBLE);
            Glide.with(myViewHolder.photo.getContext())
                 .load(post.getPhotoUrl())
                 .into(myViewHolder.photo);
        }
        else {
            myViewHolder.message.setVisibility(View.VISIBLE);
            myViewHolder.photo.setVisibility(View.GONE);
            myViewHolder.message.setText(post.getText());
        }
        return row;
    }
}
