package com.example.grpc.generated;


import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.0)",
    comments = "Source: GrpsService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpsServiceGrpc {

  private GrpsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.gestordecorreos.GrpsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest,
      com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getGetGroupInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGroupInfo",
      requestType = com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest.class,
      responseType = com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest,
      com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getGetGroupInfoMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest, com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getGetGroupInfoMethod;
    if ((getGetGroupInfoMethod = GrpsServiceGrpc.getGetGroupInfoMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getGetGroupInfoMethod = GrpsServiceGrpc.getGetGroupInfoMethod) == null) {
          GrpsServiceGrpc.getGetGroupInfoMethod = getGetGroupInfoMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest, com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGroupInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("GetGroupInfo"))
              .build();
        }
      }
    }
    return getGetGroupInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.generated.GrpsServiceOuterClass.NewGroup,
      com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getAddGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddGroup",
      requestType = com.example.grpc.generated.GrpsServiceOuterClass.NewGroup.class,
      responseType = com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.generated.GrpsServiceOuterClass.NewGroup,
      com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getAddGroupMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.generated.GrpsServiceOuterClass.NewGroup, com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getAddGroupMethod;
    if ((getAddGroupMethod = GrpsServiceGrpc.getAddGroupMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getAddGroupMethod = GrpsServiceGrpc.getAddGroupMethod) == null) {
          GrpsServiceGrpc.getAddGroupMethod = getAddGroupMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.generated.GrpsServiceOuterClass.NewGroup, com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.generated.GrpsServiceOuterClass.NewGroup.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("AddGroup"))
              .build();
        }
      }
    }
    return getAddGroupMethod;
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
   */
  public interface AsyncService {

    /**
     */
    default void getGroupInfo(com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGroupInfoMethod(), responseObserver);
    }

    /**
     */
    default void addGroup(com.example.grpc.generated.GrpsServiceOuterClass.NewGroup request,
        io.grpc.stub.StreamObserver<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddGroupMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GrpsService.
   */
  public static abstract class GrpsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GrpsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GrpsService.
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
    public void getGroupInfo(com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGroupInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addGroup(com.example.grpc.generated.GrpsServiceOuterClass.NewGroup request,
        io.grpc.stub.StreamObserver<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GrpsService.
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
    public com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse getGroupInfo(com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGroupInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse addGroup(com.example.grpc.generated.GrpsServiceOuterClass.NewGroup request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GrpsService.
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> getGroupInfo(
        com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGroupInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse> addGroup(
        com.example.grpc.generated.GrpsServiceOuterClass.NewGroup request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GROUP_INFO = 0;
  private static final int METHODID_ADD_GROUP = 1;

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
        case METHODID_GET_GROUP_INFO:
          serviceImpl.getGroupInfo((com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse>) responseObserver);
          break;
        case METHODID_ADD_GROUP:
          serviceImpl.addGroup((com.example.grpc.generated.GrpsServiceOuterClass.NewGroup) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse>) responseObserver);
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
          getGetGroupInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest,
              com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse>(
                service, METHODID_GET_GROUP_INFO)))
        .addMethod(
          getAddGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.generated.GrpsServiceOuterClass.NewGroup,
              com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse>(
                service, METHODID_ADD_GROUP)))
        .build();
  }

  private static abstract class GrpsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.generated.GrpsServiceOuterClass.getDescriptor();
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
              .addMethod(getGetGroupInfoMethod())
              .addMethod(getAddGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
