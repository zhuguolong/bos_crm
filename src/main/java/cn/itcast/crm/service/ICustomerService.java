package cn.itcast.crm.service;

import java.util.List;

import javax.jws.WebService;

import cn.itcast.crm.entity.Customer;

@WebService
public interface ICustomerService {

    /**
     * 查询所有客户信息
     * @Description TODO
     * @return
     */
    public List<Customer> findAll();
    
    /**
     * 查询定区id为null的客户
     * @Description TODO
     * @return
     */
    public List<Customer> findByFixedAreaIdIsNull();
    
    /**
     * 根据定区id查询客户记录
     * @Description TODO
     * @param fixedAreaId
     * @return
     */
    public List<Customer> findByFixedAreaId(String fixedAreaId);
    
    /**
     * 客户关联定区
     * @Description TODO
     * @param customerId
     * @param fixedAreaId
     */
    public void setCustomerFixedAreaId(String[] customerId, String fixedAreaId);
    
    /**
     * 注册客户
     * @Description TODO
     * @param customer
     */
    public void regist(Customer customer);
    
    /**
     * 根据客户电话获取客户信息
     * @Description TODO
     * @param telephone
     * @return
     */
    public Customer findByTelephone(String telephone);
    
    /**
     * 激活账户使 type = 1，将客户正确的邮箱跟账户绑定
     * @Description TODO
     * @param id
     */
    public void bind(Integer id);
    
    /**
     * 用户登录时，同过用户输入的用户名和密码查询用户信息
     * @Description TODO
     * @param username
     * @param password
     * @return
     */
    public Customer findByUsernameAndPassword(String username, String password);
    
    /**
     * 根据地址查询定区id
     * @Description TODO
     * @param address
     * @return
     */
    public String findFixedAreaIdByAddress(String address);
}
