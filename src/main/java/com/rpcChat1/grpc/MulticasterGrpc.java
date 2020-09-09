package com.rpcChat1.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chat.proto")
public final class MulticasterGrpc {

  private MulticasterGrpc() {}

  public static final String SERVICE_NAME = "Multicaster";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpcChat1.grpc.Chat.Data,
      com.rpcChat1.grpc.Chat.Empty> getMulticastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Multicast",
      requestType = com.rpcChat1.grpc.Chat.Data.class,
      responseType = com.rpcChat1.grpc.Chat.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpcChat1.grpc.Chat.Data,
      com.rpcChat1.grpc.Chat.Empty> getMulticastMethod() {
    io.grpc.MethodDescriptor<com.rpcChat1.grpc.Chat.Data, com.rpcChat1.grpc.Chat.Empty> getMulticastMethod;
    if ((getMulticastMethod = MulticasterGrpc.getMulticastMethod) == null) {
      synchronized (MulticasterGrpc.class) {
        if ((getMulticastMethod = MulticasterGrpc.getMulticastMethod) == null) {
          MulticasterGrpc.getMulticastMethod = getMulticastMethod = 
              io.grpc.MethodDescriptor.<com.rpcChat1.grpc.Chat.Data, com.rpcChat1.grpc.Chat.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Multicaster", "Multicast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcChat1.grpc.Chat.Data.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpcChat1.grpc.Chat.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new MulticasterMethodDescriptorSupplier("Multicast"))
                  .build();
          }
        }
     }
     return getMulticastMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MulticasterStub newStub(io.grpc.Channel channel) {
    return new MulticasterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MulticasterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MulticasterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MulticasterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MulticasterFutureStub(channel);
  }

  /**
   */
  public static abstract class MulticasterImplBase implements io.grpc.BindableService {

    /**
     */
    public void multicast(com.rpcChat1.grpc.Chat.Data request,
        io.grpc.stub.StreamObserver<com.rpcChat1.grpc.Chat.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getMulticastMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMulticastMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rpcChat1.grpc.Chat.Data,
                com.rpcChat1.grpc.Chat.Empty>(
                  this, METHODID_MULTICAST)))
          .build();
    }
  }

  /**
   */
  public static final class MulticasterStub extends io.grpc.stub.AbstractStub<MulticasterStub> {
    private MulticasterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MulticasterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MulticasterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MulticasterStub(channel, callOptions);
    }

    /**
     */
    public void multicast(com.rpcChat1.grpc.Chat.Data request,
        io.grpc.stub.StreamObserver<com.rpcChat1.grpc.Chat.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMulticastMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MulticasterBlockingStub extends io.grpc.stub.AbstractStub<MulticasterBlockingStub> {
    private MulticasterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MulticasterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MulticasterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MulticasterBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpcChat1.grpc.Chat.Empty multicast(com.rpcChat1.grpc.Chat.Data request) {
      return blockingUnaryCall(
          getChannel(), getMulticastMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MulticasterFutureStub extends io.grpc.stub.AbstractStub<MulticasterFutureStub> {
    private MulticasterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MulticasterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MulticasterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MulticasterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpcChat1.grpc.Chat.Empty> multicast(
        com.rpcChat1.grpc.Chat.Data request) {
      return futureUnaryCall(
          getChannel().newCall(getMulticastMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MULTICAST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MulticasterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MulticasterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MULTICAST:
          serviceImpl.multicast((com.rpcChat1.grpc.Chat.Data) request,
              (io.grpc.stub.StreamObserver<com.rpcChat1.grpc.Chat.Empty>) responseObserver);
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

  private static abstract class MulticasterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MulticasterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpcChat1.grpc.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Multicaster");
    }
  }

  private static final class MulticasterFileDescriptorSupplier
      extends MulticasterBaseDescriptorSupplier {
    MulticasterFileDescriptorSupplier() {}
  }

  private static final class MulticasterMethodDescriptorSupplier
      extends MulticasterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MulticasterMethodDescriptorSupplier(String methodName) {
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
      synchronized (MulticasterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MulticasterFileDescriptorSupplier())
              .addMethod(getMulticastMethod())
              .build();
        }
      }
    }
    return result;
  }
}
