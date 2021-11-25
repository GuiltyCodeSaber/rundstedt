package com.rundstedt.treasurefilter.controller;

import com.rundstedt.treasurefilter.service.TreasureFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/treasureFilter")
public class TreasureFilterController {
    @Autowired
    TreasureFilterService service;

    /**
     * 分页请求所有的宝物数据
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
    @GetMapping("/getTreasure")
    @ResponseStatus(HttpStatus.OK)
    public String findTreasure(@RequestParam("status") String status,
                               @RequestParam("serverId") String serverId,
                               @RequestParam(value = "sortWay",required = false,defaultValue = "") String sortWay,
                               @RequestParam(value = "sortField",required = false,defaultValue = "") String sortField,
                               @RequestParam(value = "itemName",required = false,defaultValue = "") String itemName,
                               @RequestParam(value = "bwa1",required = false,defaultValue = "") String bwa1,
                               @RequestParam(value = "bwa2",required = false,defaultValue = "") String bwa2,
                               @RequestParam(value = "bwa3",required = false,defaultValue = "") String bwa3,
                               @RequestParam(value = "bwa4",required = false,defaultValue = "") String bwa4,
                               @RequestParam(value = "bwa5",required = false,defaultValue = "") String bwa5,
                               @RequestParam(value = "bwa6",required = false,defaultValue = "") String bwa6,
                               @RequestParam(value = "pageIndex",required = false,defaultValue = "") String pageIndex){
        return service.findAll(status, serverId, sortWay, sortField, itemName, bwa1, bwa2, bwa3, bwa4, bwa5, bwa6, pageIndex);
    }

    /**
     * 获取服务器列表
     * @return
     */
    @GetMapping("/getServerList")
    @ResponseStatus(HttpStatus.OK)
    public String getServerList(){
        return service.getServerList();
    }

    /**
     * 获取宝物的关注数量
     * @param serverId
     * @param itemIds
     * @return
     */
    @GetMapping("/getFollowCount")
    @ResponseStatus(HttpStatus.OK)
    public String getFollowCount(@RequestParam("serverId") String serverId,
                                 @RequestParam("itemIds") String itemIds){
        return service.getFollowCount(serverId, itemIds);
    }

    /**
     * 获取一个宝物的信息
     * @param serverId
     * @param itemId
     * @return
     */
    @GetMapping("/getTradeItem")
    @ResponseStatus(HttpStatus.OK)
    public String getTradeItem(@RequestParam("serverId") String serverId,
                               @RequestParam("itemId") String itemId){
        return service.getTradeItem(serverId, itemId);
    }
}
