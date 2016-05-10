package assignmnet.infosys.com.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import assignmnet.infosys.com.assignment.LiveFeedActivity;
import assignmnet.infosys.com.assignment.R;
import assignmnet.infosys.com.feeds.FeedDetails;


/**
 * Created by Ranjith_Kodi on 12/11/2015.
 */
public class ContentListAdapter extends RecyclerView.Adapter<ContentListAdapter.FeedItemViewHolder> {

    static ContentListAdapter contentListAdapter = null;
    ArrayList<FeedDetails> feeds;
    Context mContext;

    public ContentListAdapter(Context c) {
        this.mContext = c;
        feeds = new ArrayList<FeedDetails>();
    }

    //Sets the Adapter Content
    public void setContent(ArrayList<FeedDetails> f) {
        this.feeds = f;
        notifyDataSetChanged();
    }

    // Return the size of List Items
    @Override
    public int getItemCount() {
        return feeds.size();
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_card, viewGroup, false);
        final FeedItemViewHolder feedViewHolder = new FeedItemViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Need to handle On click of feed items
            }
        });

        return feedViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder personViewHolder, int i) {
        personViewHolder.setFeedDetails(feeds.get(i));
        personViewHolder.description.setText(feeds.get(i).getDescription());
        personViewHolder.title.setText(feeds.get(i).getTitle());
        try {
            /*Picasso library is used for downloading images. It downloads the images and will be loaded into placeholder i.e image views
            * Showing default image if any error occurs during image download process * */
            Picasso.with(mContext).load(feeds.get(i).getImageHref()).error(R.drawable.default_image).into(personViewHolder.contentImage);
        } catch (Exception e) {
            Log.d(LiveFeedActivity.TAG, e.getMessage());
        }
    }

    public class FeedItemViewHolder extends RecyclerView.ViewHolder {
        CardView feedCardView;
        TextView title;
        TextView description;
        ImageView contentImage;
        FeedDetails feedDetails;

        FeedItemViewHolder(View itemView) {
            super(itemView);
            feedCardView = (CardView) itemView.findViewById(R.id.card);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            contentImage = (ImageView) itemView.findViewById(R.id.content_img);
        }

        public FeedDetails getFeedDetails() {
            return feedDetails;
        }

        public void setFeedDetails(FeedDetails feedDetails) {
            this.feedDetails = feedDetails;
        }

    }

}