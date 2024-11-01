package com.example.gestordecorreos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Definición del servicio GrpsService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.0)",
    comments = "Source: GrpsService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpsServiceGrpc {

  private GrpsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "gestordecorreos.GrpsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.Request,
      com.example.gestordecorreos.GrpsServiceProto.Response> getYourMethodMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "YourMethod",
      requestType = com.example.gestordecorreos.GrpsServiceProto.Request.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.Request,
      com.example.gestordecorreos.GrpsServiceProto.Response> getYourMethodMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.Request, com.example.gestordecorreos.GrpsServiceProto.Response> getYourMethodMethod;
    if ((getYourMethodMethod = GrpsServiceGrpc.getYourMethodMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getYourMethodMethod = GrpsServiceGrpc.getYourMethodMethod) == null) {
          GrpsServiceGrpc.getYourMethodMethod = getYourMethodMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.Request, com.example.gestordecorreos.GrpsServiceProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "YourMethod"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("YourMethod"))
              .build();
        }
      }
    }
    return getYourMethodMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpsServiceStub>() {
        @java.lang.Override
        public GrpsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpsServiceStub(channel, callOptions);
        }
      };
    return GrpsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpsServiceBlockingStub>() {
        @java.lang.Override
        public GrpsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpsServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpsServiceFutureStub>() {
        @java.lang.Override
        public GrpsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpsServiceFutureStub(channel, callOptions);
        }
      };
    return GrpsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Definición del servicio GrpsService
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void yourMethod(com.example.gestordecorreos.GrpsServiceProto.Request request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getYourMethodMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GrpsService.
   * <pre>
   * Definición del servicio GrpsService
   * </pre>
   */
  public static abstract class GrpsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GrpsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GrpsService.
   * <pre>
   * Definición del servicio GrpsService
   * </pre>
   */
  public static final class GrpsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GrpsServiceStub> {
    private GrpsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpsServiceStub(channel, callOptions);
    }

    /**
     */
    public void yourMethod(com.example.gestordecorreos.GrpsServiceProto.Request request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getYourMethodMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GrpsService.
   * <pre>
   * Definición del servicio GrpsService
   * </pre>
   */
  public static final class GrpsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GrpsServiceBlockingStub> {
    private GrpsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gestordecorreos.GrpsServiceProto.Response yourMethod(com.example.gestordecorreos.GrpsServiceProto.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getYourMethodMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GrpsService.
   * <pre>
   * Definición del servicio GrpsService
   * </pre>
   */
  public static final class GrpsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GrpsServiceFutureStub> {
    private GrpsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.Response> yourMethod(
        com.example.gestordecorreos.GrpsServiceProto.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getYourMethodMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_YOUR_METHOD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_YOUR_METHOD:
          serviceImpl.yourMethod((com.example.gestordecorreos.GrpsServiceProto.Request) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getYourMethodMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.Request,
              com.example.gestordecorreos.GrpsServiceProto.Response>(
                service, METHODID_YOUR_METHOD)))
        .build();
  }

  private static abstract class GrpsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gestordecorreos.GrpsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpsService");
    }
  }

  private static final class GrpsServiceFileDescriptorSupplier
      extends GrpsServiceBaseDescriptorSupplier {
    GrpsServiceFileDescriptorSupplier() {}
  }

  private static final class GrpsServiceMethodDescriptorSupplier
      extends GrpsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GrpsServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpsServiceFileDescriptorSupplier())
              .addMethod(getYourMethodMethod())
              .build();
        }
      }
    }
    return result;
  }
}
