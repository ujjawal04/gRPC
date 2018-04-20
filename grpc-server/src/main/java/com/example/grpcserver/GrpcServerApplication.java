package com.example.grpcserver;

import com.example.grpcserver.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServerApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8081).addService(new UserService()).build();

        server.start();
        server.awaitTermination();
    }
}
