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
  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo,
      com.example.gestordecorreos.GrpsServiceProto.Respuesta> getEnviarCorreoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnviarCorreo",
      requestType = com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.Respuesta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo,
      com.example.gestordecorreos.GrpsServiceProto.Respuesta> getEnviarCorreoMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo, com.example.gestordecorreos.GrpsServiceProto.Respuesta> getEnviarCorreoMethod;
    if ((getEnviarCorreoMethod = GrpsServiceGrpc.getEnviarCorreoMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getEnviarCorreoMethod = GrpsServiceGrpc.getEnviarCorreoMethod) == null) {
          GrpsServiceGrpc.getEnviarCorreoMethod = getEnviarCorreoMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo, com.example.gestordecorreos.GrpsServiceProto.Respuesta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnviarCorreo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.Respuesta.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("EnviarCorreo"))
              .build();
        }
      }
    }
    return getEnviarCorreoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja,
      com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja> getObtenerBandejaEntradaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ObtenerBandejaEntrada",
      requestType = com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja,
      com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja> getObtenerBandejaEntradaMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja, com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja> getObtenerBandejaEntradaMethod;
    if ((getObtenerBandejaEntradaMethod = GrpsServiceGrpc.getObtenerBandejaEntradaMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getObtenerBandejaEntradaMethod = GrpsServiceGrpc.getObtenerBandejaEntradaMethod) == null) {
          GrpsServiceGrpc.getObtenerBandejaEntradaMethod = getObtenerBandejaEntradaMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja, com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ObtenerBandejaEntrada"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("ObtenerBandejaEntrada"))
              .build();
        }
      }
    }
    return getObtenerBandejaEntradaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados,
      com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados> getObtenerCorreosEnviadosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ObtenerCorreosEnviados",
      requestType = com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados.class,
      responseType = com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados,
      com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados> getObtenerCorreosEnviadosMethod() {
    io.grpc.MethodDescriptor<com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados, com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados> getObtenerCorreosEnviadosMethod;
    if ((getObtenerCorreosEnviadosMethod = GrpsServiceGrpc.getObtenerCorreosEnviadosMethod) == null) {
      synchronized (GrpsServiceGrpc.class) {
        if ((getObtenerCorreosEnviadosMethod = GrpsServiceGrpc.getObtenerCorreosEnviadosMethod) == null) {
          GrpsServiceGrpc.getObtenerCorreosEnviadosMethod = getObtenerCorreosEnviadosMethod =
              io.grpc.MethodDescriptor.<com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados, com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ObtenerCorreosEnviados"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados.getDefaultInstance()))
              .setSchemaDescriptor(new GrpsServiceMethodDescriptorSupplier("ObtenerCorreosEnviados"))
              .build();
        }
      }
    }
    return getObtenerCorreosEnviadosMethod;
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
    default void enviarCorreo(com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Respuesta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnviarCorreoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    default void obtenerBandejaEntrada(com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getObtenerBandejaEntradaMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    default void obtenerCorreosEnviados(com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getObtenerCorreosEnviadosMethod(), responseObserver);
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
    public void enviarCorreo(com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Respuesta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnviarCorreoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    public void obtenerBandejaEntrada(com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getObtenerBandejaEntradaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    public void obtenerCorreosEnviados(com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados request,
        io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getObtenerCorreosEnviadosMethod(), getCallOptions()), request, responseObserver);
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
    public com.example.gestordecorreos.GrpsServiceProto.Respuesta enviarCorreo(com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnviarCorreoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    public com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja obtenerBandejaEntrada(com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getObtenerBandejaEntradaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    public com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados obtenerCorreosEnviados(com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getObtenerCorreosEnviadosMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.Respuesta> enviarCorreo(
        com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnviarCorreoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Obtener la bandeja de entrada
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja> obtenerBandejaEntrada(
        com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getObtenerBandejaEntradaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Obtener los correos enviados
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados> obtenerCorreosEnviados(
        com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getObtenerCorreosEnviadosMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENVIAR_CORREO = 0;
  private static final int METHODID_OBTENER_BANDEJA_ENTRADA = 1;
  private static final int METHODID_OBTENER_CORREOS_ENVIADOS = 2;

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
        case METHODID_ENVIAR_CORREO:
          serviceImpl.enviarCorreo((com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.Respuesta>) responseObserver);
          break;
        case METHODID_OBTENER_BANDEJA_ENTRADA:
          serviceImpl.obtenerBandejaEntrada((com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja>) responseObserver);
          break;
        case METHODID_OBTENER_CORREOS_ENVIADOS:
          serviceImpl.obtenerCorreosEnviados((com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados) request,
              (io.grpc.stub.StreamObserver<com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados>) responseObserver);
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
          getEnviarCorreoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.SolicitudCorreo,
              com.example.gestordecorreos.GrpsServiceProto.Respuesta>(
                service, METHODID_ENVIAR_CORREO)))
        .addMethod(
          getObtenerBandejaEntradaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.SolicitudBandeja,
              com.example.gestordecorreos.GrpsServiceProto.RespuestaBandeja>(
                service, METHODID_OBTENER_BANDEJA_ENTRADA)))
        .addMethod(
          getObtenerCorreosEnviadosMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.gestordecorreos.GrpsServiceProto.SolicitudEnviados,
              com.example.gestordecorreos.GrpsServiceProto.RespuestaEnviados>(
                service, METHODID_OBTENER_CORREOS_ENVIADOS)))
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
              .addMethod(getEnviarCorreoMethod())
              .addMethod(getObtenerBandejaEntradaMethod())
              .addMethod(getObtenerCorreosEnviadosMethod())
              .build();
        }
      }
    }
    return result;
  }
}
