package com.example.gestordecorreos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Definición del servicio GrpsService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.0)",
    comments = "Source: src/main/proto/GrpsService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpsServiceGrpc {

  private GrpsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "gestordecorreos.GrpsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.EmailRequest,
      com.example.gestordecorreos.GrpsServiceProto.Response> getSendEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendEmail",
      requestType = com.example.gestordecorreos.GrpsServiceProto.EmailRequest.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.EmailRequest,
      com.example.gestordecorreos.GrpsServiceProto.Response> getSendEmailMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.EmailRequest, com.example.gestordecorreos.GrpsServiceProto.Response> getSendEmailMethod;
    if ((getSendEmailMethod = GrpsServiceGrpc.getSendEmailMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getSendEmailMethod = GrpsServiceGrpc.getSendEmailMethod) == null) {
          GrpsServiceGrpc.getSendEmailMethod = getSendEmailMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.EmailRequest, com.example.gestordecorreos.GrpsServiceProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.EmailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("SendEmail"))
              .build();
        }
      }
    }
    return getSendEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.InboxRequest,
      com.example.gestordecorreos.GrpsServiceProto.InboxResponse> getGetInboxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInbox",
      requestType = com.example.gestordecorreos.GrpsServiceProto.InboxRequest.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.InboxResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.InboxRequest,
      com.example.gestordecorreos.GrpsServiceProto.InboxResponse> getGetInboxMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.InboxRequest, com.example.gestordecorreos.GrpsServiceProto.InboxResponse> getGetInboxMethod;
    if ((getGetInboxMethod = GrpsServiceGrpc.getGetInboxMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getGetInboxMethod = GrpsServiceGrpc.getGetInboxMethod) == null) {
          GrpsServiceGrpc.getGetInboxMethod = getGetInboxMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.InboxRequest, com.example.gestordecorreos.GrpsServiceProto.InboxResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInbox"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.InboxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.InboxResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("GetInbox"))
              .build();
        }
      }
    }
    return getGetInboxMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SentRequest,
      com.example.gestordecorreos.GrpsServiceProto.SentResponse> getGetSentEmailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSentEmails",
      requestType = com.example.gestordecorreos.GrpsServiceProto.SentRequest.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.SentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SentRequest,
      com.example.gestordecorreos.GrpsServiceProto.SentResponse> getGetSentEmailsMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SentRequest, com.example.gestordecorreos.GrpsServiceProto.SentResponse> getGetSentEmailsMethod;
    if ((getGetSentEmailsMethod = GrpsServiceGrpc.getGetSentEmailsMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getGetSentEmailsMethod = GrpsServiceGrpc.getGetSentEmailsMethod) == null) {
          GrpsServiceGrpc.getGetSentEmailsMethod = getGetSentEmailsMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.SentRequest, com.example.gestordecorreos.GrpsServiceProto.SentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSentEmails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.SentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.SentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("GetSentEmails"))
              .build();
        }
      }
    }
    return getGetSentEmailsMethod;
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
     * <pre>
     * Enviar un correo
     * </pre>
     */
    default void sendEmail(com.example.gestordecorreos.GrpsServiceProto.EmailRequest request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendEmailMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    default void getInbox(com.example.gestordecorreos.GrpsServiceProto.InboxRequest request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.InboxResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInboxMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    default void getSentEmails(com.example.gestordecorreos.GrpsServiceProto.SentRequest request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.SentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSentEmailsMethod(), responseObserver);
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
     * <pre>
     * Enviar un correo
     * </pre>
     */
    public void sendEmail(com.example.gestordecorreos.GrpsServiceProto.EmailRequest request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    public void getInbox(com.example.gestordecorreos.GrpsServiceProto.InboxRequest request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.InboxResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInboxMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    public void getSentEmails(com.example.gestordecorreos.GrpsServiceProto.SentRequest request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.SentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSentEmailsMethod(), getCallOptions()), request, responseObserver);
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
     * <pre>
     * Enviar un correo
     * </pre>
     */
    public com.example.gestordecorreos.GrpsServiceProto.Response sendEmail(com.example.gestordecorreos.GrpsServiceProto.EmailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendEmailMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    public com.example.gestordecorreos.GrpsServiceProto.InboxResponse getInbox(com.example.gestordecorreos.GrpsServiceProto.InboxRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInboxMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    public com.example.gestordecorreos.GrpsServiceProto.SentResponse getSentEmails(com.example.gestordecorreos.GrpsServiceProto.SentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSentEmailsMethod(), getCallOptions(), request);
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
     * <pre>
     * Enviar un correo
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.Response> sendEmail(
        com.example.gestordecorreos.GrpsServiceProto.EmailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendEmailMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.InboxResponse> getInbox(
        com.example.gestordecorreos.GrpsServiceProto.InboxRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInboxMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.SentResponse> getSentEmails(
        com.example.gestordecorreos.GrpsServiceProto.SentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSentEmailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_EMAIL = 0;
  private static final int METHODID_GET_INBOX = 1;
  private static final int METHODID_GET_SENT_EMAILS = 2;

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
        case METHODID_SEND_EMAIL:
          serviceImpl.sendEmail((com.example.gestordecorreos.GrpsServiceProto.EmailRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Response>) responseObserver);
          break;
        case METHODID_GET_INBOX:
          serviceImpl.getInbox((com.example.gestordecorreos.GrpsServiceProto.InboxRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.InboxResponse>) responseObserver);
          break;
        case METHODID_GET_SENT_EMAILS:
          serviceImpl.getSentEmails((com.example.gestordecorreos.GrpsServiceProto.SentRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.SentResponse>) responseObserver);
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
          getSendEmailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.EmailRequest,
              com.example.gestordecorreos.GrpsServiceProto.Response>(
                service, METHODID_SEND_EMAIL)))
        .addMethod(
          getGetInboxMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.InboxRequest,
              com.example.gestordecorreos.GrpsServiceProto.InboxResponse>(
                service, METHODID_GET_INBOX)))
        .addMethod(
          getGetSentEmailsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.SentRequest,
              com.example.gestordecorreos.GrpsServiceProto.SentResponse>(
                service, METHODID_GET_SENT_EMAILS)))
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
              .addMethod(getSendEmailMethod())
              .addMethod(getGetInboxMethod())
              .addMethod(getGetSentEmailsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
