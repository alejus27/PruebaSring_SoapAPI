package com.prueba_soap.endpoints;
import java.util.ArrayList;


import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.prueba_soap.interfaces.*;
import com.prueba_soap.models.User;
import com.prueba_soap.services.UserService;



@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@Autowired
	private UserService userService;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
	@ResponsePayload
	public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
		AddUserResponse response = new AddUserResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		User user = new User();
		BeanUtils.copyProperties(request.getUserInfo(), user);
		userService.addUser(user);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserByIdRequest request) {
		GetUserResponse response = new GetUserResponse();
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(userService.getUserById(request.getUserId()), userInfo);
		response.setUserInfo(userInfo);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
	@ResponsePayload
	public GetAllUsersResponse getAllUsers() {
		GetAllUsersResponse response = new GetAllUsersResponse();
		List<UserInfo> articleInfoList = new ArrayList<>();
		List<User> articleList = userService.getAllUsers();
		for (int i = 0; i < articleList.size(); i++) {
		     UserInfo ob = new UserInfo();
		     BeanUtils.copyProperties(articleList.get(i), ob);
		     articleInfoList.add(ob);    
		}
		response.getUserInfo().addAll(articleInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
	@ResponsePayload
	public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
		User user = new User();
		BeanUtils.copyProperties(request.getUserInfo(), user);
		userService.updateUser(user);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateUserResponse response = new UpdateUserResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
	@ResponsePayload
	public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
		userService.deleteUser(request.getUserId());
		ServiceStatus serviceStatus = new ServiceStatus();

		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Deleted Successfully");
		DeleteUserResponse response = new DeleteUserResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

}