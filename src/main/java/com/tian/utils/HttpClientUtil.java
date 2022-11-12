package com.tian.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月12日 07:52
 */
@Slf4j
public class HttpClientUtil {

    public static URI buildQueryMessage(String url, Map<String, Object> paramMap) {
        String param = URLEncodedUtils.format(setHttpParams(paramMap), StandardCharsets.UTF_8);
        return URI.create(url + "?" + param);
    }

    public static String doGet(String url) throws IOException {
        return doGet(url, null);
    }

    public static String doGet(String url, Map<String, Object> paramMap) throws IOException {
        log.info("doGet url=" + url);
        HttpGet httpGet = new HttpGet();
        return doRequest(httpGet, url, paramMap);
    }

    public static String doDelete(String url) throws IOException {
        return doDelete(url, null);
    }

    public static String doDelete(String url, Map<String, Object> paramMap) throws IOException {
        log.info("doDelete url=" + url);
        HttpDelete httpDelete = new HttpDelete();
        return doRequest(httpDelete, url, paramMap);
    }

    public static String doPut(String url) throws IOException {
        return doPut(url, null);
    }

    public static String doPut(String url, Map<String, Object> paramMap) throws IOException {
        log.info("doPut url=" + url);
        HttpPut httpPut = new HttpPut();
        return doRequest(httpPut, url, paramMap);
    }

    public static String doPost(String url) throws Exception {
        return doPost(url, null, null);
    }

    public static String doPost(String url, Map<String, Object> paramMap) throws Exception {
        return doPost(url, paramMap, null);
    }

    public static String doPost(String url, Map<String, Object> paramMap, Map<String, String> headerMap) throws Exception {
        log.info("doPost url=" + url);
        HttpPost httpPost = new HttpPost(url);

        if (headerMap == null){
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        } else {
            for (String key : headerMap.keySet()) {
                httpPost.addHeader(key, headerMap.get(key));
            }
        }

        if (null != paramMap && paramMap.size() > 0) {
            List<NameValuePair> nameValPair = setHttpParams(paramMap);
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValPair, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new Exception("Failed to set request parameters {}" + e.getMessage() + e);
            }
        }

        return executeHttp(httpPost);
    }

    public static String doPostJson(String url, String jsonStr) throws IOException {
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        StringEntity entity = new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);

        return executeHttp(httpPost);
    }

    public static String doPostXml(String url, String xmlContent) throws IOException {
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/xml;charset=utf-8");
        StringEntity entity = new StringEntity(xmlContent, ContentType.APPLICATION_XML);
        httpPost.setEntity(entity);

        return executeHttp(httpPost);
    }

    private static List<NameValuePair> setHttpParams(Map<String, Object> paramMap) {
        List<NameValuePair> nameValPair = new ArrayList<>();
        for (Map.Entry<String, Object> mapEntry : paramMap.entrySet()) {
            nameValPair.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
        }
        return nameValPair;
    }

    private static String doRequest(HttpRequestBase httpBase, String url, Map<String, Object> paramMap) throws IOException {
        if (paramMap == null) {
            httpBase.setURI(URI.create(url));
        } else {
            httpBase.setURI(buildQueryMessage(url, paramMap));
        }
        return executeHttp(httpBase);
    }

    private static String executeHttp(HttpRequestBase httpBase) throws IOException {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(60000).build();
        httpBase.setConfig(requestConfig);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        String result;
        try {
            httpResponse = httpClient.execute(httpBase);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
            httpBase.abort();
        } catch (IOException e) {
            throw new IOException("Failed to execute request or get response " + e.getMessage() + e);
        } finally {
            closeHttpClientAndResp(httpClient, httpResponse);
        }
        return result;
    }

    private static void closeHttpClientAndResp(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
        if (null != httpResponse) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                log.error("Failed to close httpResponse {}", e.getLocalizedMessage(), e);
            }
        }
        if (null != httpClient) {
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error("Failed to close httpClient {}", e.getLocalizedMessage(), e);
            }
        }
    }

}

