package com.rundstedt.treasurefilter.service;

import com.rundstedt.util.GenHttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TreasureFilterService {
    @Autowired
    private GenHttpHeader genHttpHeader;

    private String woniuJishiUrl = "http://jishi.woniu.com/9yin";

    /**
     * 从蜗牛集市服务器分页请求所有的宝物数据
     * @param status
     * @param serverId
     * @param sortWay
     * @param sortField
     * @param itemName
     * @param bwa1
     * @param bwa2
     * @param bwa3
     * @param bwa4
     * @param bwa5
     * @param bwa6
     * @param pageIndex
     * @return
     */
    public String findAll(String status,
                            String serverId,
                            String sortWay,
                            String sortField,
                            String itemName,
                            String bwa1,
                            String bwa2,
                            String bwa3,
                            String bwa4,
                            String bwa5,
                            String bwa6,
                            String pageIndex){
        RestTemplate restTemplate=new RestTemplate(); //创建请求
        Map<String,String> params=new HashMap<>(); //创建参数表
        params.put("serverId",serverId);
        params.put("typeNameParam","146");
        params.put("gameId","10");
        long timestamp = new Date().getTime(); //13位的时间戳
        params.put("_",Long.toString(timestamp));
        String urlPageIndex, urlSortWay, urlSortField, urlItemName,bwa;
        if(sortWay==""){
            urlSortWay = "";
        }
        else {
            urlSortWay = "&sortWay={sortWay}";
            params.put("sortWay",sortWay);
        }
        if(sortField==""){
            urlSortField = "";
        }
        else {
            urlSortField = "&sortField={sortField}";
            params.put("sortField",sortField);
        }
        if(itemName==""){
            urlItemName = "";
        }
        else {
            urlItemName = "&itemName={itemName}";
            params.put("itemName",itemName);
        }
        if(pageIndex==""){
            urlPageIndex = "";
        }
        else {
            urlPageIndex = "&pageIndex={pageIndex}";
            params.put("pageIndex",pageIndex);
        }
        if(bwa1==""){
            bwa = "";
        }
        else{
            bwa = "&bwa1={bwa1}";
            params.put("bwa1",bwa1);
            if(bwa2!=""){
                bwa += "&bwa2={bwa2}";
                params.put("bwa2",bwa2);
                if(bwa3!=""){
                    bwa += "&bwa3={bwa3}";
                    params.put("bwa3",bwa3);
                    if(bwa4!=""){
                        bwa += "&bwa4={bwa4}";
                        params.put("bwa4",bwa4);
                        if(bwa5!=""){
                            bwa += "&bwa5={bwa5}";
                            params.put("bwa5",bwa5);
                            if(bwa6!=""){
                                bwa += "&bwa6={bwa6}";
                                params.put("bwa6",bwa6);
                            }
                        }
                    }
                }
            }
        }

        HttpHeaders headers = genHttpHeader.gen("anonymousPage"); //生成请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);//将header放入一个请求
        ResponseEntity<String> responseEntity=restTemplate.exchange(woniuJishiUrl +
                "/anonymous/find" + status +
                "Goods.do?serverId={serverId}&gameId={gameId}&typeNameParam={typeNameParam}" +
                urlSortWay + urlSortField + urlPageIndex + urlItemName + bwa + "&_={_}",
                HttpMethod.GET,requestEntity,String.class,params);
        return responseEntity.getBody();
    }

    /**
     * 从蜗牛集市服务器请求服务器列表
     * @return
     */
    public String getServerList(){
        RestTemplate restTemplate=new RestTemplate(); //创建请求
        Map<String,String> params=new HashMap<>(); //创建参数表
        params.put("gameId","10");
        long timestamp = new Date().getTime(); //13位的时间戳
        params.put("_",Long.toString(timestamp));

        HttpHeaders headers = genHttpHeader.gen("toServerList"); //生成请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);//将header放入一个请求
        ResponseEntity<String> responseEntity=restTemplate.exchange(woniuJishiUrl + "/loadServerList.do?gameId={gameId}&_={_}",
                HttpMethod.GET,requestEntity,String.class,params);
        return responseEntity.getBody();
    }

    /**
     * 从蜗牛集市服务器请求宝物的关注数量
     * @param serverId
     * @param itemIds
     * @return
     */
    public String getFollowCount(String serverId, String itemIds){
        RestTemplate restTemplate=new RestTemplate(); //创建请求
        Map<String,String> params=new HashMap<>(); //创建参数表
        params.put("serverId",serverId);
        params.put("gameId","10");
        params.put("itemIds",itemIds);
        long timestamp = new Date().getTime(); //13位的时间戳
        params.put("_",Long.toString(timestamp));

        HttpHeaders headers = genHttpHeader.gen("anonymousPage"); //生成请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);//将header放入一个请求
        ResponseEntity<String> responseEntity=restTemplate.exchange(woniuJishiUrl +
                "/anonymous/getItemsFollowCount.do?serverId={serverId}&gameId={gameId}&itemIds={itemIds}&_={_}",
                HttpMethod.GET,requestEntity,String.class,params);
        return responseEntity.getBody();
    }

    /**
     * 从蜗牛集市服务器请求一个宝物的信息
     * @param serverId
     * @param itemId
     * @return
     */
    public String getTradeItem(String serverId, String itemId){
        RestTemplate restTemplate=new RestTemplate(); //创建请求
        Map<String,String> params=new HashMap<>(); //创建参数表
        params.put("serverId",serverId);
        params.put("gameId","10");
        params.put("itemId",itemId);
        long timestamp = new Date().getTime(); //13位的时间戳
        params.put("_",Long.toString(timestamp));

        HttpHeaders headers = genHttpHeader.gen("anonymousPage"); //生成请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);//将header放入一个请求
        ResponseEntity<String> responseEntity=restTemplate.exchange(woniuJishiUrl +
                "/anonymous/getTradeItem.do?serverId={serverId}&gameId={gameId}&itemId={itemId}&_={_}",
                HttpMethod.GET,requestEntity,String.class,params);
        return responseEntity.getBody();
    }
}
