package com.jalja.org.springmvc.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jalja.org.springmvc.mapper.JaljaUserMapper;
import com.jalja.org.springmvc.model.JaljaUser;
import com.jalja.org.springmvc.model.JaljaUserExample;
import com.jalja.org.springmvc.model.vo.PageVO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class JaljaUserService  {
	private static Logger logger = LogManager.getLogger(JaljaUserService.class);
    @Autowired
    private JaljaUserMapper jaljaUserMapper;
    @Autowired
    private TransportClient transportClient;
    
    public PageInfo<JaljaUser> getJaljaUsers(Integer pageNum,Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        JaljaUserExample example=new JaljaUserExample();
        JaljaUserExample.Criteria criteria=example.createCriteria();
        List<JaljaUser>lists= jaljaUserMapper.selectByExample(example);
        PageInfo<JaljaUser> pageInfo = new PageInfo<JaljaUser>(lists);
        return pageInfo;
    }
	private  void getEmployee() throws Exception {
		GetResponse response = transportClient.prepareGet("car_index", "car_type", "1").get();
		logger.info(response.getSourceAsString()); 
	}
	
    
    @Transactional
    public boolean addUser(){
    	 
    	return true;
    }
    
    
	public PageVO<JSONObject> getSearch(String search, Integer pageNum, Integer pageSize) {	
		Integer form=pageNum==1?0:(pageNum-1)*pageSize;
		
		SearchRequestBuilder searchRequestBuilder=transportClient.prepareSearch("car_index").setTypes("car_type");
		if(search!=null && !search.equals("")) {
			QueryBuilder postFilter1= QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", search))
					.should(QueryBuilders.matchQuery("short_name", search)); 
			searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
			searchRequestBuilder.setQuery(postFilter1);
		}
		SearchResponse response = searchRequestBuilder.setFrom(form).setSize(pageSize).setExplain(true).get();
		SearchHit[] sh= response.getHits().getHits();
		if (sh ==null ||sh.length<=0 ) {
			return null;
		}
		List<JSONObject> list=new ArrayList<JSONObject>();
		for(SearchHit hit:sh) {
			JSONObject obj=JSONObject.parseObject(hit.getSourceAsString());
			obj.put("id",hit.getId());
			list.add(obj);
		}
		PageVO<JSONObject> pageVO=new PageVO(pageNum,pageSize,response.getHits().getTotalHits(),list);
		return pageVO;
	}
	public Object getDetails(Long id) {
		if(id==null) {
			return null;
		}
		GetResponse response = transportClient.prepareGet("car_index", "car_type", String.valueOf(id)).get();
		JSONObject object=JSONObject.parseObject(response.getSourceAsString());
		return object;
	}
}
