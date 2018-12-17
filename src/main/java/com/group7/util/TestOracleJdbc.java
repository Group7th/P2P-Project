package com.group7.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * className:TestOracleJdbc
 * discriptoin:
 * author:毛宇
 * createTime:2018-12-15 15:08
 */
public class TestOracleJdbc {

	public static void main(String[] args) {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//创建连接
			connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.22.63:1521:orcl","group7","admin");
			//开启手动提交事务
			connection.setAutoCommit(false);
			//获取语句执行对象
			preparedStatement = connection.prepareStatement("insert into users(userid,username,age,city) values (?,?,?,?)");
			//数组
			String[] citys ={"郑州","洛阳","开封","商丘","周口","平顶山","漯河","许昌","南阳","信阳"};
			for(int i = 1;i<=1000000;i++){
				preparedStatement.setInt(1,i);
				preparedStatement.setString(2,"user"+i);
				preparedStatement.setInt(3,(int)(Math.random()*100+1));
				preparedStatement.setString(4,citys[(int)(Math.random()*10)]);
				preparedStatement.addBatch();//把语句缓冲到preparedStatement
				if(i%1000==0){
					preparedStatement.executeBatch();//批量执行
					connection.commit();//提交事务
					preparedStatement.clearBatch();//清除缓冲语句
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null){
					preparedStatement.close();
				}
				if(connection!=null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
