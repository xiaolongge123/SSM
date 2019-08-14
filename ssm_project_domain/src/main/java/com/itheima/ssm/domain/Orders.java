package com.itheima.ssm.domain;

public class Orders {

    private String id;//
    private String orderNum;// 订单编号 不为空 唯一
    private String orderTime;// 下单时间
    private Integer peopleCount;// 出行人数
    private String orderDesc;// 支付方式(0 支付宝 1 微信 2其它)
    private String payType;//订单状态(0 未支付 1 已支付)
    private Integer orderStatus;//订单状态(0 未支付 1 已支付)
    private String productId;// 产品id 外键
    private String memberId;// 会员(联系人）id 外键
}
