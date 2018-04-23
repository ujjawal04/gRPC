package benchmark;

import io.grpc.Grpc;
import org.openjdk.jmh.annotations.*;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import service.GrpcService;
import service.HttpService;

import java.util.concurrent.TimeUnit;

public class HttpServerBenchmark {
    public static void main(String[] args) throws RunnerException {
//        HttpService httpService = new HttpService("json");
//        httpService.connect();
//        GrpcService grpcService = new GrpcService();
//        grpcService.connect();

        Options opt = new OptionsBuilder()
                .include(".*" + HttpServerBenchmark.class.getSimpleName() + ".*")
                .warmupIterations(15)
                .measurementIterations(25)
                .forks(3)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class ServiceInit {
        HttpService httpService = new HttpService("json");
        HttpService httpGrpcService = new HttpService("grpc");
        GrpcService grpcService = new GrpcService();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void measureHttpConnection(ServiceInit httpServiceInit) throws InterruptedException {
        httpServiceInit.httpService.connect();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void measureHttpGrpcConnection(ServiceInit httpServiceInit) throws InterruptedException {
        httpServiceInit.httpGrpcService.connect();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void measureGrpcConnection(ServiceInit grpcServiceInit) {
        grpcServiceInit.grpcService.connect();
    }
}
