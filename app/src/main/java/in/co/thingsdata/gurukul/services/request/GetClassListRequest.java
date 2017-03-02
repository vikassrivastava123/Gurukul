package in.co.thingsdata.gurukul.services.request;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import in.co.thingsdata.gurukul.data.common.UserData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;

import static in.co.thingsdata.gurukul.services.helper.CommonRequest.RequestType.COMMON_REQUEST_GET_CLASS_LIST;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_CLASS_ROOM_ID;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_DATA;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_SCHOOL;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_STATUS;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_UNIQUE_ID;

/**
 * Created by Vikas on 3/2/2017.
 */

public class GetClassListRequest extends CommonRequest {
    private ArrayList<String> mClassIdList;

    public interface GetClassListCallback {
        void onGetClassListResponse(ResponseCode res, ArrayList<String> class_id_list);
    }
    private GetClassListCallback mAppCallback;
    public GetClassListRequest(Context context, GetClassListCallback cb) {
        super(context, COMMON_REQUEST_GET_CLASS_LIST, CommonRequestMethod.COMMON_REQUEST_METHOD_GET, null);
        mAppCallback = cb;
        String url = getURL();
        url+= JSON_FIELD_SCHOOL + "=" + UserData.getSchoolCode();
        setURL(url);
    }

    @Override
    public void onResponseHandler(JSONObject response) {
        try {
            if (response.getInt(JSON_FIELD_STATUS) == 1) {
                JSONArray data = response.getJSONArray(JSON_FIELD_DATA);
                int total = data.length();
                for (int i = 0; i < total; i++) {
                    JSONObject class_detail = data.getJSONObject(i);
                    String class_unique_id = class_detail.getString(JSON_FIELD_UNIQUE_ID);
                    mClassIdList.add(class_unique_id);
                }
                mAppCallback.onGetClassListResponse(ResponseCode.COMMON_RES_SUCCESS, mClassIdList);
            }
            else{
                mAppCallback.onGetClassListResponse(ResponseCode.COMMON_RES_NO_DATA_FOUND, null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
