package benchmark;

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
        Options opt = new OptionsBuilder()
                .include(".*" + HttpServerBenchmark.class.getSimpleName() + ".*")
                .warmupIterations(15)
                .measurementIterations(25)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class ServiceInit {
        HttpService httpService = new HttpService();
        GrpcService grpcService = new GrpcService();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureHttpConnection(ServiceInit httpServiceInit) throws InterruptedException {
        httpServiceInit.httpService.connect();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureGrpcConnection(ServiceInit grpcServiceInit) {
        grpcServiceInit.grpcService.connect();
    }
}
