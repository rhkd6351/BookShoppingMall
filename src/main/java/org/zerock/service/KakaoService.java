package org.zerock.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.zerock.domain.TokenVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Service
public class KakaoService {

    public String getAccessCode(TokenVO vo){ // refresh 토큰을 이용한 갱신 메소드

        String refreshToken = vo.getRefreshToken();
        String accessToken = "";
        String reqUrl = "https://kauth.kakao.com/oauth/token";

        try{
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true); // 이게 무슨역할?

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=refresh_token");
            sb.append("&client_id=eedc76d38d9fb6483db97b48b0be11ee");
            sb.append("&refresh_token=" + refreshToken);
            bw.write(sb.toString());
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            while((line = br.readLine()) != null){
                result += line;
            }
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            accessToken = element.getAsJsonObject().get("access_token").getAsString();

            br.close();
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return accessToken;
    }

    public HashMap<String, String> getAccessCode(String authorizeCode){ // 인가 코드를 이용한 갱신 메소드
        String accessToken = "";
        String refreshToken = "";
        int refreshTokenExpiresIn = 0;
        HashMap<String, String> tokenMap = new HashMap<>();
        String reqUrl = "https://kauth.kakao.com/oauth/token";

        try{
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=eedc76d38d9fb6483db97b48b0be11ee");
            sb.append("&redirect_uri=http://localhost:8080/user/login/kakao");
            sb.append("&code=" + authorizeCode);
            bw.write(sb.toString());
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            while((line = br.readLine()) != null){
                result += line;
            }
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            accessToken = element.getAsJsonObject().get("access_token").getAsString();
            refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
            refreshTokenExpiresIn = element.getAsJsonObject().get("refresh_token_expires_in").getAsInt();

            tokenMap.put("accessToken", accessToken);
            tokenMap.put("refreshToken", refreshToken);
            tokenMap.put("refreshTokenExpiresIn", Integer.toString(refreshTokenExpiresIn));

            br.close();
            bw.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return tokenMap;
    }

    public HashMap<String, String> getProperty(String accessToken){
        HashMap<String, String> userProperty = new HashMap<>();
        String reqUrl = "https://kapi.kakao.com/v2/user/me";
        try{
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Authorization","Bearer " + accessToken);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while((line = br.readLine()) != null){
                result += line;
            }
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonElement kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
            String email = kakaoAccount.getAsJsonObject().get("email").getAsString();
            String birth = kakaoAccount.getAsJsonObject().get("birthday").getAsString();
            String gender = kakaoAccount.getAsJsonObject().get("gender").getAsString();
            userProperty.put("email",email);
            userProperty.put("birth",birth);
            userProperty.put("gender",gender);

            return userProperty;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


}
