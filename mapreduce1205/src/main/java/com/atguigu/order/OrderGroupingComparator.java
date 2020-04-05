package com.atguigu.order;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class OrderGroupingComparator extends WritableComparator {

	protected OrderGroupingComparator(){
		super(OrderBean.class, true);
	}
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		OrderBean abean=(OrderBean)a;
		OrderBean bbean=(OrderBean)b;

		int result=-1;
		if(abean.getOrder_id()==abean.getOrder_id()){
			result=0;
		}
		return result;
	}
}
