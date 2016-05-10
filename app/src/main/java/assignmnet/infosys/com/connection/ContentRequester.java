package assignmnet.infosys.com.connection;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import assignmnet.infosys.com.utils.Constants;

/**
 * Created by Ranjith_Kodi on 5/5/2016.
 */

public class ContentRequester {

    private static ContentRequester mInstance;
    RequestQueue contentRequestQueue;

    private ContentRequester(Context context) {
        contentRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static ContentRequester getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new ContentRequester(context);
        }

        return mInstance;
    }


    public void getContent(final OnRequestListeners listener) {
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, Constants.FEED_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onRequestSuccess(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onRequestFail(error);
            }
        });


        getContentRequestQueue().add(jor);
    }

    public RequestQueue getContentRequestQueue() {
        return contentRequestQueue;
    }

}
