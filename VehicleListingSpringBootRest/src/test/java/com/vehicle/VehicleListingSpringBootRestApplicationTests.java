package com.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.vehicle.controller.VehicleDataController;
import com.vehicle.model.VehicleData;
import com.vehicle.repo.VehicleDataRepo;
import com.vehicle.service.VehicleService;
 
@SpringBootTest
class VehicleListingSpringBootRestApplicationTests {
 
	@InjectMocks
	 private VehicleService service;

	@Mock
	private VehicleDataRepo repo;
	//service testing
	@Test
	final void setDataListTest() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("ma12");
		data.setColor("blue");
		data.setYear(2020);
		data.setPrice(150000);
		data.setkW(125);
		data.setMake("maruti");
		data.setModel("swift");
		when(repo.save(data)).thenReturn(data);
		assertEquals(data, service.setDataList(data));
	 
		assertEquals("ma12", data.getCode() );
		assertEquals("maruti", data.getMake());
		assertEquals("swift", data.getModel());
		assertEquals(125, data.getkW());
		assertEquals(2020, data.getYear());
		assertEquals("blue", data.getColor());
		assertEquals(150000, data.getPrice());
		System.out.println(data);
	}

	@Test
	final void getDataListTest() {

		List<VehicleData> vlist = new ArrayList<VehicleData>();
		VehicleData data = new VehicleData();
		data.setDealer_id(110);
		data.setCode("ma12");
		data.setMake("maruti");
		data.setModel("swift");
		data.setkW(125);
		data.setYear(2020);
		data.setColor("blue");
		data.setPrice(150000);
		vlist.add(data);

		when(repo.findAll()).thenReturn(Stream.of(data).collect(Collectors.toList()));
		assertEquals(vlist, service.getDataList());

	}
	
	@Test
	final void getDataListTests() {
		String make="maruti";
		List<VehicleData> vlist = new ArrayList<VehicleData>();
		VehicleData data = new VehicleData();
		data.setDealer_id(110);
		data.setCode("ma12");
		data.setMake("maruti");
		data.setModel("swift");
		data.setkW(125);
		data.setYear(2020);
		data.setColor("blue");
		data.setPrice(150000);
		vlist.add(data);

		when(repo.findByMake(make)).thenReturn(Stream.of(data).collect(Collectors.toList()));
		assertEquals(vlist, service.getDataList(make));
		 

	}

	 
	@Test
	final void getDataListModelTest() {
		String model="swift";
		List<VehicleData> vlist = new ArrayList<VehicleData>();
		VehicleData data = new VehicleData();
		data.setDealer_id(110);
		data.setCode("ma12");
		data.setMake("maruti");
		data.setModel("swift");
		data.setkW(125);
		data.setYear(2020);
		data.setColor("blue");
		data.setPrice(150000);
		vlist.add(data);

		when(repo.findByModel(model)).thenReturn(Stream.of(data).collect(Collectors.toList()));
		assertEquals(vlist, service.getDataListModel(model));
		 

	}
	
	@Test
	final void getDataListYearTests() {
		int year= 2020;
		List<VehicleData> vlist = new ArrayList<VehicleData>();
		VehicleData data = new VehicleData();
		data.setDealer_id(110);
		data.setCode("ma12");
		data.setMake("maruti");
		data.setModel("swift");
		data.setkW(125);
		data.setYear(2020);
		data.setColor("blue");
		data.setPrice(150000);
		vlist.add(data);

		when(repo.findByYear(year)).thenReturn(Stream.of(data).collect(Collectors.toList()));
		assertEquals(vlist, service.getDataListYear(year));
		 

	}
	
	@Test
	final void getDataListColorTests() {
		String color="blu";
		List<VehicleData> vlist = new ArrayList<VehicleData>();
		VehicleData data = new VehicleData();
		data.setDealer_id(110);
		data.setCode("ma12");
		data.setMake("maruti");
		data.setModel("swift");
		data.setkW(125);
		data.setYear(2020);
		data.setColor("blue");
		data.setPrice(150000);
		vlist.add(data);

		when(repo.findByColor(color)).thenReturn(Stream.of(data).collect(Collectors.toList()));
		assertEquals(vlist, service.getDataListColor(color));
		 System.out.println(vlist);

	}
//controller testing
	
	
}
