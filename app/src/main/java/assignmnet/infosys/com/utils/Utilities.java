package assignmnet.infosys.com.utils;

import java.util.ArrayList;
import java.util.Iterator;

import assignmnet.infosys.com.feeds.FeedDetails;

/**
 * Created by Ranjith_Kodi on 5/7/2016.
 */
public class Utilities {

    /*Method removes empty feeds from the List*/
    public static ArrayList<FeedDetails> removeEmptyFeeds(ArrayList<FeedDetails> feedList) {
        for (Iterator<FeedDetails> iterator = feedList.iterator(); iterator.hasNext(); ) {
            if (isEmptyFeedItem(iterator.next())) {
                iterator.remove();
            }
        }
        return feedList;
    }

    /*Considering as Empty feed if Title and Description fields are null*/
    public static boolean isEmptyFeedItem(FeedDetails feedItem) {
        return isEmptyString(feedItem.getDescription()) && isEmptyString(feedItem.getTitle());
    }

    public static boolean isEmptyString(String str) {
        return (str != null && !str.equalsIgnoreCase(Constants.NULL_STRING)) ? false : true;
    }

}
