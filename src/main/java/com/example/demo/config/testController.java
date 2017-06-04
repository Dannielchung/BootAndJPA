/*
package com.example.demo.config;


import com.seewo.core.base.DataMap;
import com.seewo.core.util.date.DateUtils;
import com.seewo.school.service.CommentService;
import com.seewo.school.util.Constants;
import com.seewo.school.util.ReturnMessage;
import com.seewo.school.util.StatusCode;
import com.seewo.school.util.page.Page;
import com.seewo.school.vo.query.CommentQuery;
import com.seewo.school.vo.stat.DailyCountVo;
import com.seewo.school.vo.stat.KeyValueRankVo;
import com.seewo.school.vo.stat.RatioVo;
import com.seewo.school.vo.stat.TotalCountVo;
import com.seewo.school.web.annotation.CurrentUser;
import com.seewo.school.web.annotation.Permission;
import com.seewo.school.web.annotation.RequiredPermission;
import com.seewo.uc.api.dto.user.UserResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Author ： luojianming
 * Modify : Martin
 * Date : 17/5/10
 * Description : 数据简报
 * Version : 2.0
 *//*

@Controller
@RestController
@RequestMapping("/")
public class DataBriefController {
    private static final int DAY_STEP = 1;
    private static final long ONE_DAY_SECONDS = 86400000L;
    private static final String DEFAULT_PAGE = "1";
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String PAGE = "page";
    private static final String PAGE_SIZE = "pageSize";
    private static final String COMMENT_TYPE = "commentType";
    private static final String X_AUTH_TOKEN = "x-auth-token";
    private final CommentService commentService;




    */
/**
     * 班级点评数据简报
     *//*

    @RequestMapping(value = "/comment/v1", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.DATA_VIEW)
    public DataMap sumDailyBetween(@CurrentUser UserResultDto user, long start, long end) throws ParseException {
        Date startDate = DateUtils.formatDate(new Date(start), DateUtils.PATTREN_DATE);
        Date endDate = DateUtils.formatDate(new Date(end), DateUtils.PATTREN_DATE);
        int days = (int) ((endDate.getTime() - startDate.getTime()) / ONE_DAY_SECONDS + DAY_STEP);
        DailyCountVo result = commentService.sumDailyBetween(user.getUnitId(), startDate, endDate, days);
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 学校全部点评数据统计，以点评类型分组
     *//*

    @RequestMapping(value = "/comment/v1/total", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.DATA_VIEW)
    public DataMap sumTotalGroupBySubject(@CurrentUser UserResultDto user) throws IOException {
        TotalCountVo result = commentService.sumTotalGroupByType(user.getUnitId());
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 以年级分组统计点评分数
     *//*

    @RequestMapping(value = "/comment/v1/grade", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.CLASS_VIEW)
    public DataMap sumBetweenDateGroupByGrade(@CurrentUser UserResultDto user, long start, long end) throws ParseException {
        Date startDate = DateUtils.formatDate(new Date(start), DateUtils.PATTREN_DATE);
        Date endDate = DateUtils.formatDate(new Date(end), DateUtils.PATTREN_DATE);
        Map result = commentService.sumBetweenDateGroupByGrade(user.getUnitId(), startDate, endDate);
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 根据年级查询top3班级
     *//*

    @RequestMapping(value = "/comment/v1/grade/top", method = RequestMethod.GET)
    @RequiredPermission(permission = {Permission.CLASS_VIEW, Permission.DATA_VIEW})
    public DataMap sumBetweenDateGroupByGrade(@CurrentUser UserResultDto user, int grade, long start, long end) throws ParseException {
        Date startDate = DateUtils.formatDate(new Date(start), DateUtils.PATTREN_DATE);
        Date endDate = DateUtils.formatDate(new Date(end), DateUtils.PATTREN_DATE);
        List<KeyValueRankVo> result = commentService.sumGradeBetweenDateGroupByClass(user.getUnitId(), grade, startDate, endDate);
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 点评总分班级排行
     *//*

    @RequestMapping(value = "/comment/v1/class/total", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.CLASS_VIEW)
    public DataMap sumTotalGroupByClass(@CurrentUser UserResultDto user,
                                        @RequestHeader(value = X_AUTH_TOKEN) String token,
                                        @RequestParam(value = PAGE, defaultValue = DEFAULT_PAGE) Integer page,
                                        @RequestParam(value = PAGE_SIZE, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
                                        CommentQuery commentQuery) throws IOException {
        commentQuery.setClassUnitUid(user.getUnitId());
        Page result = commentService.sumTotalGroupByClass(commentQuery, page, pageSize, token);
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 点评总分教师排行
     *//*

    @RequestMapping(value = "/comment/v1/teacher/total", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.CLASS_VIEW)
    public DataMap sumTotalGroupByTeacher(@CurrentUser UserResultDto user,
                                          @RequestParam(value = PAGE, defaultValue = DEFAULT_PAGE) Integer page,
                                          @RequestParam(value = PAGE_SIZE, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
                                          CommentQuery commentQuery) throws IOException {
        commentQuery.setClassUnitUid(user.getUnitId());
        commentQuery.setUnitUid(user.getUnitId());
        Page result = commentService.sumTotalGroupByTeacher(commentQuery, page, pageSize);
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 点评类型排行榜
     *//*

    @RequestMapping(value = "/comment/v1/type/total", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.CLASS_VIEW)
    public DataMap sumTotalGroupByTeacher(@CurrentUser UserResultDto user,
                                          @RequestParam(value = COMMENT_TYPE) Integer commentType,
                                          @RequestParam(value = PAGE, defaultValue = DEFAULT_PAGE) Integer page,
                                          @RequestParam(value = PAGE_SIZE, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) throws IOException {
        List<RatioVo> result = commentService.sumTotalGroupByCommentName(user.getUnitId(), commentType, page, pageSize);
        return ReturnMessage.create().data(result).toMap();
    }

    */
/**
     * 当月份班级排行
     *//*

    @RequestMapping(value = "/comment/v1/class/month", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.CLASS_VIEW)
    public DataMap sumMonthGroupByClass(@CurrentUser UserResultDto user,
                                        @RequestParam(value = PAGE, defaultValue = DEFAULT_PAGE) Integer page,
                                        @RequestParam(value = PAGE_SIZE, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
                                        CommentQuery commentQuery) throws ParseException {
        commentQuery.setClassUnitUid(user.getUnitId());
        commentQuery.setUnitUid(user.getUnitId());
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.MONTH, DateUtils.getCurrentMonth());
        map.put(Constants.PAGE, commentService.sumMonthGroupByClass(commentQuery, page, pageSize));
        return ReturnMessage.create().data(map).toMap();
    }

    */
/**
     * 月份班级前N名排行榜
     *//*

    @RequestMapping(value = "/comment/v1/class/month/top", method = RequestMethod.GET)
    @RequiredPermission(permission = Permission.CLASS_VIEW)
    public DataMap sumMonthGroupByClass(@CurrentUser UserResultDto user) throws ParseException {
        DataMap dataMap = new DataMap();
        dataMap.addAttribute(Constants.MONTH, DateUtils.getCurrentMonth());
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.MONTH, DateUtils.getCurrentMonth());
        map.put(Constants.PAGE, commentService.sumMonthGroupByClass(user.getUnitId(), 10));
        dataMap.addAttribute(Constants.DATA, map);
        dataMap.addAttribute(Constants.STATUS_CODE, StatusCode.SUCCESS.getStatusCode());
        return dataMap;
    }

    @Autowired
    public DataBriefController(CommentService commentService) {
        this.commentService = commentService;
    }
}*/
