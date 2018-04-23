package service;

import com.example.grpcserver.UserCreateRequest;
import com.example.grpcserver.UserCreateResponse;
import com.example.grpcserver.UserGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcService {
    private ManagedChannel channel;
    private UserGrpc.UserBlockingStub stub;
    private UserCreateRequest request;

    public GrpcService() {
        this.channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        this.stub = UserGrpc.newBlockingStub(this.channel);

        this.request = UserCreateRequest.newBuilder()
                .setName("This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.")
                .setAge(21)
                .setAadhaar(56784362)
                .setSalary(2343254.21)
                .setIsDev(true)
                .setAddress("This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.")
                .build();
    }

    @Override
    protected void finalize() throws Throwable {
        this.channel.shutdown();

        super.finalize();
    }

    public void connect() {
        UserCreateResponse response = this.stub.create(this.request);
    }
}
