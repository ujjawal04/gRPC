package service;

import com.example.grpcserver.UserCreateRequest;
import com.example.grpcserver.UserCreateResponse;
import com.example.grpcserver.UserGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcService {
    public void connect() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        UserGrpc.UserBlockingStub stub = UserGrpc.newBlockingStub(channel);

        UserCreateRequest request = UserCreateRequest.newBuilder()
                .setName("Ashish")
                .setAge(21)
                .build();

        try {
            UserCreateResponse response = stub.create(request);

        } finally {
            channel.shutdown();
        }
    }
}
