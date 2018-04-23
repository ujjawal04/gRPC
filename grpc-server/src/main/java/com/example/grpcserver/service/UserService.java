package com.example.grpcserver.service;

import com.example.grpcserver.UserCreateRequest;
import com.example.grpcserver.UserCreateResponse;
import com.example.grpcserver.UserGrpc;
import com.example.grpcserver.model.User;
import io.grpc.stub.StreamObserver;

public class UserService extends UserGrpc.UserImplBase {
    @Override
    public void create(UserCreateRequest request, StreamObserver<UserCreateResponse> responseStreamObserver) {
        new User(request.getName(), request.getAge(), request.getAadhaar(), request.getSalary(), request.getIsDev(), request.getAddress());

        UserCreateResponse response = UserCreateResponse.newBuilder().setStatus("User Created Successfully!!!").build();

        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }
}
