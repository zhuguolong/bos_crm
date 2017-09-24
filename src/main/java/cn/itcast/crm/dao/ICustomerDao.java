package cn.itcast.crm.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.crm.entity.Customer;


public interface ICustomerDao extends JpaRepository<Customer, Integer> {

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
     * 将要关联到某个定区的客户的定区id设置为null
     * @Description TODO
     * @param fixedAreaId
     */
    @Modifying
    @Query("update Customer set fixedAreaId = null where fixedAreaId = ?")
    public void setCustomerFixedAreaToNull(String fixedAreaId);

    /**
     * 将客户关联到当前选中的定区
     * @Description TODO
     * @param fixedAreaId
     * @param parseInt
     */
    @Modifying
    @Query("update Customer set fixedAreaId = ? where id = ?")
    public void setFixedAreaIdToCustomer(String fixedAreaId, int parseInt);

    /**
     * 根据手机号查询客户信息
     * @Description TODO
     * @param telephone
     * @return
     */
    public Customer findByTelephone(String telephone);

    /**
     * 根据客户电话查询客户信息
     * @Description TODO
     * @param id
     */
    @Modifying
    @Query("update Customer set type = 1 where id = ?")
    public void bind(Integer id);

    /**
     * 根据用户登录时输入的用户名和密码查询用户的信息
     * @Description TODO
     * @param username
     * @param password
     * @return
     */
    public Customer findByUsernameAndPassword(String username, String password);

    /**
     * 分局地址查询定区id
     * @Description TODO
     * @param address
     * @return
     */
    @Query("select fixedAreaId from Customer where address = ?")
    public String findFixedAreaIdByAddress(String address);
}
