package com.cisco.la.join;

import java.util.List;

import com.cisco.la.entity.GoldenSampleJoin;
import com.cisco.la.model.GoldenSampleModel;

public interface GoldenSampleJoinMapper {
	List<GoldenSampleJoin> getGoldenSampleJoin();
	
	GoldenSampleModel getGoldenSampleByName(String goldenSampleName);
}