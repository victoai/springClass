package com.sh.order.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sh.order.domain.OrderDTO;
import com.sh.product.domain.ProductDTO;
import com.sh.saveUser.domain.UserDTO;

@Repository
public class OrderRepositoryRealImp implements OrderRepositoryI {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.sh.order.OrderMapper.";

	@Override
	public int insert(OrderDTO orderDTO) {

		return session.insert(namespace + "insertOrder", orderDTO);
	}
	
	@Override
	public List<OrderDTO> getOrdersByUserCode(String user_id) {
		return session.selectList(namespace + "selectAll", user_id);
	}

}
