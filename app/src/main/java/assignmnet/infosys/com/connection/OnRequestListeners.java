package assignmnet.infosys.com.connection;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Ranjith_Kodi on 5/8/2016.
 */
public interface OnRequestListeners {
    void onRequestSuccess(JSONObject response);
    void onRequestFail(VolleyError volleyError);
}
