package com.rundstedt.rolefilter.controller;

import com.rundstedt.rolefilter.resultEntity.RoleContent;
import com.rundstedt.rolefilter.resultEntity.RoleInfo;
import com.rundstedt.rolefilter.resultEntity.ServerResult;
import com.rundstedt.rolefilter.service.RoleFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/roleFilter")
public class RoleFilterController {
    @Autowired
    private RoleFilterService service;

    /**
     * 根据名字查询
     * @param name
     * @param serverId
     * @return
     */
    @GetMapping(value="/requestByName")
    @ResponseStatus(HttpStatus.OK)
    public List<RoleInfo> findRolesByName(@RequestParam(value = "name") String name,
                                          @RequestParam(value = "serverId") String serverId){
        return service.findRolesByName(name,serverId);
    }

    /**
     * 根据Id查询
     * @param id
     * @param serverId
     * @return
     */
    @GetMapping(value="/requestById")
    @ResponseStatus(HttpStatus.OK)
    public List<RoleInfo> findRolesById(@RequestParam(value = "id") String id,
                                    @RequestParam(value = "serverId") String serverId){
        return service.findRolesById(id, serverId);
    }

    /**
     * 获取角色具体信息
     * @param serverId
     * @param itemId
     * @return
     */
    @GetMapping(value="/getRoleContent")
    @ResponseStatus(HttpStatus.OK)
    public RoleContent getRoleContent(@RequestParam(value = "serverId") String serverId,
                                      @RequestParam(value = "itemId") String itemId ){
        return service.getRoleContent(serverId,itemId);
    }

    /**
     * 获取大区服务器列表
     * @return
     */
    @GetMapping(value="/serverList")
    @ResponseStatus(HttpStatus.OK)
    public List<ServerResult> findServerList(){
        return service.findServerList();
    }

    /**
     * 根据宝物查询
     * @param bwa1
     * @param bwa2
     * @param bwa3
     * @param bwa4
     * @param bwa5
     * @param wuxue
     * @param is750
     * @param serverId
     * @return
     */
    @GetMapping(value="/byTreasure")
    public List findByTreasure(@RequestParam(value = "bwa1",required = false,defaultValue = "") String bwa1,
                                 @RequestParam(value = "bwa2",required = false,defaultValue = "") String bwa2,
                                 @RequestParam(value = "bwa3",required = false,defaultValue = "") String bwa3,
                                 @RequestParam(value = "bwa4",required = false,defaultValue = "") String bwa4,
                                 @RequestParam(value = "bwa5",required = false,defaultValue = "") String bwa5,
                                 @RequestParam(value = "wuxue",required = false,defaultValue = "") String wuxue,
                                 @RequestParam(value = "is750",required = false,defaultValue = "false") String is750,
                                 @RequestParam(value = "serverId",required = false,defaultValue = "") String serverId){
        return service.findByTreasure(bwa1, bwa2, bwa3, bwa4, bwa5, wuxue, is750, serverId);
    }

    /**
     * 根据三技能查询
     * @param wx1
     * @param ts1
     * @param wx2
     * @param ts2
     * @param wx3
     * @param ts3
     * @param wx4
     * @param ts4
     * @param wx5
     * @param ts5
     * @param serverId
     * @return
     */
    @GetMapping(value="/byThreeSkills")
    public List findByThreeSkills(@RequestParam(value = "wx1",required = false,defaultValue = "") String wx1,
                                    @RequestParam(value = "ts1",required = false,defaultValue = "") String ts1,
                                    @RequestParam(value = "wx2",required = false,defaultValue = "") String wx2,
                                    @RequestParam(value = "ts2",required = false,defaultValue = "") String ts2,
                                    @RequestParam(value = "wx3",required = false,defaultValue = "") String wx3,
                                    @RequestParam(value = "ts3",required = false,defaultValue = "") String ts3,
                                    @RequestParam(value = "wx4",required = false,defaultValue = "") String wx4,
                                    @RequestParam(value = "ts4",required = false,defaultValue = "") String ts4,
                                    @RequestParam(value = "wx5",required = false,defaultValue = "") String wx5,
                                    @RequestParam(value = "ts5",required = false,defaultValue = "") String ts5,
                                    @RequestParam(value = "serverId",required = false,defaultValue = "") String serverId){
        return service.findByThreeSkills(wx1, ts1, wx2, ts2, wx3, ts3, wx4, ts4, wx5, ts5, serverId);
    }

    /**
     * 根据风物志查询
     * @param skin1
     * @param skin2
     * @param skin3
     * @param skin4
     * @param skin5
     * @param serverId
     * @return
     */
    @GetMapping(value="/bySkin")
    public List findBySkin(@RequestParam(value = "skin1",required = false,defaultValue = "") String skin1,
                           @RequestParam(value = "skin2",required = false,defaultValue = "") String skin2,
                           @RequestParam(value = "skin3",required = false,defaultValue = "") String skin3,
                           @RequestParam(value = "skin4",required = false,defaultValue = "") String skin4,
                           @RequestParam(value = "skin5",required = false,defaultValue = "") String skin5,
                           @RequestParam(value = "serverId",required = false,defaultValue = "") String serverId){
        return service.findBySkin(skin1, skin2, skin3, skin4, skin5, serverId);
    }

    /**
     * 获取爬虫数据更新时间
     * @return
     */
    @GetMapping(value="/updateTime")
    public Map getUpdateTime(){
        return service.getUpdateTime();
    }
}
