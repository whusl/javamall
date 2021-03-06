package com.enation.app.flashbuy.core.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enation.app.flashbuy.core.model.FlashBuy;
import com.enation.framework.database.Page;
/**
 * 
 * @ClassName: IFlashBuyManager 
 * @Description: 限时抢购商品管理类 
 * @author TALON 
 * @date 2015-7-31 上午1:51:19 
 *
 */
public interface IFlashBuyManager {
	/**
	 * 创建限时抢购
	 * @param flashBuy
	 * @return 创建成功返回创建的限时抢购id
	 *         创建失败返回0
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int add(FlashBuy flashBuy);
	/**
	 * 修改限时抢购信息
	 * @param flashBuy
	 * @return 创建成功返回创建的限时抢购id
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(FlashBuy flashBuy);
	
	/**
	 * 删除限时抢购
	 * @param gbid 限时抢购id
	 */
	public void delete(int gbid);
	
	public void deleteByGoodsId(int goodsId);

	/**
	 * 审核
	 * @param gbid 限时抢购id
	 * @param status 状态
	 */
	public void auth(int gbid,int status);
	

	/**
	 * 查询某活动下的限时抢购
	 * @param page 页码
	 * @param pageSize 分页每页显示数量
	 * @param actid 活动id
	 * @param status 状态
	 * @return 限时抢购分页列表
	 */
	public Page listByActId(int page ,int pageSize,int actid,Integer status);
	
	/**
	 * 前台显示限时抢购
	 * @param page 页数
	 * @param pageSize 每页显示数量
	 * @param catid 分类Id
	 * @param minprice 最小金额
	 * @param maxprice 最大金额
	 * @param sort_key 排序类型
	 * @param sort_type 正序还是倒叙
	 * @param search_type 搜索类型
	 * @param area_id 限时抢购地区Id
	 * @return 限时抢购分页列表
	 */
	public Page search(int page,int pageSize,Integer catid,Double minprice,Double maxprice,Integer sort_key,Integer sort_type,Integer search_type,Integer area_id);
	/**
	 * 获取某个限时抢购信息
	 * @param gbid 限时抢购id
	 * @return FlashBuy 限时抢购商品
	 */
	public FlashBuy get(int gbid);
	
	/**
	 * 根据商品Id获取限时抢购商品
	 * @param goodsId 商品ID
	 * @return FlashBuy 限时抢购商品
	 */
	public FlashBuy getBuyGoodsId(int goodsId);
}
