package kr.co.haun.kbbbc_20211227.utils

import android.os.AsyncTask
import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class ServerUtil {

//    화면(액티비티)의 입장에서, 서버응답이 돌아왔을때 어떤 행동을 실행할지
//    행동 지침을 담아주기 위한 인터페이스 (가이드북/매뉴얼) 정의

    interface JsonResponseHandler {
        fun onResponse(json : JSONArray)
    }

    companion object {

        val HOST_URL = "https://esxxmvy5ne.execute-api.ap-northeast-2.amazonaws.com/getWorshipList/get_worship_list"

        //예배 리스트
        fun getRequestWorshipList(worship_type: String, handler: JsonResponseHandler?) {

            val client = OkHttpClient()


//            로그인 주소 : http://15.164.153.174/user
//            Intent(mContext, 목적지) => 목적지 대응 : 기능 주소
            val urlString = "${HOST_URL}"

//            putExtra("이름표", 실제값) => 폼데이터.add("서버요구이름표", 실제첨부값)
            val formData = FormBody.Builder()
                .add("worship_type", worship_type)
                .build()

//            요청의 모든 정보를 담고있는 Request를 생성하자.
//            Intent 덩어리에 대응되는 개념.

// create your json here
            // create your json here
            val jsonObject = JSONObject()
            try {
                jsonObject.put("worship_type", worship_type)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            val mediaType = "application/json; charset=utf-8".toMediaType()
            val body = jsonObject.toString().toRequestBody(mediaType)
            val request = Request.Builder()
                .url(urlString)
                .post(body)
//                .header() // API가 header 데이터를 요구하면 담아주는 곳
                .build()

//            완성된 Request를 가지고 실제 서버 연결 (클라이언트의 일) 코드

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
//                    서버에 연결 자체를 실패한 경우. (물리적 실패)
//                    인터넷 연결 실패 등등.
//                    아이디/비번 틀림등 로그인 실패는 여기가 아님.
                }

                override fun onResponse(call: Call, response: Response) {

//                    검사 결과가 성공이던, 실패던 관계 없이 서버가 뭔가 답변을 해주면 무조건 실행.

//                    서버가 내려준 응답중 본문(body)만 String 형태로 저장.
                    val bodyString = response.body!!.string()

//                    받아낸 String을 => 분석하기 용이한 JSONObject로 변환.
                    //val jsonObj = JSONObject(bodyString)
                    val jsonObj = JSONArray(bodyString)


                    Log.d("서버응답본문", jsonObj.toString())

//                    어떤 서버응답 처리를 해줄지 가이드북 (인터페이스)가 존재한다면,
//                    그 가이드북에 적힌 내용을 실제로 실행해달라는 코드.
                    handler?.onResponse(jsonObj)

                }
            })
        }
    }
}