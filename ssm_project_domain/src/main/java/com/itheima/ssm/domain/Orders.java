package com.itheima.ssm.domain;

import com.itheima.ssm.utis.DateUtis;

import java.util.Date;

public class Orders {

    private String id;//
    private String orderNum;// 订单编号 不为空 唯一
    private Date orderTime;// 下单时间
    private String orderTimeStr;
    private Integer peopleCount;// 出行人数
    private String orderDesc;//订单描述(其它信息)
    private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private Integer orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private String productId;// 产品id 外键
    private String memberId;// 会员(联系人）id 外键
    private Product product;//订单信息

    public String getOrderTimeStr() {
        if (orderTime!=null){
            DateUtis dateUtis = new DateUtis ();
            orderTimeStr=dateUtis.dateToString (orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType!=null){
            if (payType==0){
                return "支付宝";
            }else if (payType==1){
                return "微信";
            }else if (payType==2){
                return "其它";
            }
        }
        return null;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if (orderStatus!=null){
            if (orderStatus==0){
                return "未支付";
            }
            if (orderStatus==1){
                return "已支付";
            }
        }

        return null;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
