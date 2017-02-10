package in.co.thingsdata.gurukul.services.request;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.co.thingsdata.gurukul.data.GetSubjectListData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;

import static in.co.thingsdata.gurukul.services.helper.CommonRequest.RequestType.COMMON_REQUEST_GET_SUBJECT_LIST;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_ACCESS_TOKEN;

/**
 * Created by Vikas on 2/10/2017.
 */

public class GetSubjectListReq extends CommonRequest {
    GetSubjectListData mData;

    public interface GetSubjectListResponse {
        void onGetSubjectListResponse(ResponseCode res, GetSubjectListData data);
    }
    private GetSubjectListResponse mAppCallback;

    public GetSubjectListReq(Context context, GetSubjectListData data, GetSubjectListResponse cb) {
        super(context, COMMON_REQUEST_GET_SUBJECT_LIST, CommonRequestMethod.COMMON_REQUEST_METHOD_POST, null);
        mData = data; mAppCallback = cb;
        Map<String, String> param = new HashMap<>();
        param.put(JSON_FIELD_ACCESS_TOKEN, data.getAccessToken());
        setParam(param);
    }

    @Override
    public void onResponseHandler(JSONObject response) {
        //TODO: Parse JSON and add subject list in mData.
        mAppCallback.onGetSubjectListResponse(ResponseCode.COMMON_RES_SUCCESS, mData);
    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
