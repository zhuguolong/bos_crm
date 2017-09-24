package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ICustomerDao;
import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.service.ICustomerService;

//@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public List<Customer> findByFixedAreaIdIsNull() {
        return customerDao.findByFixedAreaIdIsNull();
    }

    @Override
    public List<Customer> findByFixedAreaId(String fixedAreaId) {
        return customerDao.findByFixedAreaId(fixedAreaId);
    }

    @Override
    public void setCustomerFixedAreaId(String[] customerId, String fixedAreaId) {
        /**
         * 将要关联到选中定区 的客户的定区id设置为null
         */
        customerDao.setCustomerFixedAreaToNull(fixedAreaId);
        
        /**
         * 将客户关联到当前选中的定区
         */
        if(customerId != null){
            for(String custId : customerId){
                customerDao.setFixedAreaIdToCustomer(fixedAreaId, Integer.parseInt(custId));
            }
        }
    }

    /**
     * 保存客户记录
     */
    @Override
    public void regist(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public Customer findByTelephone(String telephone) {
        return customerDao.findByTelephone(telephone);
    }

    @Override
    public void bind(Integer id) {
        customerDao.bind(id);
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return customerDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public String findFixedAreaIdByAddress(String address) {
        return customerDao.findFixedAreaIdByAddress(address);
    }
}
