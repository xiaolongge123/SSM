package com.itheima.ssm.domain;


import com.itheima.ssm.utis.DateUtis;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Product {
    private String id;// id无意义
    private String productNum;//订单编号
    private String productName;//订单名称
    private String cityName;//城市名称
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date DepartureTime;//出发时间
    private String DepartureTimeStr;
    private Integer productPrice;//产品价格
    private String productDesc;//产品描述
    private Integer productStatus;//产品状态
    private String productStatusStr; //0 关闭 1 开启

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        DateUtis dateUtis = new DateUtis();
        String string = dateUtis.dateToString (DepartureTime,"yyyy-MM-dd HH:mm:ss");
        return string;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        DepartureTimeStr = departureTimeStr;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus==0||productStatus==1){
            if (productStatus==0){
                return "关闭";
            }else {
                return "开启";
            }
        }
        return null;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
